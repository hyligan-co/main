package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Entity
@Data
@Table(name = "POST", schema = UKRAINIANS)
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "CONTENT", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "created_at")
    private Timestamp createdAt;
}