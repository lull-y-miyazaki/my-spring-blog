\c postgres

-- 既に存在していたら削除
DROP ROLE IF EXISTS student;
DROP DATABASE IF EXISTS my_spring_blog;

-- CREATE ROLE student WITH PASSWORD 'himitu' LOGIN;
-- USERだとデフォルトでログイン権限を持つ
CREATE USER student WITH PASSWORD 'himitu';

-- my_spring_blogのDBを作成
CREATE DATABASE my_spring_blog OWNER student ENCODING 'UTF8';