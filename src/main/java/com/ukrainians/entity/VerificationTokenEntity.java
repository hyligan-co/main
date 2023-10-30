package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Getter
@Setter
@Entity
@Table(name = "verification_token", schema = UKRAINIANS)
public class VerificationTokenEntity {

    @Id
    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "EXPIRY_DATE")
    private LocalDateTime expiryDate;

    @OneToOne(targetEntity = UserInfoEntity.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "NICK_NAME", referencedColumnName = "NICK_NAME")
    private UserInfoEntity userInfo;


    public VerificationTokenEntity(String token, UserInfoEntity userInfo) {
        this.expiryDate = LocalDateTime.now().plusDays(1);
        this.token = token;
        this.userInfo = userInfo;
    }

    public VerificationTokenEntity() {

    }
}
