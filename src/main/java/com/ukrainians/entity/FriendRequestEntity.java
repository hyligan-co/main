package com.ukrainians.entity;

import jakarta.persistence.*;

@Entity
public class FriendRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "request_status")
    private RequestStatus requestStatus;

    public FriendRequestEntity(Long senderId, Long receiverId) {
    }

    public FriendRequestEntity() {

    }
}