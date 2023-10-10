package com.ukrainians.services.FriendService;

import com.ukrainians.controller.Friend.FriendRequest;
import com.ukrainians.entity.User;

import java.util.List;

public interface FriendService {
    List<User> getFriends(Long userId);
    void deleteFriends(Long userId);
    void sendFriendRequest(FriendRequest friendRequest);
    List<FriendRequest> getReceivedFriendRequests(Long userId);
    void acceptFriendRequest(Long requestId);
    void rejectFriendRequest(Long requestId);
}
