# 数据库 db_course
CREATE TABLE pe_course (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  title VARCHAR(64) NOT NULL COMMENT '主题',
  stars INT UNSIGNED NOT NULL COMMENT '星级',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  PRIMARY KEY (id)
);