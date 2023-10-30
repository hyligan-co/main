package com.ukrainians.services.impl;

import com.ukrainians.dto.FriendRequest;
import com.ukrainians.entity.UserEntity;
import com.ukrainians.frienships.FriendshipStatus;
import com.ukrainians.frienships.FriendshipsEntity;
import com.ukrainians.frienships.FriendshipsRepository;
import com.ukrainians.services.FriendService;
import com.ukrainians.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FriendServiceImpl implements FriendService {

    private final FriendshipsRepository friendRepository;
    private final UserService userService;

    @Autowired
    public FriendServiceImpl(FriendshipsRepository friendRepository, UserService userService) {
        this.friendRepository = friendRepository;
        this.userService = userService;

    }

    @Override
    public List<UserEntity> getFriends(Long userId) {
        List<FriendshipsEntity> friendships = friendRepository.findAllByRequesterIdOrSupplierIdAndStatus(userId, userId, FriendshipStatus.ACCEPTED);

        List<Long> friendIds = friendships.stream()
                .map(friendship -> {
                    if (friendship.getRequester().getId().equals(userId)) {
                        return friendship.getSupplier().getId();
                    } else {
                        return friendship.getRequester().getId();
                    }
                })
                .toList();

        return userService.findAllById(friendIds);
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
