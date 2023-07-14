-- 코드 그룹 테이블

CREATE TABLE code_group(
group_code VARCHAR2(3) NOT NULL,
group_name VARCHAR2(30) NOT NULL,
use_yn VARCHAR2(1) DEFAULT 'Y',
reg_date DATE DEFAULT SYSDATE,
upd_date DATE DEFAULT SYSDATE,
PRIMARY KEY (group_code)
);

select * from code_detail;

-- 코드 상세 테이블

CREATE TABLE code_detail (
group_code VARCHAR2(3) NOT NULL,
code_value VARCHAR2(3) NOT NULL,
code_name VARCHAR2(30) NOT NULL,
sort_seq NUMBER NOT NULL,
use_yn VARCHAR2(1) DEFAULT 'Y',
reg_date DATE DEFAULT SYSDATE,
upd_date DATE DEFAULT SYSDATE,
PRIMARY KEY (group_code, code_value)
);



-- 회원 테이블과 회원권한 테이블

CREATE TABLE member(
user_no NUMBER(5) NOT NULL,
user_id VARCHAR2(50) NOT NULL,
user_pw VARCHAR2(100) NOT NULL,
user_name VARCHAR2(100) NOT NULL,
job VARCHAR2(3) DEFAULT '00',
coin NUMBER(10) DEFAULT 0,
reg_date DATE DEFAULT SYSDATE,
upd_date DATE DEFAULT SYSDATE,
enabled VARCHAR2(1) DEFAULT '1',
PRIMARY KEY (user_no)
);

CREATE SEQUENCE member_seq
START WITH 1
INCREMENT BY 1;


CREATE TABLE member_auth (
user_no NUMBER(5) NOT NULL,
auth VARCHAR2(50) NOT NULL
);

ALTER TABLE member_auth ADD CONSTRAINT fk_member_auth_user_no
FOREIGN KEY (user_no) REFERENCES member(user_no);

-- 로그인 상태 유지 테이블
CREATE TABLE persistent_logins (
username VARCHAR2(64) NOT NULL,
series VARCHAR2(64) NOT NULL,
token VARCHAR2(64) NOT NULL,
last_used DATE NOT NULL,
PRIMARY KEY (username)
);

-- 회원 게시판
CREATE TABLE board (
board_no NUMBER NOT NULL,
title VARCHAR2(200) NOT NULL,
content VARCHAR2(3000),
writer VARCHAR2(50) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (board_no)
);

create sequence board_seq
start with 1 
increment by 1;

-- 공지 사항
CREATE TABLE notice (
notice_no NUMBER NOT NULL,
title VARCHAR2(200) NOT NULL,
content VARCHAR2(3000),
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (notice_no)
);

create sequence notice_seq
start with 1 
increment by 1;


-- 상품 테이블
CREATE TABLE item(
item_id NUMBER(10) NOT NULL,
item_name VARCHAR2(30) NOT NULL,
price NUMBER(7) NOT NULL,
description VARCHAR2(500) NOT NULL,
picture_url VARCHAR2(200),
preview_url VARCHAR2(200),
PRIMARY KEY (item_id)
);

create sequence item_seq
start with 1 
increment by 1;


-- 코인 충전 내역 테이블
CREATE TABLE charge_coin_history (
history_no NUMBER NOT NULL,
user_no NUMBER(5) NOT NULL,
amount NUMBER(5) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (history_no)
);

create sequence charge_coin_history_seq
start with 1 
increment by 1;


-- 구매 상품 테이블
CREATE TABLE user_item (
user_item_no NUMBER NOT NULL,
user_no NUMBER(5) NOT NULL,
item_id NUMBER(5) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (user_item_no)
);

create sequence user_item_seq
start with 1 
increment by 1;


-- 지급 내역 테이블
CREATE TABLE pay_coin_history (
history_no NUMBER NOT NULL,
user_no NUMBER(5) NOT NULL,
item_id NUMBER(5) NOT NULL,
amount NUMBER(5) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (history_no)
);

create sequence pay_coin_history_seq
start with 1 
increment by 1;



-- 
CREATE TABLE pds(
item_id NUMBER(5) NOT NULL,
item_name VARCHAR2(20),
view_cnt NUMBER(6) DEFAULT 0,
description VARCHAR2(50),
PRIMARY KEY (item_id)
);

create sequence pds_seq
start with 1 
increment by 1;




--
CREATE TABLE pds_attach (
fullName VARCHAR2(150) NOT NULL,
item_id NUMBER(5) NOT NULL,
down_cnt NUMBER(6) DEFAULT 0,
regdate DATE DEFAULT SYSDATE,
PRIMARY KEY(fullName)
);




--
CREATE TABLE login_log (
log_no NUMBER NOT NULL,
user_no NUMBER(5) NOT NULL,
user_id VARCHAR2(50) NOT NULL,
remote_addr VARCHAR2(50) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (log_no)
);


create sequence login_log_seq
start with 1 
increment by 1;



-- 
CREATE TABLE access_log (
log_no NUMBER NOT NULL,
request_uri VARCHAR2(200) NOT NULL,
class_name VARCHAR2(100) NOT NULL,
class_simple_name VARCHAR2(50) NOT NULL,
method_name VARCHAR2(100) NOT NULL,
remote_addr VARCHAR2(50) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (log_no)
);


create sequence access_log_seq
start with 1 
increment by 1;



-- 
CREATE TABLE performance_log (
log_no NUMBER NOT NULL,
signature_name VARCHAR2(50) NOT NULL,
signature_type_name VARCHAR2(100) NOT NULL,
duration_time NUMBER DEFAULT 0,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (log_no)
);


create sequence performance_log_seq
start with 1 
increment by 1;
