package org.example.services.FriendService;

import org.example.controller.Friend.FriendRequest;
import org.example.entity.User;

import java.util.List;

public interface FriendSrvc {
    List<User> getFriends(Long userId);
    void deleteFriends(Long userId);
    void sendFriendRequest(FriendRequest friendRequest);
    List<FriendRequest> getReceivedFriendRequests(Long userId);
    void acceptFriendRequest(Long requestId);
    void rejectFriendRequest(Long requestId);
}
