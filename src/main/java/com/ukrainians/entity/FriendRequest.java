package com.ukrainians.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FriendRequest {
    private Long sender_id;
    private Long receiver_id;

}