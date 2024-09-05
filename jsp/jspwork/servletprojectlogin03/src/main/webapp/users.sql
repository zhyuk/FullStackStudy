CREATE TABLE USERS(
ID VARCHAR2(50) PRIMARY KEY,
NAME VARCHAR2(50),
ADDR VARCHAR2(50),
AGE NUMBER,
NATION VARCHAR2(50),
PASSWD VARCHAR2(50),
GENDER VARCHAR2(50),
EMAIL VARCHAR2(50)
);


Insert into USERS (ID,NAME,ADDR,AGE,NATION,PASSWD,GENDER,EMAIL) values ('admin','관리자','서울시',55,'한국','1234','남','admin@hi.com');
Insert into USERS (ID,NAME,ADDR,AGE,NATION,PASSWD,GENDER,EMAIL) values ('hgs','홍길순','안양시',43,'한국','1111','여','hgs@hi.com');
Insert into USERS (ID,NAME,ADDR,AGE,NATION,PASSWD,GENDER,EMAIL) values ('ghd','고희동','수원시',21,'한국','1111','여','ghd@hi.com');
Insert into USERS (ID,NAME,ADDR,AGE,NATION,PASSWD,GENDER,EMAIL) values ('micol','마이콜','안산시',23,'미국','1111','남','mi@hi.com');
Insert into USERS (ID,NAME,ADDR,AGE,NATION,PASSWD,GENDER,EMAIL) values ('dou','도우너','강원도',17,'영국','1111','여','dou@hi.com');