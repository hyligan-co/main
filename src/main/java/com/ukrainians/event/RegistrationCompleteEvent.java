package com.ukrainians.event;

import com.ukrainians.entity.UserInfoEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private UserInfoEntity userInfo;
    private String appURL;

    public RegistrationCompleteEvent(
            UserInfoEntity userInfo, String appURL) {
        super(userInfo);

        this.userInfo = userInfo;
        this.appURL = appURL;
    }
}
