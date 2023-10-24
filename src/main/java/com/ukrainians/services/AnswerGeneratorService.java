package com.ukrainians.services;

import com.ukrainians.dto.UserInfoResponse;

public interface AnswerGeneratorService {

    UserInfoResponse getMessageResponse(String message);

    UserInfoResponse getErrorResponse(String message);
}
