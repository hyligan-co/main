package com.ukrainians.repository;

import com.ukrainians.entity.FriendRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendRequestEntity, Long> {
    boolean existsBySenderIdAndReceiverId(Long senderId, Long receiverId);
}