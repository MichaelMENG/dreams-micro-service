# 数据库 db_user
CREATE TABLE pe_teacher (
  user_id     INT UNSIGNED NOT NULL
  COMMENT '用户ID',
  intro       VARCHAR(64)  NOT NULL
  COMMENT '教师介绍',
  description VARCHAR(512) NOT NULL
  COMMENT '教师描述',
  PRIMARY KEY (user_id)
);
