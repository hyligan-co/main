CREATE TABLE likes
(
    like_id   serial not null PRIMARY KEY,
    user_id   INT NOT NULL,
    post_id   INT NOT NULL,
    timestamp TIMESTAMP DEFAULT now()
--     FOREIGN KEY (user_id) REFERENCES users (user_id),
--     FOREIGN KEY (post_id) REFERENCES posts (post_id)
);