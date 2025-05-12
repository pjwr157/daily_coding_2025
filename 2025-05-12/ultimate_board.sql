DROP DATABASE IF EXISTS my_cat;
CREATE DATABASE my_cat DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE my_cat;

CREATE TABLE members (
  id VARCHAR(100) PRIMARY KEY,
  pw VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  join_date DATETIME DEFAULT NOW()
);

CREATE TABLE board (
  num INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  content TEXT NOT NULL,
  id VARCHAR(100) NOT NULL,
  reg_date DATETIME DEFAULT NOW(),
  hit INT DEFAULT 0,
  FOREIGN KEY (id) REFERENCES members(id)
    ON DELETE CASCADE
);

CREATE TABLE comment_board (
  comment_id INT AUTO_INCREMENT PRIMARY KEY,
  board_num INT NOT NULL,
  writer_id VARCHAR(100) NOT NULL,
  content TEXT NOT NULL,
  reg_date DATETIME DEFAULT NOW(),
  FOREIGN KEY (board_num) REFERENCES board(num)
    ON DELETE CASCADE,
  FOREIGN KEY (writer_id) REFERENCES members(id)
    ON DELETE CASCADE
);

INSERT INTO members (id, pw, name) VALUES ('testuser', '1234', '테스트 사용자');

INSERT INTO board (title, content, id) VALUES ('환영합니다!', '첫 글입니다.', 'testuser');

create table cat_board(
	num int primary key auto_increment, 
    title char(255),
    content text,
    id char(30)
);

drop table cat_board;