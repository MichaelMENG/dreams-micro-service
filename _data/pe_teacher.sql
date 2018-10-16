# 数据库 db_user
CREATE TABLE pe_teacher (
  user_id INT UNSIGNED NOT NULL
  COMMENT '用户ID',
  intro   VARCHAR(64)  NOT NULL
  COMMENT '介绍',
  stars   INT UNSIGNED NOT NULL
  COMMENT '星级',
  PRIMARY KEY (user_id)
);
