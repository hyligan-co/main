package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;


import java.util.Date;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Entity
@Table(name = "USERS", schema = UKRAINIANS)
@Where(clause = "DELETED = 1")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DELETED")
    private Integer deleted;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "BIO")
    private String bio;

    @Column(name = "AVATAR_URL")
    private String avatar_url;

    @Column(name = "COVER_PHOTO_URL")
    private String cover_photo_url;

}
