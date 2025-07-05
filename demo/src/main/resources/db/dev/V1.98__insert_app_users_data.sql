-- V1.98__Insert_app_users_data.sql
-- 管理者ユーザー登録（GENERAL: code = 1）
INSERT INTO app_users (username,
                       email,
                       password,
                       user_type,
                       created_by,
                       created_at)
VALUES ('test_user1',
        'test1@example.com',
        '$2a$10$TgZKACDrkbKXD7LdnGL0MO81Zp/Qye6neOYzqy7/VoxsiXhdi8mNC', -- 「Password」のBCryptハッシュ
        1, -- ADMIN
        1,
        CURRENT_TIMESTAMP);


-- 一般ユーザー登録（GENERAL: code = 2）
INSERT INTO app_users (username,
                       email,
                       password,
                       user_type,
                       created_by,
                       created_at)
VALUES ('test_user2',
        'test2@example.com',
        '$2a$10$TgZKACDrkbKXD7LdnGL0MO81Zp/Qye6neOYzqy7/VoxsiXhdi8mNC', -- 「Password」のBCryptハッシュ
        2, -- GENERAL
        1,
        CURRENT_TIMESTAMP);