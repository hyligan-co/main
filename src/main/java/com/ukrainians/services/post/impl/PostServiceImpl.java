package com.ukrainians.services.post.impl;

import com.ukrainians.entity.Post;
import com.ukrainians.repository.PostRepository;
import com.ukrainians.services.post.PostService;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        post.setCreatedAt(new Timestamp(new Date().getTime()));
        return postRepository.save(post);
    }

}
