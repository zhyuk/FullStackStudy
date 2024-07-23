-- admin 테이블
create table admin (aid varchar2(20) primary key, apwd varchar2(20) not null, anm varchar2(30) not null, arole varchar2(5) check(arole in ('SUPER', 'SUB')), aps varchar2(1) check(aps in ('Y', 'N')));
insert into admin values ('admin', 'admin', '관리자', 'SUPER', 'Y');

-- student 테이블
create table student(sno number(9) primary key, snm varchar2(30) not null, sid varchar2(20) unique, spw varchar2(20), sdate date default '24/03/02', slms varchar2(1) check(slms in('Y', 'N')));
insert into student (sno, snm, slms) values (20241001, '홍길동', 'N');
alter table student modify slms varchar2(1) default 'N';

-- test 테이블
create table test(ty number(4) default '2024', ts number(1) check(ts in (1,2)), tn number(2) not null, tq varchar2(200) not null, ta number(1) not null);
alter table test add(constraint test_pk primary key (ty, ts, tn));

-- answer 테이블
create table answer (sno number(9), ty number(4), ts number(1), tn number(2), ans varchar2(1) check(ans in ('O', 'X')));
alter table answer add(constraint answer_sno_fk foreign key (sno) references student(sno));
alter table answer add(constraint answer_test_fk foreign key (ty,ts,tn) references test(ty, ts, tn));
alter table answer add(constraint answer_pk primary key (sno, ty, ts, tn)); 

commit;