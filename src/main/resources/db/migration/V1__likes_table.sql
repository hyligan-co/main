CREATE TABLE likes
(
    like_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_id   INT NOT NULL,
    post_id   INT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (post_id) REFERENCES posts (post_id)
);