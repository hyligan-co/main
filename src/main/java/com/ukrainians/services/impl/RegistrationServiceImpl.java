package com.ukrainians.services.impl;

import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.entity.VerificationTokenEntity;
import com.ukrainians.repository.RegistrationRepository;
import com.ukrainians.services.AnswerGeneratorService;
import com.ukrainians.services.EmailService;
import com.ukrainians.services.RegistrationService;
import com.ukrainians.services.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final RegistrationRepository registrationRepository;
    private final VerificationService verificationService;
    private final EmailService emailService;
    private final AnswerGeneratorService answerGeneratorService;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository,
                                   PasswordEncoder passwordEncoder,
                                   VerificationService verificationService,
                                   EmailService emailService,
                                   AnswerGeneratorService answerGeneratorService) {
        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationService = verificationService;
        this.emailService = emailService;
        this.answerGeneratorService = answerGeneratorService;
    }

    @Override
    public UserInfoResponse register(UserInfoEntity userInfo, HttpServletRequest request) {
        Optional<String> nickName = registrationRepository.existsByNickName(userInfo.getNickName());
        Optional<String> email = registrationRepository.existsByEmail(userInfo.getEmail());

        if (nickName.isPresent() || email.isPresent()) {
            String error = getCorrectError(userInfo, nickName);
            return answerGeneratorService.getErrorResponse(error);
        }

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        registrationRepository.save(userInfo);

        String token = UUID.randomUUID().toString();
        verificationService.save(token, userInfo);
        Optional<VerificationTokenEntity> verificationToken = verificationService.findByUserInfo(userInfo);

        if (verificationToken.isPresent()) {
            emailService.sendActivationMessage(userInfo, request);
        }

        final String success = "Registration successful. Please check your email to activate your account";
        return answerGeneratorService.getMessageResponse(success);
    }

    private static String getCorrectError(UserInfoEntity request, Optional<String> anyInfo) {
        final String nickNameTaken = String.format("Username %s already taken",
                request.getNickName());
        final String emailTaken = String.format("Email %s already taken",
                request.getEmail());
        return anyInfo.isPresent() ? nickNameTaken : emailTaken;
    }

}
