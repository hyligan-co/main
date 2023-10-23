package com.ukrainians.repository;

import com.ukrainians.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<UserEntity, Long> {
}
