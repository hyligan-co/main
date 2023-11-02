package com.ukrainians.frienships;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ukrainians.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.ukrainians.utils.Constants.UKRAINIANS;

@Data
@Entity
@Table(name = "friendships", schema = UKRAINIANS)
public class FriendshipsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id")
    private Long friendshipId;


    @ManyToOne
    @JoinColumn(name = "user1_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity requester;


    @ManyToOne
    @JoinColumn(name = "user2_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity receiver;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FriendshipStatus status;

    @Column(name = "timestamp")
    private Date timestamp;

}
