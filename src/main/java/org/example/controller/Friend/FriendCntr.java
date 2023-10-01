package org.example.controller.Friend;

import org.example.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FriendCntr {
    public List<User> getFriends(@PathVariable Long userId);
    public ResponseEntity<Object> sendFriendRequest(@RequestBody FriendRequest friendRequest);
    public ResponseEntity<Object> deleteFriend (@PathVariable Long userId);
    public List<FriendRequest> getReceivedFriendRequests(@RequestParam Long userId);
    public ResponseEntity<Object> acceptFriendRequest(@PathVariable Long requestId);
    public ResponseEntity<Object> rejectFriendRequest(@PathVariable Long requestId);


}