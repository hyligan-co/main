package com.ukrainians.services;

import com.ukrainians.dto.FriendRequest;
import com.ukrainians.entity.UserEntity;

import java.util.List;

public interface FriendService {
    List<UserEntity> getFriends(Long userId);
    void deleteFriends(Long userId);
    void sendFriendRequest(FriendRequest friendRequest);
    List<FriendRequest> getReceivedFriendRequests(Long userId);
    void acceptFriendRequest(Long requestId);
    void rejectFriendRequest(Long requestId);
}
