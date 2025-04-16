--  V0.01__Create_cities_table.sql
CREATE TABLE city( 
    id BIGINT AUTO_INCREMENT PRIMARY KEY, 
    prefecture_id CHAR (2) NOT NULL, 
    code CHAR (3) NOT NULL, 
    name VARCHAR (10) NOT NULL, 
    name_kana VARCHAR (20) NOT NULL,
    kana_initial VARCHAR (20) NOT NULL
);
