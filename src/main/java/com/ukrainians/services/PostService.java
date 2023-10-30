package com.ukrainians.services;

import com.ukrainians.entity.PostEntity;

import java.util.List;

public interface PostService {
    PostEntity save(PostEntity post);

    List<PostEntity> findAllPostsById(Long id);
}
