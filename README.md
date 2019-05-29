# cars
test app with timer and multithread

SQL staments to create db

CREATE DATABASE cars CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
use cars;
create table cars (id int auto_increment primary key, producer varchar(50), 
model varchar(25), capacity decimal(6,2));
