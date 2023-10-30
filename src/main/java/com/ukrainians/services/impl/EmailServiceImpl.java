package com.ukrainians.services.impl;

import com.ukrainians.event.RegistrationCompleteEvent;
import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.entity.VerificationTokenEntity;
import com.ukrainians.services.EmailService;
import com.ukrainians.services.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    private final ApplicationEventPublisher eventPublisher;

    public EmailServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void sendActivationMessage(UserInfoEntity userInfo, HttpServletRequest request) {
        eventPublisher.publishEvent(new RegistrationCompleteEvent(userInfo,
                applicationUrl(request)));
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    }
}
