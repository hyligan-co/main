package com.ukrainians.repository;

import com.ukrainians.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository <LikeEntity, Long> {
}
