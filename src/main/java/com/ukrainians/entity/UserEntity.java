package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.Objects;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Entity
@Table(name = "USERS", schema = UKRAINIANS)
@Where(clause = "DELETED = 1")
@Setter
@Getter
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nickName, that.nickName) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(deleted, that.deleted) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate) && Objects.equals(bio, that.bio) && Objects.equals(avatar_url, that.avatar_url) && Objects.equals(cover_photo_url, that.cover_photo_url);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", bio='" + bio + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", cover_photo_url='" + cover_photo_url + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, firstName, lastName, deleted, createDate, updateDate, bio, avatar_url, cover_photo_url);
    }
}
