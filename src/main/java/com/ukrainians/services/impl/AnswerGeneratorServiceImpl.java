package com.ukrainians.services.impl;

import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.services.AnswerGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class AnswerGeneratorServiceImpl implements AnswerGeneratorService {

    @Override
    public UserInfoResponse getMessageResponse(String message) {
        return UserInfoResponse.builder()
                .message(message)
                .build();
    }

    @Override
    public UserInfoResponse getErrorResponse(String message) {
        return UserInfoResponse.builder()
                .error(message)
                .build();
    }
}
