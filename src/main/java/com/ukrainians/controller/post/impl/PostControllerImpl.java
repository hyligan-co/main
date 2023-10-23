package com.ukrainians.controller.post.impl;

import com.ukrainians.controller.post.PostController;
import com.ukrainians.entity.ErrorResponse;
import com.ukrainians.entity.PostEntity;
import com.ukrainians.services.post.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class PostControllerImpl implements PostController {
    private final PostService postService;

    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<?> createPost(@Valid PostEntity post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ErrorResponse(
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        PostEntity savedPost = postService.save(post);
        return ResponseEntity.ok(savedPost);
    }
}
