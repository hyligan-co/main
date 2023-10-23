package com.ukrainians.controller;

import com.ukrainians.dto.FriendRequest;
import com.ukrainians.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/friends")
public interface FriendController {
    @GetMapping("/{userId}") //список друзів
    public List<UserEntity> getFriends(@PathVariable Long userId);

    @PostMapping("/send") // надіслати запит на додавання
    public ResponseEntity<Object> sendFriendRequest(@RequestBody FriendRequest friendRequest);

    @DeleteMapping("/delete") // видалити друга
    public ResponseEntity<Object> deleteFriend(@PathVariable Long userId);

    @GetMapping("/received") // отпримати запит на додавання
    public List<FriendRequest> getReceivedFriendRequests(@RequestParam Long userId);

    @PutMapping("/{requestId}/accept")// прийняти друга
    public ResponseEntity<Object> acceptFriendRequest(@PathVariable Long requestId);

    @DeleteMapping("/{requestId}/reject")// відхилити запит
    public ResponseEntity<Object> rejectFriendRequest(@PathVariable Long requestId);


}