CREATE DATABASE AgeOfDiscovery default CHARACTER SET UTF8MB4;
USE AgeOfDiscovery;
SHOW DATABASES;
DROP DATABASE AgeOfDiscovery;
select * from 항해일지;
drop table 항해일지;

-- ========================================================================

-- [0.1.🛠️ CREATE 특훈]
-- [0.2.🛠️ insert 특훈]
-- [0.3.🛠️ delete 특훈] (Study Here & Scroll down for Delete Practice!)

-- Question 1: [항해일지 테이블 생성]
create table 항해일지 (
	일지ID INT PRIMARY KEY, -- 항해일지 고유 번호									-- ※※※⁂⁂⁂ DATE 컬럼 => CURDATE() & DATETIME 컬럼	=> NOW() ⁂⁂⁂※※※
	항해사ID INT,				-- 해당 항해사의 ID	
    출항일자 DATE,			-- 출항한 날짜
    귀한일자 DATE				-- 귀한한 날짜
);

insert into 항해일지 (일지ID,항해사ID,출항일자,귀한일자) values (1,2, '2025-04-20', curdate()); 
insert into 항해일지 (일지ID,항해사ID,출항일자,귀한일자) VALUES (99, 1, '2019-12-30', '2020-01-02');
delete from 항해일지 where 출항일자 < '2020-01-02';								-- 	※※※⁂⁂⁂ "보다 작다" 비교 연산자 (before) ※※※⁂⁂⁂ 

-- Question 2: [항로 테이블 생성 (거리: km)]
create table 항로 (
	항로ID INT PRIMARY KEY, 		-- 항로 고유 번호
	출발도시ID INT,				-- 출발도시
    도착도시ID INT,				-- 도착도시
    거리 INT comment '단위:km'	-- 도시 간 거리
);

-- Question 3: [선원 테이블 생성]
create table 선원 (
	선원ID INT PRIMARY KEY, 		-- 선원 고유 번호
	선원명 varchar(50),			-- 선원 이름
    소속선박ID INT,				-- ㅈㅁㄱㄴㅇ
    직책 varchar(30)				-- 선원의 직책
);

-- Question 4: [무기 테이블 생성]
CREATE TABLE 무기 (		
	무기ID INT PRIMARY KEY,		
	무기명 VARCHAR(50),		
	공격력 INT,		
	가격 INT		
);	

insert into 무기 (무기ID, 무기명, 공격력, 가격) values
(1,'장검',150,3000),
(99, '삭제대상무기', 50, 800);
delete from 무기 where 가격 < 1000;

-- Question 5: [선박 업그레이드 테이블 생성]
CREATE TABLE 선박업그레이드 (			
	업그레이드ID INT PRIMARY KEY,			
	선박ID INT,			
	업그레이드명 VARCHAR(50),			
	업그레이드날짜 DATE			
);

insert into 선박업그레이드 (업그레이드ID, 선박ID, 업그레이드명, 업그레이드날짜) values
(99, 1, '구형강화', '2019-12-01');
delete from 선박업그레이드 where 업그레이드날짜 < '2020-01-01';

-- Question 6: [길드원 테이블 생성]
CREATE TABLE 길드원 (		
	길드원ID INT PRIMARY KEY,		
	길드ID INT,		
	항해사ID INT,		
	가입일자 DATE
);

insert into 길드원 (길드원ID, 길드ID, 항해사ID, 가입일자) values
(1,1,6,curdate()),
(99,1,1,'2019-11-30');
DELETE FROM 길드원 WHERE 가입일자 < '2020-01-01';

-- Question 7: [도시 건물 테이블 생성]
CREATE TABLE 도시건물(
	건물ID int primary key,
    도시ID int,
    건물명 varchar(50),
    기능 varchar(100)
);

INSERT INTO 도시건물 (건물ID, 도시ID, 건물명, 기능) VALUES (1, 1, '조선소', '선박 수리 및 제작');
INSERT INTO 도시건물 (건물ID, 도시ID, 건물명, 기능) VALUES (99, 1, '삭제대상건물', '없음');
delete from 도시건물 where 기능 = '없음';

-- Question 8: [거래 기록 테이블 생성]
CREATE TABLE 거래기록 (		
	거래ID INT PRIMARY KEY,		
	항해사ID INT,		
	교역품ID INT,		
	수량 INT,		
	거래가격 INT,		
	거래일자 DATE		
);		

insert into 거래기록 (거래ID,항해사ID,교역품ID,수량,거래가력,거래일자) values (1,1,1,100,120000, '2025-04-26');

-- Question 9: [모험 테이블 생성]
CREATE TABLE 모험 (		
	모험ID INT PRIMARY KEY,		
	항해사ID INT,		
	모험명 VARCHAR(100),		
	성공여부 BOOLEAN		
);		

