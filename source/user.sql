CREATE TABLE pe_user (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(32) NOT NULL COMMENT '用户名',
  password VARCHAR(32) NOT NULL COMMENT '密码',
  real_name VARCHAR(32) COMMENT '真实姓名',
  mobile VARCHAR(32) COMMENT '手机',
  email VARCHAR(32) COMMENT '邮箱',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  PRIMARY KEY (id)
);