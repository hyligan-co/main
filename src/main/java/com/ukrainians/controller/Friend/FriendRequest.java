package com.ukrainians.controller.Friend;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FriendRequest {
    private Long senderUserId;
    private Long receiverUserId;

}
