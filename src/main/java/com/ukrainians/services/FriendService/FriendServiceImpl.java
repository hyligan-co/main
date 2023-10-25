package com.ukrainians.services.FriendService;

import com.ukrainians.controller.Friend.FriendRequest;
import com.ukrainians.entity.FriendRequestEntity;
import com.ukrainians.exeption.UserNotFoundException;
import com.ukrainians.repository.FriendRepository;
import com.ukrainians.entity.User;
import com.ukrainians.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService {
    private final UsersRepository usersRepository;
    private final FriendRepository friendRequestRepository;

    @Autowired
    public FriendServiceImpl(UsersRepository usersRepository, FriendRepository friendRequestRepository) {
        this.usersRepository = usersRepository;
        this.friendRequestRepository = friendRequestRepository;
    }

    @Override //список дрзів юзера
    public List<User> getFriends(Long userId) {
        return null;
    }


    @Override // видалити друга
    public void deleteFriends(Long userId) {
    }

    @Override //надіслати запит на додавання друзів
    public boolean sendFriendRequest(Long user_id , FriendRequest friendRequest) {
        Long senderId = user_id;
        Long receiverId = friendRequest.getReceiver_id();
        // перевірка відправника
        if (!friendRequestRepository.existsById(senderId)) {
            throw new UserNotFoundException("Sender user not found");
        }
        // перевірка отримувача
        if (!friendRequestRepository.existsById(receiverId)) {
            throw new UserNotFoundException("Receiver user not found");
        }
        // перевірка чи був вже відправлен запит
        if (friendRequestRepository.existsBySenderIdAndReceiverId(senderId, receiverId)) {
            return false;
        }
        // запит на дружбу
        FriendRequestEntity friendRequestEntity = new FriendRequestEntity(senderId, receiverId);
        friendRequestRepository.save(friendRequestEntity);
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
