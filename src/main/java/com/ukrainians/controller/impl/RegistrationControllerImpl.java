package com.ukrainians.controller.impl;

import com.ukrainians.controller.RegistrationController;
import com.ukrainians.dto.UserInfoRequest;
import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.services.registration.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationControllerImpl implements RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationControllerImpl(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public String showRegistrationForm(UserInfoRequest user) {
        return "registration";
    }

    @Override
    public ResponseEntity<UserInfoResponse> registration(UserInfoRequest user) {
        return ResponseEntity.ok(registrationService.register(user));
    }
}
