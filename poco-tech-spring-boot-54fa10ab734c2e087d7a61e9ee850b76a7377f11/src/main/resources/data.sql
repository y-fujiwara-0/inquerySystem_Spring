insert into inquerys (mailAddress, name, old, address, classification, day, unread, body)
values ('a-suzumura+01@zyyx.jp', 'test', '25', '大阪府大阪市西区江戸堀１−９−１', '1', '2023-05-30', '1','問い合わせシステムテスト用文章です。');

//パスワードは（password1234）
insert into users (username, password, authority) values ('admin', 'e318f654129b82e73909a23d2e2a4cf3b3067b0425ae54e0a5840421643622a74cd8688cdf948056', 'ADMIN');
insert into users (username, password, authority) values ('user', 'password1234', 'ADMIN');