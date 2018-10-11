# 数据库 db_course
CREATE TABLE pe_user_course (
  user_id INT UNSIGNED NOT NULL COMMENT '用户ID',
  course_id INT UNSIGNED NOT NULL COMMENT '课程ID',
  PRIMARY KEY (user_id)
);