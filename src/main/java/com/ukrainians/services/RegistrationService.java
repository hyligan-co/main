package com.ukrainians.services;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.dto.UserInfoResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface RegistrationService {
    UserInfoResponse register(UserInfoEntity user, final HttpServletRequest request);
}
