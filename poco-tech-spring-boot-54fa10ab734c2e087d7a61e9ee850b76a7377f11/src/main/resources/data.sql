MERGE into inquerys AS target USING VALUES(1)AS source(inquery_id) ON target.inquery_id = source.inquery_id WHEN NOT MATCHED THEN INSERT (inquery_id, mail_address, name, age, address, classification, registration_at, reply_at, is_readed, content, created_at, updated_at)
values (1, 'a-suzumura+01@zyyx.jp', 'test', 25, '大阪府大阪市西区江戸堀１−９−１', 1, '2021-05-30 00:00:00', '2021-05-30 00:00:00', 0,'問い合わせシステムテスト用文章です。', '2024-08-01 00:00:00', '2024-09-12 00:00:00');
MERGE INTO inquerys AS target USING VALUES(2)AS source(inquery_id) ON target.inquery_id = source.inquery_id WHEN NOT MATCHED THEN INSERT (inquery_id, mail_address, name, age, address, classification, registration_at, reply_at, is_readed, content, created_at, updated_at)
values (2, 'suzu825193@gmail.com', 'aoi', 24, '愛知県春日井市岩成台１−５−１２', 2, '2022-02-11 00:00:00', '2022-02-11 00:00:00', 1, '問い合わせシステムテスト文章です。order', '2024-08-01 00:00:00', '2024-09-12 00:00:00');

 MERGE into users AS target USING VALUES(1)AS source(user_id) ON target.user_id = source.user_id WHEN NOT MATCHED THEN INSERT (user_id, username, password, authority, is_deleted, created_at, updated_at)
 values (1, 'admin', '3f4408d1e98cb3777fa65f7feaf5d38c4435d9e935cd62ff972288b1d0e6fe86b5392c50c6a6f799', 1, 0, '2024-08-01 00:00:00', '2024-09-12 00:00:00');
 MERGE into users AS target USING VALUES(2)AS source(user_id) ON target.user_id = source.user_id WHEN NOT MATCHED THEN INSERT(user_id, username, password, authority, is_deleted, created_at, updated_at)
 values (2, 'user', '3f4408d1e98cb3777fa65f7feaf5d38c4435d9e935cd62ff972288b1d0e6fe86b5392c50c6a6f799', 2, 0, '2024-08-01 00:00:00', '2024-09-12 00:00:00');
MERGE into users AS target USING VALUES(3)AS source(user_id) ON target.user_id = source.user_id WHEN NOT MATCHED THEN INSERT(user_id, username, password, authority, is_deleted, created_at, updated_at)
values (3, 'admin1', '3f4408d1e98cb3777fa65f7feaf5d38c4435d9e935cd62ff972288b1d0e6fe86b5392c50c6a6f799', 1, 1, '2024-08-01 00:00:00', '2024-09-12 00:00:00');


-- //パスワードは（password1234）

MERGE INTO sample AS target USING VALUES(1)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (1, 'サンプル1', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(2)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (2, 'サンプル2', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(3)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (3, 'サンプル3', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(4)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (4, 'サンプル4', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(5)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (5, 'サンプル5', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(6)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (6, 'サンプル6', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(7)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (7, 'サンプル7', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(8)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (8, 'サンプル8', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(9)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (9, 'サンプル9', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(10)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (10, 'サンプル10', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(11)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (11, 'サンプル11', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(12)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (12, 'サンプル12', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(13)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (13, 'サンプル13', CURRENT_TIMESTAMP);
MERGE INTO sample AS target USING VALUES(14)AS source(sample_id) ON target.sample_id = source.sample_id WHEN NOT MATCHED THEN INSERT (sample_id, name, created_at)
    values (14, 'サンプル14', CURRENT_TIMESTAMP);
