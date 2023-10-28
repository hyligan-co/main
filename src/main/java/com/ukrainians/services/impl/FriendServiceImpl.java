package com.ukrainians.services.impl;

import com.ukrainians.dto.FriendRequest;
import com.ukrainians.entity.FriendRequestEntity;
import com.ukrainians.message.UserNotFoundException;
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
    public boolean sendFriendRequest(Long user_id, FriendRequest friendRequest) {
        Long senderId = friendRequest.getSenderUserId();
        Long receiverId = friendRequest.getReceiverUserId();
        // перевірка відправника
        if (!friendRepository.existsById(senderId)) {
            throw new UserNotFoundException("Sender user not found");
        }
        // перевірка отримувача
        if (!friendRepository.existsById(receiverId)) {
            throw new UserNotFoundException("Receiver user not found");
        }
        // перевірка чи був вже відправлен запит
        if (friendRepository.existsBySenderIdAndReceiverId(senderId, receiverId)) {
            return false;
        }
        // запит на дружбу
        FriendRequestEntity friendRequestEntity = new FriendRequestEntity(senderId, receiverId);
        friendRepository.save(friendRequestEntity);
        return true;
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
