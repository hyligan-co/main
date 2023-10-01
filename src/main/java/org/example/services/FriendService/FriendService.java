package org.example.services.FriendService;

import org.example.controller.Friend.FriendRequest;
import org.example.entity.User;
import org.example.repository.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendService implements FriendSrvc {

    public FriendService(FriendRepository friendRepository) {
    }

    @Override //список дрзів юзера
    public List<User> getFriends(Long userId) {
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
