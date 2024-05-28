create table inquerys (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
mailAddress VARCHAR(50) NOT NULl,
name VARCHAR(30) NOT NULl,
old VARCHAR(3) NOT NULL,
address VARCHAR(200) NOT NULL,
classification VARCHAR(100) NOT NULL,
day VARCHAR(50) NOT NULL,
unread VARCHAR(1)NOT NULL,
body VARCHAR(1000) NOT NULL
);

create table users (
username VARCHAR(50) not null,
password VARCHAR(500) not null,
authority enum('ADMIN', 'USER') not null
);