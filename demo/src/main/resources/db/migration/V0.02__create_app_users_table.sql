--  V0.02__Create_app_users_table.sql
CREATE TABLE app_users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    username   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    user_type  SMALLINT NULL,
    created_by BIGINT NULL,
    created_at datetime NULL,
    updated_by BIGINT NULL,
    updated_at datetime NULL,
    deleted_by BIGINT NULL,
    deleted_at datetime NULL,
    CONSTRAINT pk_app_users PRIMARY KEY (id)
);

ALTER TABLE app_users
    ADD CONSTRAINT uc_app_users_email UNIQUE (email);

ALTER TABLE app_users
    ADD CONSTRAINT uc_app_users_username UNIQUE (username);