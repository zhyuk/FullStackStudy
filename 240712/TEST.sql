-- INDEX
select * from customers where cust_id = 4141; -- 0.002s
select * from ct where cust_id = 4141; -- 0.006s

select * from customers where cust_id = 23697; -- 0.002s
select * from ct where cust_id = 23697; -- 0.008s

select * from customers where cust_id = 11252; -- 0.001s
select * from ct where cust_id = 11252; -- 0.003s

-- INDEX 수정
-- : alter index 기존인덱스명 rename to 새로운 인덱스명;
-- 제약조건에 의해 자동으로 생성된 index의 경우, 제약조건명 = 인덱스명이 된다.
alter index customers_cust_id_pk rename to ct_custid_index;

-- INDEX 생성
-- : create index [계정명.]인덱스명 on [계정명.]테이블명(컬럼명);
create index ct_cust_id_idx on ct(cust_id);

-- INDEX 삭제
-- : drop index 인덱스명;
drop index ct_cust_id_idx;

-- 복합 INDEX 생성
-- : create index [계정명.]인덱스명 on [계정명.]테이블명(컬럼1, 컬럼2, ...);
-- 컬럼의 경우, index를 복합으로 걸 때만 여러 컬럼 작성
create index ct_cust_id_name_idx on ct(cust_id, cust_name);

select * from all_indexes; -- 모든 계정의 인덱스 확인하는 명령어
select * from user_indexes; -- 현재 계정의 인덱스 확인하는 명령어

drop index ct_cust_id_name_idx;

-- UNIQUE INDEX 생성
-- : 인덱스를 생성할 컬럼이 중복값을 허용하면 해당 컬럼에는 UNIQUE INDEX를 생성할 수 없다.
create unique index ct_index_nm_mail on ct (cust_email); -- 에러. cust_email 컬럼에는 제약조건 없음 
create unique index ct_index_nm_mail on ct (cust_id); -- 정상실행.

drop index ct_index_nm_mail;

create index ct_index_id on ct(cust_id); -- 테이블 내 - 인덱스- UNIQUENESS가 NONUNIQUE인 경우, 일반 인덱스를 의미.
drop index ct_index_id;

-- INDEX 리빌드
-- alter index 인덱스명 rebuild;
-- 데이터를 출력하는 값이 느려졌을 때 사용하면 된다.
alter index ct_cust_id_idx rebuild;

--select substr(hiredate, 1, 3) ,substr(hiredate, 1, length(hiredate)) from employ;
--select * from employ where to_char(hiredate,'YYYY') >= '2000';

--테이블 : employees e, departments d , countries c , locations l, jobs j, job_history jh// 조인, 서브쿼리 이용
-- 1. 부서가 할되지 않은 사원을 검색 
select * from employees e where not exists(select * from departments d where e.department_id = d.department_id);
-- 2. Roma 지역에 있는 부서들의 부서정보 검색
select * from departments d, locations l where d.location_id = (select l.location_id from locations l where city = 'Roma');
-- 3. Accounting Manager 직책을 가진 사원 검색
select * from employees e where e.job_id = (select  job_id from jobs where job_title = 'Accounting Manager');
-- 4. Payam Kaufling이 받을 수 있는 최소연봉과 최대연봉 검색
select min_salary, max_salary from jobs j where j.job_id = (select job_id from employees where first_name || ' ' || last_name = 'Payam Kaufling');
--select min_salary, max_salary from jobs j where j.job_id = (select job_id from employees where first_name = 'Payam' and last_name = 'Kaufling');

-- 5. Australia 국가에 속해있는 부서의 정보 검색
select * from departments d where location_id in (select location_id from locations l where country_id = (select country_id from countries where country_name = 'Australia'));
-- 1. select country_id from countries where country_name = 'Australia';
-- 2. select location_id from locations where country_id = 'AU';
-- 3. select * from departments where department_id = 2200;
-- 4. select location_id from locations l where country_id = (select country_id from countries where country_name = 'Australia');

select country_id from countries where country_name = 'Canada';
select location_id from locations where country_id = 'CA';
select * from departments where location_id in (1800,1900) ;

-- departments 테이블에서 location_id값이 2500, 2700을 포함하고 있는 나라명 출력
select location_id from departments d where d.location_id in (2500,2700);
select country_id from locations l where location_id in(select location_id from departments d where d.location_id in (2500,2700));
select country_name from countries where country_id in(select country_id from locations l where location_id in(select location_id from departments d where d.location_id in (2500,2700)));

