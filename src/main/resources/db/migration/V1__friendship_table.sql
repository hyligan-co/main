CREATE TABLE friendships
(
    friendship_id INT AUTO_INCREMENT PRIMARY KEY,
    user1_id      INT NOT NULL,
    user2_id      INT NOT NULL,
    status        ENUM('pending', 'accepted', 'rejected') NOT NULL,
    timestamp     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user1_id) REFERENCES users (user_id),
    FOREIGN KEY (user2_id) REFERENCES users (user_id)
);