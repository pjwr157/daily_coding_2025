CREATE DATABASE AgeOfDiscovery default CHARACTER SET UTF8MB4;
USE AgeOfDiscovery;
SHOW DATABASES;
DROP DATABASE AgeOfDiscovery;
select * from 보물;
drop table 길드;

-- ========================================================================

-- [0.1.🛠️ CREATE 특훈]

-- Question 1: [항해일지 테이블 생성]
create table 항해일지 (
	일지ID INT PRIMARY KEY, -- 항해일지 고유 번호
	항해사ID INT,				-- 해당 항해사의 ID
    출항일자 DATE,			-- 출항한 날짜
    귀한일자 DATE				-- 귀한한 날짜
);

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

-- Question 5: [선박 업그레이드 테이블 생성]
CREATE TABLE 선박업그레이드 (			
	업그레이드ID INT PRIMARY KEY,			
	선박ID INT,			
	업그레이드명 VARCHAR(50),			
	업그레이드날짜 DATE			
);

-- Question 6: [길드원 테이블 생성]
CREATE TABLE 길드원 (		
	길드원ID INT PRIMARY KEY,		
	길드ID INT,		
	항해사ID INT,		
	가입일자 DATE
);

-- Question 7: [도시 건물 테이블 생성]
CREATE TABLE 도시건물(
	건물ID int primary key,
    도시ID int,
    건물명 varchar(50),
    기능 varchar(100)
);

-- Question 8: [거래 기록 테이블 생성]
CREATE TABLE 거래기록 (		
	거래ID INT PRIMARY KEY,		
	항해사ID INT,		
	교역품ID INT,		
	수량 INT,		
	거래가격 INT,		
	거래일자 DATE		
);		

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
(3, '런던');

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
(5, '최항해사', '선장', 3, 3);

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
(5, '에메랄드호', '카락', 2, 48, 28);

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
(4, '와인', 700);

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
