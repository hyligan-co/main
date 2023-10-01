package org.example.controller.user;

import org.example.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface UserCntr {

    User getUser(@PathVariable Long id);
    User createUser(@RequestBody User user);
    ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User updatedUser);
    public ResponseEntity<Object> deactivateUser(@PathVariable Long id);
}
