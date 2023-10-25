package com.ukrainians.controller.impl;

import com.ukrainians.controller.UserController;
import com.ukrainians.repository.UsersRepository;
import com.ukrainians.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserEntity getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserEntity updatedUser) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            // Якщо користувача з вказаним id не знайдено, поверніть HTTP статус 404 (Not Found).
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<String, String>() {{
                put("error", "User not found.");
            }});
        }

        UserEntity existingUser = optionalUser.get();
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setBio(updatedUser.getBio());
        existingUser.setAvatar_url(updatedUser.getAvatar_url());
        existingUser.setCover_photo_url(updatedUser.getCover_photo_url());

        // зберігання користувача
        UserEntity updatedUserInDb = userRepository.save(existingUser);
        if (updatedUserInDb != null) {
            // В случае успешного обновления, вернуть сообщение
            return ResponseEntity.ok(new HashMap<String, String>() {{
                put("message", "Profile updated successfully.");
            }});
        } else {
            // В случае несанкционированного доступа, вернуть ошибку
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new HashMap<String, String>() {{
                put("error", "Unauthorized access.");
            }});
        }
    }

    @Override
       public ResponseEntity<Object> deactivateUser(@PathVariable Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            // Якщо користувача з вказаним id не знайдено, поверніть HTTP статус 404 (Not Found).
            return ResponseEntity.notFound().build();
        }

        UserEntity existingUser = optionalUser.get();
        existingUser.setDeleted(0);

        UserEntity deactivatedUser = userRepository.save(existingUser);

        return ResponseEntity.ok(deactivatedUser);
    }
}
