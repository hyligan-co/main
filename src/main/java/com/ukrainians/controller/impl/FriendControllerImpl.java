package com.ukrainians.controller.impl;

import com.ukrainians.dto.FriendRequest;
import com.ukrainians.controller.FriendController;
import com.ukrainians.entity.UserEntity;
import com.ukrainians.message.ApiResponse;
import com.ukrainians.services.impl.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendControllerImpl implements FriendController {

    @Autowired
    private FriendServiceImpl friendService;

    @Override
    public List<UserEntity> getFriends(@PathVariable Long userId) {
        return friendService.getFriends(userId);
    }

    @Override
    public ResponseEntity<Object> sendFriendRequest(@PathVariable Long user_id, @RequestBody FriendRequest friendRequest) {
        boolean requestSent = friendService.sendFriendRequest(user_id, friendRequest);

        if (requestSent) {
            return ResponseEntity.ok(new ApiResponse("Friend request sent successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Friend request already sent or user does not exist."));
        }
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