package com.ukrainians.services.impl;

import com.ukrainians.dto.FriendRequest;
import com.ukrainians.repository.FriendRepository;
import com.ukrainians.entity.UserEntity;
import com.ukrainians.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;

    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override //список дрзів юзера
    public List<UserEntity> getFriends(Long userId) {
        return null;
    }


    @Override // видалити друга
    public void deleteFriends(Long userId) {
    }

    @Override //надіслати запит на додавання друзів
    public void sendFriendRequest(FriendRequest friendRequest) {
    }

    @Override // отримати запит на додавання
    public List<FriendRequest> getReceivedFriendRequests(Long userId) {
        return null;
    }

    @Override //прийняти запрос
    public void acceptFriendRequest(Long requestId) {
    }

    @Override //відхитили запит
    public void rejectFriendRequest(Long requestId) {
    }
}
