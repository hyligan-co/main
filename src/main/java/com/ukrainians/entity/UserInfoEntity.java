package com.ukrainians.entity;


import com.ukrainians.validation.EmailValid;
import com.ukrainians.validation.NickNameValid;
import com.ukrainians.validation.PasswordValid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Getter
@Setter
@Entity
@Table(name = "user_info", schema = UKRAINIANS)
public class UserInfoEntity {

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

    @Column(name = "enabled")
    private boolean enabled;

    public UserInfoEntity() {
        super();
        this.enabled = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoEntity that = (UserInfoEntity) o;
        return Objects.equals(nickName, that.nickName) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, email, password);
    }
}
