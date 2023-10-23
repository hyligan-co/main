package com.ukrainians.services.impl;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.repository.RegistrationRepository;
import com.ukrainians.services.RegistrationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository,
                                   PasswordEncoder passwordEncoder) {
        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserInfoResponse register(UserInfoEntity userInfoRequest) {
        Optional<String> nickName = registrationRepository.existsByNickName(userInfoRequest.getNickName());
        Optional<String> email = registrationRepository.existsByEmail(userInfoRequest.getEmail());

        if (nickName.isPresent() || email.isPresent()) {
            return UserInfoResponse.builder()
                    .error(getCorrectError(userInfoRequest, nickName))
                    .build();
        }

        userInfoRequest.setPassword(passwordEncoder.encode(userInfoRequest.getPassword()));
        registrationRepository.save(userInfoRequest);
        String success = "Registration successful. Please check your email to activate your account";
        return UserInfoResponse.builder()
                .message(success)
                .build();
    }

    private static String getCorrectError(UserInfoEntity request, Optional<String> anyInfo) {
        final String nickNameTaken = String.format("Username %s already taken",
                request.getNickName());
        final String emailTaken = String.format("Email %s already taken",
                request.getEmail());
        return anyInfo.isPresent() ? nickNameTaken : emailTaken;
    }

}
