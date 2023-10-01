package org.example.controller.Friend;

import lombok.Data;

@Data
public class FriendRequest {
    private Long senderUserId;
    private Long receiverUserId;
}
