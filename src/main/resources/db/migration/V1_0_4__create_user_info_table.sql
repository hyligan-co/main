CREATE TABLE ukrainians.user_info
(
    nick_name VARCHAR(100) PRIMARY KEY,
    email     VARCHAR(100),
    password  VARCHAR(100),
    enabled   BOOLEAN
--     FOREIGN KEY (user_name) REFERENCES "user" (NICK_NAME)
)