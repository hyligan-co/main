package com.ukrainians.services.FriendService;

import com.ukrainians.entity.FriendRequest;
import com.ukrainians.entity.User;

import java.util.List;

public interface FriendService {
    List<User> getFriends(Long userId);
    void deleteFriends(Long userId);
    boolean sendFriendRequest(Long user_id , FriendRequest friendRequest);
    List<FriendRequest> getReceivedFriendRequests(Long userId);
    void acceptFriendRequest(Long requestId);
    void rejectFriendRequest(Long requestId);
}
