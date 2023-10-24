package com.ukrainians.services.impl;

import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.entity.VerificationTokenEntity;
import com.ukrainians.repository.RegistrationRepository;
import com.ukrainians.repository.VerificationTokenRepository;
import com.ukrainians.services.AnswerGeneratorService;
import com.ukrainians.services.EmailService;
import com.ukrainians.services.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationTokenRepository verificationTokenRepository;
    private final RegistrationRepository registrationRepository;
    private final AnswerGeneratorService answerGeneratorService;
    private final EmailService emailService;

    public VerificationServiceImpl(VerificationTokenRepository verificationTokenRepository,
                                   RegistrationRepository registrationRepository,
                                   AnswerGeneratorService answerGeneratorService,
                                   EmailService emailService) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.registrationRepository = registrationRepository;
        this.answerGeneratorService = answerGeneratorService;
        this.emailService = emailService;
    }

    @Override
    public Optional<VerificationTokenEntity> findByToken(String token) {
        return verificationTokenRepository.findVerificationTokenEntitiesByToken(token);
    }

    @Override
    public Optional<VerificationTokenEntity> findByUserInfo(UserInfoEntity userInfo) {
        return verificationTokenRepository.findVerificationTokenEntitiesByUserInfo(userInfo);
    }

    @Override
    public void save(String token, UserInfoEntity userInfo) {
        VerificationTokenEntity verificationToken = new VerificationTokenEntity(token, userInfo);
        verificationToken.setNickName(userInfo.getNickName());
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public UserInfoResponse verifyToken(String token, HttpServletRequest request) {
        Optional<VerificationTokenEntity> currentToken = verificationTokenRepository.findVerificationTokenEntitiesByToken(token);
        boolean enabled = currentToken.get().getUserInfo().isEnabled();

        if (enabled) {
            String accountAlreadyVerified = "This account has already been verified, please, login.";
            return answerGeneratorService.getErrorResponse(accountAlreadyVerified);
        }
        UserInfoResponse infoResponse = validateToken(token, request);
        String message = infoResponse.getMessage();
        if (message != null && message.equalsIgnoreCase("valid")) {
            String success = "Email verified successfully. Now you can login to your account";
            return answerGeneratorService.getMessageResponse(success);
        }
        return infoResponse;
    }

    @Override
    public UserInfoResponse validateToken(String token, HttpServletRequest request) {
        Optional<VerificationTokenEntity> verificationToken = verificationTokenRepository.findVerificationTokenEntitiesByToken(token);
        if (verificationToken.isEmpty()) {
            String invalidVerification = "Invalid verification token";
            return answerGeneratorService.getErrorResponse(invalidVerification);
        }
        UserInfoEntity user = verificationToken.get().getUserInfo();
        LocalDateTime now = LocalDateTime.now();
        if (verificationToken.get().getExpiryDate().isBefore(now)){
            String alreadyExpired = "Token already expired";
            verificationTokenRepository.deleteByToken(token);
            return answerGeneratorService.getErrorResponse(alreadyExpired);
        }
        user.setEnabled(true);
        registrationRepository.save(user);
        String valid = "valid";
        return answerGeneratorService.getMessageResponse(valid);
    }
}
