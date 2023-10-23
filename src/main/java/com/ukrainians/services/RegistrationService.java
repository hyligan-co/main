package com.ukrainians.services;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.dto.UserInfoResponse;

public interface RegistrationService {
    UserInfoResponse register(UserInfoEntity user);
}
