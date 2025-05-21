CREATE DATABASE noticeBoardTest default CHARACTER SET UTF8MB4;
USE noticeBoardTest;
SHOW DATABASES;
DROP DATABASE noticeBoardTest;
DROP DATABASE board;
DROP DATABASE tottenham_squad;
DROP DATABASE my_cat;

# !!!100번 연습할 스크립트임 (aka SQL script) (問題30番から) !!!
create table noticeBoard (
	b_no int primary key auto_increment, 	#글번호
	b_title char(100) not null,				#글제목
    b_id char(20) not null,					#작성자id
	b_datetime datetime not null,			#작성시간
    b_hit int default 0 not null,			#조회수    
    b_text text								#글내용
);
desc noticeBoard;
drop table noticeBoard;

insert into noticeBoard (b_title,b_id,b_datetime,b_text) 
values (
'헬로'
,
'cat1'
,
now()
,
'글입니다. 글글.....글....'
);

select * from noticeBoard;

select * from noticeBoard order by b_no desc;