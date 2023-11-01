package com.ukrainians.services.impl;

import com.ukrainians.entity.PostEntity;
import com.ukrainians.entity.UserEntity;
import com.ukrainians.repository.PostRepository;
import com.ukrainians.services.FriendService;
import com.ukrainians.services.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final FriendService friendService;


    public PostServiceImpl(PostRepository postRepository, FriendService friendService) {
        this.postRepository = postRepository;
        this.friendService = friendService;
    }

    @Override
    public PostEntity save(PostEntity post) {
        post.setCreatedAt(new Timestamp(new Date().getTime()));
        return postRepository.save(post);
    }

    @Override
    public List<PostEntity> findAllPostsById(Long id) {
        List<PostEntity> posts = new ArrayList<>();
        List<UserEntity> friends = friendService.getFriends(id);
        for (UserEntity friend : friends) {
            List<PostEntity> allByUserId = postRepository.findAllByUserId(friend.getId())
                    .stream()
                    .filter(it -> it.getContent() != null)
                    .toList();
            posts.addAll(allByUserId);
        }
        return posts;
    }


}
