package org.example.frienships;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipsRepository extends JpaRepository<FriendshipsEntity, Long> {
}
