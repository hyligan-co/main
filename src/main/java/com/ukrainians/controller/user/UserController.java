package com.ukrainians.controller.user;

import com.ukrainians.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {
    @GetMapping("/{id}")//сторінка юзера
    User getUser(@PathVariable Long id);

    @PostMapping("/create")//створити юзера
    User createUser(@RequestBody User user);

    @PostMapping("/{id}/update")//оновити юзера
    ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User updatedUser);

    @DeleteMapping("/{id}/delete")//деактивувати юзера
    public ResponseEntity<Object> deactivateUser(@PathVariable Long id);
}
