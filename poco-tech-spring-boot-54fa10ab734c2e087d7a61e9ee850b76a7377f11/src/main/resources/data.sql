insert into inquerys (mailAddress, name, old, address, classification, day, unread, body)
values ('a-suzumura+01@zyyx.jp', 'test', '25', '大阪府大阪市西区江戸堀１−９−１', '1', '2023-05-30', '1','問い合わせシステムテスト用文章です。');
insert into inquerys (mailAddress, name, old, address, classification, day, unread, body)
values ('suzu825193@gmail.com', 'aoi', '24', '愛知県春日井市岩成台１−５−１２', '2', '2022-02-11', '1', '問い合わせシステムテスト文章です。order')


//パスワードは（password1234）
insert into users (username, password, authority) values ('admin', 'password1234', 'ADMIN');
insert into users (username, password, authority) values ('user', 'password1234', 'USER');