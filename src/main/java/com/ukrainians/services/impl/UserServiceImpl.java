package com.ukrainians.services.impl;

import com.ukrainians.entity.UserEntity;
import com.ukrainians.exceptions.UsersNotFoundException;
import com.ukrainians.repository.UsersRepository;
import com.ukrainians.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserEntity> findAllById(List<Long> ids) {
        List<UserEntity> userEntities = usersRepository.findAllById(ids);
        if (userEntities.isEmpty()) {
            throw new UsersNotFoundException(String.format("users not found with id %s", ids));
        }
        return userEntities;
    }
}
