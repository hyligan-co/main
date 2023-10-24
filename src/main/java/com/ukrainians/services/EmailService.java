package com.ukrainians.services;

import com.ukrainians.entity.UserInfoEntity;
import jakarta.servlet.http.HttpServletRequest;

public interface EmailService {
    void sendActivationMessage(UserInfoEntity userInfo, final HttpServletRequest request);
}
