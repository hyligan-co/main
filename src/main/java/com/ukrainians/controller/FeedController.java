package com.ukrainians.controller;

import com.ukrainians.dto.PostResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/feed")
public interface FeedController {
    @GetMapping("/{id}")
    List<PostResponse> getFeeds(@PathVariable Long id);
}
