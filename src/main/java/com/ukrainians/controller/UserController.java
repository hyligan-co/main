package com.ukrainians.controller;

import com.ukrainians.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {
    @GetMapping("/{id}")//сторінка юзера
    UserEntity getUser(@PathVariable Long id);

    @PostMapping("/create")//створити юзера
    UserEntity createUser(@RequestBody UserEntity user);

    @PostMapping("/{id}/update")//оновити юзера
    ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserEntity updatedUser);

    @DeleteMapping("/{id}/delete")//деактивувати юзера
    public ResponseEntity<Object> deactivateUser(@PathVariable Long id);
}
