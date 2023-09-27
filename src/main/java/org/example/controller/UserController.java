package org.example.controller;

import org.example.entity.User;
import org.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController implements UserCntr{

    @Autowired
    private UsersRepository userRepository;

    @Override
    @GetMapping("/{id}") //сторінка юзера
    public User getUser(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @PostMapping("/create")//створити юзера
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @Override
    @PostMapping("/{id}/update")//оновити юзера
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
    @DeleteMapping("/{id}/delete")//деактивувати юзера
    public ResponseEntity<Object> deactivateUser(@PathVariable Long id) {
        Optional<User> optionalUser  = userRepository.findById(id);

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
