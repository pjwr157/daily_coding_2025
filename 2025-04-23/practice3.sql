CREATE DATABASE checklists default CHARACTER SET UTF8MB4;
SHOW DATABASES;
DROP DATABASE checklists;
USE checklists;

drop table meember;
select * from meember;
create table meember(
n int primary key auto_increment,
id char(50) unique not null,
name char(50) not null,
age int not null,
gender char(1) not null,
tel char(20) not null,
hobby char(50) null
);
insert into meember (id,name,age,gender,tel,hobby) values('cat1','고양이',5,'여','010-1234-1234',null);
insert into meember (id,name,age,gender,tel,hobby) values('cat2','개냥이',4,'남','010-1234-1234',null);
insert into meember (id,name,age,gender,tel,hobby) values('cat3','호랑이',9,'남','010-1234-1234',null);