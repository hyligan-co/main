package com.ukrainians.event.listener;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.event.RegistrationCompleteEvent;
import com.ukrainians.services.VerificationService;
import jakarta.mail.MessagingException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final VerificationService verificationService;

    private final MailSender mailSender;

    private UserInfoEntity userInfo;

    @Value("${email}")
    private String email;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        final String verifyEndPoint = "/registration/verifyEmail?token=";

        userInfo = event.getUserInfo();
        String token = UUID.randomUUID().toString();
        verificationService.save(token, userInfo);
        String url = event.getAppURL() + verifyEndPoint + token;

        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        log.info("Click the link to verify your registration :  {}", url);
    }

    public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email Verification";
        String separate = System.lineSeparator();
        String mailContent = "Hi, " + userInfo.getNickName() + "!" + separate +
                "Please, follow the link below to complete your registration." + separate +
                 url + separate +
                "Thank you!";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(userInfo.getEmail());
        message.setSubject(subject);
        message.setText(mailContent);
        mailSender.send(message);
    }
}

