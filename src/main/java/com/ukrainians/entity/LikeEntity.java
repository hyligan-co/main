package com.ukrainians.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Data
@Entity
@Table(name = "likes", schema = UKRAINIANS)
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "timestamp")
    private Date timestamp;
}
