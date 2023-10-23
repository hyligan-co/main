package com.ukrainians.dto;


import com.ukrainians.validation.EmailValid;
import com.ukrainians.validation.PasswordValid;
import com.ukrainians.validation.NickNameValid;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoRequest {

    @Id
    @NickNameValid
    @Column(name = "NICK_NAME")
    private String nickName;

    @EmailValid
    @Column(name = "EMAIL")
    private String email;

    @PasswordValid
    @Column(name = "PASSWORD")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoRequest that = (UserInfoRequest) o;
        return Objects.equals(nickName, that.nickName) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, email, password);
    }
}
