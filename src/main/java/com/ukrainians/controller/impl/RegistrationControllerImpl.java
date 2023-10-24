package com.ukrainians.controller.impl;

import com.ukrainians.controller.RegistrationController;
import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.services.RegistrationService;
import com.ukrainians.services.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationControllerImpl implements RegistrationController {

    private final RegistrationService registrationService;
    private final VerificationService verificationService;

    public RegistrationControllerImpl(RegistrationService registrationService,
                                      VerificationService verificationService) {
        this.registrationService = registrationService;
        this.verificationService = verificationService;
    }

    @Override
    public String showRegistrationForm(UserInfoEntity user) {
        return "registration";
    }

    @Override
    public ResponseEntity<UserInfoResponse> registration(
            UserInfoEntity user, HttpServletRequest request) {
        return ResponseEntity.ok(registrationService.register(user, request));
    }

    @Override
    public ResponseEntity<UserInfoResponse> verifyEmail(
            String token, HttpServletRequest request) {
        return ResponseEntity.ok(verificationService.verifyToken(token, request));
    }
}