-- 슈도컬럼
-- int자료형 (= number(38)과 동일) : 음수, 0, 양수만 표현 
create table board(no int primary key, subject varchar2(30), content varchar2(50), w_date date);

-- board의 no 컬럼에 사용할 시퀀스 생성
create sequence seq_no nocache; -- 1부터 1씩 증가하는 시퀀스

insert into board values (seq_no.nextval, 'java1', 'java', sysdate);
insert into board values (seq_no.nextval, 'java2', '자바', sysdate);
insert into board values (seq_no.nextval, 'java3', 수업, sysdate); -- 에러. 자료형에 위배되는 수업 문자 입력 시도
insert into board values (seq_no.nextval, 'java3', '수업', sysdate); -- 88번 에러로 인해 nextval이 실행되지 않았음. -> 자료형에 위배되는 조건인 경우의 에러인 경우, 시퀀스 생성하지 않음

-- seq_no 시퀀스의 현재값 출력하는 가상 테이블
select seq_no.currval from dual;
select seq_no.nextval from dual;

insert into board values (seq_no.nextval, 'java2', '영어', sysdate); -- seq_no.nextval = 5 // 93번 줄에서 seq_no.nextval 출력으로 인해 4는 이미 사용됨

select * from all_sequences; -- 모든 시퀀스 출력
select * from user_sequences; -- 현재 계정의 모든 시퀀스 출력

select seq_no.currval from dual; -- nextval은 출력 시 값이 변경되기 때문에 currval 출력 후 출력된 값에 +1을 해준다.
rollback;

insert into board values (seq_no.nextval, 'java2', '영어', sysdate); -- 롤백했으나 시퀀스 값은 롤백되지 않음. 한 번 nextval된 순간 값을 돌릴 수 없음

drop sequence seq_no; -- 시퀀스 명명규칙 seq_컬럼명 / 컬럼명_seq

truncate table board; -- board 테이블 내 모든 데이터 잘라냄. -> 자동 commit됨

create sequence seq_no start with 5 increment by -2 maxvalue 5 nocache;
-- start with 5 부분은 생략 가능, maxvalue 5 부분은 start값이 max보다 크면 안되므로 생략 불가. nocache 부분은 디폴트가 nocache 이므로 생략 가능

insert into board values (seq_no.nextval, 'java1', 'java', sysdate);
insert into board values (seq_no.nextval, 'java2', '자바', sysdate);
insert into board values (seq_no.nextval, 'java3', '수업', sysdate);
insert into board values (seq_no.nextval, 'java2', '영어', sysdate);
insert into board values (seq_no.nextval, 'java2', '국어', sysdate);
insert into board values (seq_no.nextval, 'java2', '고어', sysdate);
insert into board values (seq_no.nextval, 'java2', '수학', sysdate);
insert into board values (seq_no.nextval, 'java2', '한문', sysdate);

drop sequence seq_no;
truncate table board;

create sequence seq_no increment by 2 maxvalue 5 cycle cache 2; -- cycle이 들어가면 반복을 의미, start with이 없기 때문에 minvalue부터 시작

insert into board values (seq_no.nextval, 'java1', 'java', sysdate);
insert into board values (seq_no.nextval, 'java2', '자바', sysdate);
insert into board values (seq_no.nextval, 'java3', '수업', sysdate);
insert into board values (seq_no.nextval, 'java2', '영어', sysdate); -- primary key 제거되기 전엔 중복값을 허용하지 않아 넣을 수 없음. 
insert into board values (seq_no.nextval, 'java2', '국어', sysdate); -- 하지만 위에서 nextval 실행했기 때문에 1이 아닌 3으로 들어감
insert into board values (seq_no.nextval, 'java2', '고어', sysdate);
insert into board values (seq_no.nextval, 'java2', '수학', sysdate);
insert into board values (seq_no.nextval, 'java2', '한문', sysdate);

alter table board drop constraint SYS_C007116;

drop sequence seq_no;
drop table board;

create sequence seq_no nocache; -- start 값 : 1, 1씩 증가할 경우 nocache만 넣어주면 됨.
select * from emp07;

-- test -> 문자열 반환 ==> 입력한 문자열의 크기만큼의 char 자료형으로 자동생성
-- create table emp08 as select 'test' ename, deptno, sal, job from emp;
-- drop table emp08;

-- seq_no.nextval -> 숫자값 반환. ==> 정수값에서 가장 많이 표현할 수 있는 number(38) 자료형으로 자동생성
create table emp07 as select seq_no.nextval empno, ename, deptno, sal, job from emp;

