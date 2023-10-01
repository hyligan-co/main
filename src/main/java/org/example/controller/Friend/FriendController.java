package org.example.controller.Friend;

import org.example.entity.User;
import org.example.services.FriendService.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController implements FriendCntr {

    @Autowired
    private FriendService friendService;

    @Override
    @GetMapping("/{userId}") //список друзів
    public List<User> getFriends(@PathVariable Long userId) {
        return friendService.getFriends(userId);
    }
    @Override
    @PostMapping("/send") // надіслати запит на додавання
    public ResponseEntity<Object> sendFriendRequest(@RequestBody FriendRequest friendRequest) {
        friendService.sendFriendRequest(friendRequest);
        return ResponseEntity.ok().build();
    }
    @Override
    @DeleteMapping("/{userId}/delete") // видалити друга
    public ResponseEntity<Object> deleteFriend (@PathVariable Long userId) {
        friendService.deleteFriends(userId);
        return ResponseEntity.ok().build();
    }
    @Override
    @GetMapping("/received") // отпримати запит на додавання
    public List<FriendRequest> getReceivedFriendRequests(@RequestParam Long userId) {
        return friendService.getReceivedFriendRequests(userId);
    }
    @Override
    @PutMapping("/{requestId}/accept")// прийняти друга
    public ResponseEntity<Object> acceptFriendRequest(@PathVariable Long requestId) {
        friendService.acceptFriendRequest(requestId);
        return ResponseEntity.ok().build();
    }
    @Override
    @DeleteMapping("/{requestId}/reject")// відхилити запит
    public ResponseEntity<Object> rejectFriendRequest(@PathVariable Long requestId) {
        friendService.rejectFriendRequest(requestId);
        return ResponseEntity.ok().build();
    }
}