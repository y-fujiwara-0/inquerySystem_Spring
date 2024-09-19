CREATE TABLE IF NOT EXISTS inquerys (
inquery_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '問い合わせID',
mail_Address VARCHAR(50) NOT NULL COMMENT 'メールアドレス',
name VARCHAR(30) NOT NULL COMMENT '名前',
age INT NOT NULL COMMENT '年齢',
address VARCHAR(200) NOT NULL COMMENT '住所',
classification smallint NOT NULL COMMENT '問い合わせ種類',
registration_at datetime DEFAULT NULL COMMENT '問い合わせ日時',
reply_at datetime DEFAULT NULL COMMENT '登録日時',
is_readed VARCHAR(1) NOT NULL DEFAULT '0' COMMENT '返信日時',
content VARCHAR(1000) NOT NULL COMMENT '本文',
created_at datetime NOT NULL COMMENT '作成日時',
updated_at datetime DEFAULT NULL COMMENT '更新日時'
);

CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ユーザーID',
    username VARCHAR(50) NOT NULL COMMENT 'ユーザー名',
    password VARCHAR(500) NOT NULL COMMENT 'パスワード',
    authority VARCHAR(1) NOT NULL COMMENT '権限',
    is_deleted smallint NOT NULL DEFAULT '0' COMMENT '削除フラグ',
    created_at datetime NOT NULL COMMENT '作成日時',
    updated_at datetime NOT NULL COMMENT '更新日時'
);

CREATE TABLE IF NOT EXISTS sample COMMENT 'サンプル'(
    sample_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'サンプルID',
    name VARCHAR(50) NOT NULL COMMENT 'サンプル名',
    created_at datetime NOT NULL COMMENT '作成日時'
);
