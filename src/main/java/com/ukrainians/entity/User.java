package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;


import java.util.Date;

@Entity
@Table(name = "USERS")
@Where(clause = "DELETED = 1")
@Data
public class User {
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

}
