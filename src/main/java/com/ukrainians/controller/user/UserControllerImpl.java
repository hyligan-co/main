package com.ukrainians.controller.user;

import com.ukrainians.repository.UsersRepository;
import com.ukrainians.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            // Якщо користувача з вказаним id не знайдено, поверніть HTTP статус 404 (Not Found).
            return ResponseEntity.notFound().build();
        }

        User existingUser = optionalUser.get();
        // existingUser.setEmail(updatedUser.getEmail()); дописати поля на оновлення

        // зберігання користувача
        User updatedUserInDb = userRepository.save(existingUser);

        // оновлений користувач
        return ResponseEntity.ok(updatedUserInDb);
    }

    @Override
       public ResponseEntity<Object> deactivateUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            // Якщо користувача з вказаним id не знайдено, поверніть HTTP статус 404 (Not Found).
            return ResponseEntity.notFound().build();
        }

        User existingUser = optionalUser.get();
        existingUser.setDeleted(0);

        User deactivatedUser = userRepository.save(existingUser);

        return ResponseEntity.ok(deactivatedUser);
    }
}
