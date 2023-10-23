package com.ukrainians.controller;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.dto.UserInfoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RegistrationController {

    @GetMapping("/registration") // перейти на форму реестрації
    String showRegistrationForm(UserInfoEntity user);

    @PostMapping("/registration") // заруєструвати юзера
    ResponseEntity<UserInfoResponse> registration(@Valid @RequestBody UserInfoEntity user);

}
