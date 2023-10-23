CREATE TYPE status_friendship AS ENUM ('pending', 'accepted', 'rejected');

CREATE TABLE ukrainians.friendships
(
    friendship_id serial not null PRIMARY KEY,
    user1_id      INT NOT NULL,
    user2_id      INT NOT NULL,
    status        status_friendship NOT NULL,
    timestamp     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--     FOREIGN KEY (user1_id) REFERENCES users (user_id),
--     FOREIGN KEY (user2_id) REFERENCES users (user_id)
);