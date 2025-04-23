CREATE DATABASE my_cat default CHARACTER SET UTF8MB4;
SHOW DATABASES; 
use my_cat;
show tables;

create table visit_count(	#테이블 만들기. 칼럼(또는 필드 또는 열이름)은 딸랑 한개.
	count int				#테이블 비슷 마치 클래스
);
use my_cat;
drop table visit_count;
show tables; 

select * from visit_count;
  
insert into visit_count values(0);	#데이터를 한 줄 넣기

update visit_count set count=count+1;

delete from visit_count;

DROP DATABASE my_cat;