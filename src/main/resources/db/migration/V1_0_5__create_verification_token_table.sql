CREATE TABLE ukrainians.verification_token
(
        nick_name VARCHAR(100) PRIMARY KEY,
        token TEXT NOT NULL,
        expiry_date TIMESTAMP,
        FOREIGN KEY (nick_name) REFERENCES user_info (nick_name)
)