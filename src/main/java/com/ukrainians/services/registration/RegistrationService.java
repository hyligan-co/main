package com.ukrainians.services.registration;

import com.ukrainians.dto.UserInfoRequest;
import com.ukrainians.dto.UserInfoResponse;

public interface RegistrationService {
    UserInfoResponse register(UserInfoRequest user);
}
