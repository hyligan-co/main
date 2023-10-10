package org.example.frienships;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "friendships")
public class FriendshipsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id")
    private Long friendshipId;

    @Column(name = "user1_id")
    private Long user1Id;

    @Column(name = "user2_id")
    private Long user2Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FriendshipStatus status;

    @Column(name = "timestamp")
    private Date timestamp;

    // Геттери і сеттери
}