-- empno에 13으로 들어옴. -> 148번 줄의 seq_no.nextval가 1번만 실행되는 것이 아닌 한 행마다 실행된거임 --> emp 테이블의 행수만큼 실행.
insert into emp07 values (seq_no.nextval, 'MARIA', 90, 6000, 'BABO'); 

update emp07 set empno = seq_no.nextval, deptno = seq_no.nextval where empno = 1; 
-- empno = 14로, deptno = 15로가 아니라 seq_no.nextval가 몇 번 적혀있더라도 한 행에는 1번만 증가된다.

insert into emp07 values (seq_no.nextval, 'ROSA', 90, 6000, 'CHUNJAE'); -- seq_no.nextval가 16이 아닌 15로 출력

drop sequence seq_no;
drop table emp07;

create table boa02 (seq number, name varchar2(20) not null);
create sequence bo_se nocache;
drop table boa02;
drop sequence bo_se;

-- dept 테이블의 구조만 복사해서 dept01 테이블을 생성하세요
create table dept01 as select * from dept where 1 = 0;

-- dept01 테이블의 deptno 컬럼의 자료형을 number(4)로 변경
alter table dept01 modify (deptno number(4));

-- dept_seq 이름의 시퀀스 생성 => 옵션 : 시작값 10, 증가값 10, 최대값 30;
-- create sequence 시퀀스명 start with 시작값 increment by 증가값 maxvalue 최대값;
-- cycle : 반복함 cache (크기) : 값을 미리 담아두는 저장소 minvalue : 최소값
create sequence dept_seq start with 10 increment by 10 maxvalue 30; -- 양수값으로 시작되는 시퀀스는 min값 무조건 1임.

insert into dept01 values (dept_seq.nextval, 'ACCOUNTING', 'NEW YORK');
insert into dept01 values (dept_seq.nextval, 'RESEARCH', 'DALLAS');
insert into dept01 values (dept_seq.nextval, 'SALES', 'CHICAGO');
insert into dept01 values (dept_seq.nextval, 'PRODUCT', 'TAIWAN'); -- max 값이 30이고 cycle 기술하지 않았기 때문에 오류.

drop sequence dept_seq ;
truncate table dept01;

create sequence dept_seq start with 10 increment by 10 maxvalue 30 cycle cache 2;

insert into dept01 values (dept_seq.nextval, 'ACCOUNTING', 'NEW YORK');
insert into dept01 values (dept_seq.nextval, 'RESEARCH', 'DALLAS');
insert into dept01 values (dept_seq.nextval, 'SALES', 'CHICAGO');
insert into dept01 values (dept_seq.nextval, 'PRODUCT', 'TAIWAN'); -- start with는 처음 사이클에서만 시작하는 숫자, 한 사이클이 끝나면 min value에서 시작 -> 1

-- sequence 수정 형식: start with을 제외한 모든 것 수정 가능.
alter sequence dept_seq increment by 10 maxvalue 30 cycle cache 2;
alter sequence dept_seq increment by 10 minvalue 1 maxvalue 30 cycle cache 2;

drop table dept01;

-- 시노님
-- 공개동의어 생성 시  시노님명 계정명_테이블명_sn이 권장사항. 다만, 계정명을 숨기고싶을 경우 테이블명_sn으로 명명
create or replace public synonym dept01_sn for dept;

-- 시노님의 경우, 테이블 조회의 형태로 조회가능 --> 공개동의어는 쿼리문이 출력되는 것이 아니라 해당되는 객체를 보여준다.
select * from dept01_sn;

-- scott 계정의 비밀번호 변경. -> 완료 -> 도구 - sql 워크시트 scott 선택 -> scott 워크시트 내 select * from test.dept01_sn;해도 에러 출력됨.
alter user scott identified by 1111;

-- dept01_sn 시노님에 public 권한 부여
grant select on dept01_sn to public;

-- scott 워크시트 내에서 select * from dept01_sn; --> 출력됨.

create or replace synonym dept01_sn for dept; -- 같은 구조로 공개동의어와 비공개동의어 모두 설정한 경우, 외부에서는 공개동의어, 내부에서는 비공개동의어로 작동함 
-- ==> 공개동의어의 기능을 하기때문에 공개동의어로만 생성하는 것이 좋다.
drop synonym dept01_sn;
drop public synonym dept01_sn;

create or replace synonym dept01_sn for dept; -- private 형식의 비공개동의어 생성
grant select on dept01_sn to public -- 명령문으로는 틀린것이 없기때문에 에러 X, 실질적으로 해당 시노님은 공개동의어가 아니기 때문에 public 권한을 부여해도 외부에서 접근할 수 없다.
