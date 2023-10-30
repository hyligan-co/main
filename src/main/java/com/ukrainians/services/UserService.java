package com.ukrainians.services;

import com.ukrainians.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAllById(List<Long> ids);
}
