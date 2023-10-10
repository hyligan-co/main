package com.ukrainians.controller.Friend;

import com.ukrainians.entity.User;
import com.ukrainians.services.FriendService.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendControllerImpl implements FriendController {

    @Autowired
    private FriendServiceImpl friendService;

    @Override
    public List<User> getFriends(@PathVariable Long userId) {
        return friendService.getFriends(userId);
    }

    @Override
    public ResponseEntity<Object> sendFriendRequest(@RequestBody FriendRequest friendRequest) {
        friendService.sendFriendRequest(friendRequest);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Object> deleteFriend(@PathVariable Long userId) {
        friendService.deleteFriends(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<FriendRequest> getReceivedFriendRequests(@RequestParam Long userId) {
        return friendService.getReceivedFriendRequests(userId);
    }

    @Override
    public ResponseEntity<Object> acceptFriendRequest(@PathVariable Long requestId) {
        friendService.acceptFriendRequest(requestId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Object> rejectFriendRequest(@PathVariable Long requestId) {
        friendService.rejectFriendRequest(requestId);
        return ResponseEntity.ok().build();
    }
}