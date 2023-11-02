package com.ukrainians.controller;

import com.ukrainians.dto.PostResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/feed")
public interface FeedController {
    @GetMapping
    List<PostResponse> getFeeds(@AuthenticationPrincipal(expression = "id") Long id);
}