-- Question 10: [보물 테이블 생성 (위도, 경도 추가)]
CREATE TABLE 보물 (		
	보물ID INT PRIMARY KEY,		
	보물명 VARCHAR(50),		
	가치 INT,		
	발견도시ID INT,		
	위도 DECIMAL(9,6),		
	경도 DECIMAL(9,6)		
);

INSERT INTO 보물 (보물ID, 보물명, 가치, 발견도시ID, 위도, 경도) values
(1, '황금항아리', 50000, 2, 37.3886, -5.9823);
INSERT INTO 보물 (보물ID, 보물명, 가치, 발견도시ID, 위도, 경도) VALUES
(99, '삭제대상보물', 10000, 1, 0.000000, -5.982300);
DELETE FROM 보물 WHERE 위도 = 0 OR 경도 = 0;

-- ========================================================================

-- 1. 길드 테이블
CREATE TABLE 길드 (
    길드ID INT PRIMARY KEY,
    길드명 VARCHAR(50)
);

INSERT INTO 길드 (길드ID, 길드명) VALUES
(1, '고양이길드'),
(2, '삼성'),
(3, 'LG');

-- 2. 도시 테이블
CREATE TABLE 도시 (
    도시ID INT PRIMARY KEY,
    도시명 VARCHAR(50)
);

INSERT INTO 도시 (도시ID, 도시명) VALUES
(1, '리스본'),
(2, '세비야'),
(3, '런던'),
(4, '암스테르담'),
(99, '삭제대상도시');
delete from 도시 where 도시명 = '삭제대상도시';

-- 3. 항해사 테이블
CREATE TABLE 항해사 (
    항해사ID INT PRIMARY KEY,
    항해사명 VARCHAR(50),
    직급 VARCHAR(20),
    소속길드ID INT,
    도시ID INT
);

INSERT INTO 항해사 (항해사ID, 항해사명, 직급, 소속길드ID, 도시ID) VALUES
(1, '김항해사', '항해사', 1, 1),
(2, '이선장', '선장', 1, 1),
(3, '박항해사', '항해사', 2, 2),
(4, '조항해사', '항해사', 2, 2),
(5, '최항해사', '선장', 3, 3),
(6, '강항행사', '항해사', 1, 2);

Insert into 항해사 (항해사ID, 항해사명, 직급, 소속길드ID, 도시ID) VALUES
(99, '삭제대상항해사', '항해사', 1, 1);
delete from 항해사 where 항해사명 = '삭제대상항해사';

-- 4. 선박 테이블
CREATE TABLE 선박 (
    선박ID INT PRIMARY KEY,
    선박명 VARCHAR(50),
    선박종류 VARCHAR(20),
    도시ID INT,
    현재선원수 INT,
    최소필요선원수 INT
);

INSERT INTO 선박 (선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) VALUES
(1, '블루오션호', '바사', 1, 50, 20),
(2, '레드필드호', '갤리온', 2, 45, 25),
(3, '그린웨이호', '카락', 3, 60, 30),
(4, '썬더호', '갤리온', 1, 55, 22),
(5, '에메랄드호', '카락', 2, 48, 28),
(6, '오션스타호', '플루트', 3, 40, 20);

insert into 선박 (선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) VALUES
(99, '삭제대상호', '갤리온', 1, 30, 15);
delete from 선박 where 선박ID = 99;

-- 5. 교역품 테이블
CREATE TABLE 교역품 (
    교역품ID INT PRIMARY KEY,
    교역품명 VARCHAR(50),
    기준가격 INT
);

INSERT INTO 교역품 (교역품ID, 교역품명, 기준가격) VALUES
(1, '향신료', 1000),
(2, '비단', 1500),
(3, '철광석', 500),
(4, '와인', 700),
(5, '설탕', 800);

INSERT INTO 교역품 (교역품ID, 교역품명, 기준가격) VALUES (99, '삭제대상교역품', 999);				
delete from 교역품 where 교역품명 = '삭제대상교역품';

-- 6. 도시-교역품 테이블
CREATE TABLE 도시교역품 (
    도시ID INT,
    교역품ID INT,
    구입가 INT,
    판매가 INT,
    PRIMARY KEY (도시ID, 교역품ID)
);

INSERT INTO 도시교역품 (도시ID, 교역품ID, 구입가, 판매가) VALUES
(1, 1, 800, 1200), -- 리스본, 향신료
(1, 4, 600, 900),  -- 리스본, 와인
(2, 2, 1300, 1700),-- 세비야, 비단
(2, 4, 650, 950),  -- 세비야, 와인
(3, 3, 450, 600),  -- 런던, 철광석
(3, 2, 1400, 1600);-- 런던, 비단
