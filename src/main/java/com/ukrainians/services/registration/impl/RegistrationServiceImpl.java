package com.ukrainians.services.registration.impl;

import com.ukrainians.dto.UserInfoRequest;
import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.repository.RegistrationRepository;
import com.ukrainians.services.registration.RegistrationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public UserInfoResponse register(UserInfoRequest userInfoRequest) {
        boolean userNameExist = registrationRepository.existsUserInfoRequestByNickName(userInfoRequest.getNickName());
        boolean emailExist = registrationRepository.existsUserInfoRequestByEmail(userInfoRequest.getEmail());

        if (userNameExist || emailExist) {
            return UserInfoResponse.builder()
                    .error(getCorrectError(userInfoRequest, userNameExist))
                    .build();
        }

        userInfoRequest.setPassword(passwordEncoder.encode(userInfoRequest.getPassword()));
        registrationRepository.save(userInfoRequest);
        String success = "Registration successful. Please check your email to activate your account";
        return UserInfoResponse.builder()
                .message(success)
                .build();
    }

    private static String getCorrectError(UserInfoRequest request, boolean existParam) {
        final String userNameTaken = String.format("Username %s already taken",
                request.getNickName());
        final String emailTaken = String.format("Email %s already taken",
                request.getEmail());
        return existParam ? userNameTaken : emailTaken;
    }

}
