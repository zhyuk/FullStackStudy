create table score(hak varchar2(10), name varchar2(20) not null, kor number(3), eng number(3), mat number(3), constraint pk_score_hak primary key(hak));
select hak, name, kor, eng, mat, (kor+eng+mat) as tot, (kor+eng+mat)/3 as ave from score where upper(name) like upper('searchName%');
select hak, name, kor, eng, mat,(kor+eng+mat) as tot, (kor+eng+mat)/3 as ave from score order by hak;


create table member1 (id varchar2(12), passwd varchar2(12), name varchar2(12), age number(3), addr varchar2(20), email varchar2(20));
insert into member1 values('aaa', 'aaa', '박재영', 32, '서울시', 'a@a.com');
insert into member1 values('bbb', 'bbb', '임정혁', 31, '인천시', 'b@b.com');
insert into member1 values('ccc', 'ccc', '홍길동', 35, '강원도', 'c@c.com');
insert into member1 values('ddd', 'ddd', '마이콜', 33, '제주도', 'd@d.com');
insert into member1 values('eee', 'eee', '고영희', 34, '수원시', 'e@e.com');
commit;

select * from member1 where id = 'aaa' and passwd =' aaa';

--dbc7
create table board(id number primary key, writer varchar2(12) not null, passwd varchar2(12) not null, subject varchar2(50) not null, email varchar2(25));
create sequence board_seq nocache;

insert into board values(board_seq.nextval, '관리자', '1111', '공지합니다', 'admin@a.b');
commit;