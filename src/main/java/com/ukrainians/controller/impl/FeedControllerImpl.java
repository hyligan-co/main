package com.ukrainians.controller.impl;

import com.ukrainians.controller.FeedController;
import com.ukrainians.dto.PostResponse;
import com.ukrainians.services.PostService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class FeedControllerImpl implements FeedController {
    private final PostService postService;

    public FeedControllerImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public @ResponseBody List<PostResponse> getFeeds(Long id) {
        List<PostResponse> postResponses = new ArrayList<>(new ArrayList<>(postService.findAllPostsById(id))
                .stream()
                .map(post -> new PostResponse(post.getId(),
                        post.getUser().getId(),
                        post.getContent(),
                        post.getCreatedAt()))
                .toList());
        postResponses.sort(Comparator.comparing(PostResponse::getTimestamp));
        return postResponses;
    }
}
