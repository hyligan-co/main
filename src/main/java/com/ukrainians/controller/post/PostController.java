package com.ukrainians.controller.post;

import com.ukrainians.entity.Post;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/post")
public interface PostController {
    @PostMapping(value = "/create")
    @ResponseBody
    ResponseEntity<?> createPost(@Valid @RequestBody Post post, BindingResult bindingResult);
}
