package com.ukrainians.controller;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.dto.UserInfoResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/registration")
public interface RegistrationController {

    @GetMapping // перейти на форму реестрації
    String showRegistrationForm(UserInfoEntity user);

    @PostMapping // заруєструвати юзера
    ResponseEntity<UserInfoResponse> registration(@Valid @RequestBody UserInfoEntity user,
                                                  HttpServletRequest request);

    @GetMapping("/verifyEmail") // перевірка верифікаії email
    ResponseEntity<UserInfoResponse> verifyEmail(@RequestParam("token") String token,
                                                 HttpServletRequest request);

}
