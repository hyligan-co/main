package com.ukrainians.frienships;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipsRepository extends JpaRepository<FriendshipsEntity, Long> {
    List<FriendshipsEntity> findAllByRequesterIdOrSupplierIdAndStatus(Long requesterId, Long supplierId, FriendshipStatus status);
}
