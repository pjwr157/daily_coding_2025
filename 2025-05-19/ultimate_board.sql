DROP DATABASE IF EXISTS my_cat;
CREATE DATABASE my_cat DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE my_cat;

CREATE TABLE members (
  id VARCHAR(100) PRIMARY KEY,
  -- VARCHAR(100): 최대 100자까지 저장 가능한 문자열 데이터 타입 
  -- PRIMARY KEY: 이 컬럼은 기본 키로 사용됨. 즉, 고유값이어야 하고 중복 불가, NULL 불가
  pw VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  join_date DATETIME DEFAULT NOW()
  -- DATETIME:		 MySQL의 내장 데이터 타입. 날짜와 시간(예: 2025-05-12 17:30:00)을 함께 저장
  -- DEFAULT NOW():	 값을 입력하지 않으면 자동으로 지금 시각을 기본값으로 넣음
		  -- NOW():  MySQL의 내장 함수로, 현재 날짜와 시간을 반환
);

CREATE TABLE board (
  num INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  content TEXT NOT NULL,
-- TEXT: MySQL의 내장 데이터 타입. 긴 글(최대 약 6만 자)을 저장
  id VARCHAR(100) NOT NULL,
  reg_date DATETIME DEFAULT NOW(),
  hit INT DEFAULT 0,
  FOREIGN KEY (id) REFERENCES members(id)
    ON DELETE CASCADE
	-- FOREIGN KEY: 		   외래 키라고 불리며, 다른 테이블과 연결하는 역할
    -- (id): 				   현재 테이블에 있는 id 컬럼이 외래 키라는 뜻
    -- REFERENCES members(id): members라는 테이블의 id와 연결된다
    -- ON DELETE CASCADE: 	   members 테이블에서 어떤 id가 삭제되면, 이 테이블에서도 관련된 데이터도 자동으로 삭제됨
);

CREATE TABLE comment_board (
  comment_id INT AUTO_INCREMENT PRIMARY KEY,
  board_num INT NOT NULL,
  writer_id VARCHAR(100) NOT NULL,
  content TEXT NOT NULL,
  reg_date DATETIME DEFAULT NOW(),
  FOREIGN KEY (board_num) REFERENCES board(num)
    ON DELETE CASCADE,
    -- board_num → 현재 테이블의 외래 키
    -- board(num) → board 테이블의 num 열과 연결
    -- ON DELETE CASCADE → board 테이블에서 어떤 게시글이 삭제되면, 이 테이블에서도 연결된 정보가 삭제됨
    
  FOREIGN KEY (writer_id) REFERENCES members(id)
    ON DELETE CASCADE
);

INSERT INTO members (id, pw, name) VALUES ('testuser', '1234', '테스트 사용자');

INSERT INTO board (title, content, id) VALUES ('환영합니다!', '첫 글입니다.', 'testuser');

-- ※※※※※[ DaoDto 게시판 ]※※※※※

SHOW DATABASES;
select database(); #현재 내가 무슨 디비를 쓰고 있는지 확인하기
show tables;
drop table cat_board;

create table cat_board(
	num int primary key auto_increment, 
    title char(255),
    content text,
    id char(30)
);

drop table cat_board;

CREATE TABLE PS_BOARD_FREE (
		B_NO INT PRIMARY KEY AUTO_INCREMENT, 			#글번호
		B_TITLE CHAR(100) NOT NULL DEFAULT "",			#글제목
	    B_ID CHAR(50) NOT NULL,							#작성자ID
		B_DATETIME DATETIME NOT NULL DEFAULT now(),		#작성시간
	    B_HIT INT NOT NULL DEFAULT 0,					#조회수    
	    B_TEXT TEXT	NOT NULL,							#글내용, 댓글내용
	    B_REPLY_COUNT INT NOT NULL DEFAULT 0,			#댓글수
	    B_REPLY_ORI INT	NOT NULL DEFAULT -1				#댓글의 원글 번호
	);
    

drop table member;
create table member(
	id char(20),
    pw char(20)
);
desc member;
select * from member;
insert into member values('tester','abcd');

insert into ps_board_free (b_title,b_id,b_text) values ('야옹','cat','aaa');
select * from PS_BOARD_FREE;