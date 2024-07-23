-- 사용된 제약조건 확인하는 명령어
select * from user_constraints;

create table emp03 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4));

insert into emp03 values(7499, 'ALLEN', 'SALESMAN', 30); -- 정상실행
insert into emp03 values(7499, 'JONES', 'MANAGER', 20); -- 에러 / primary key : not null && unique => unique 조건 미충족
insert into emp03 values(NULL, 'JONES', 'MANAGER', 20); -- 에러 / primary key : not null && unique => not null 조건 미충족

-- 제약조건 정식형식으로 테이블 생성
-- 정식형식으로 작성 시, 제약조건 이름만 보고도 해당 제약조건이 적용되는 위치를 알 수 있고 제약조건을 핸들링하기 쉬워짐
create table dept01 ( deptno number(2) constraint dept01_deptno_pk primary key, dname varchar2(15), loc varchar2(15));

insert into dept01 values(50, 'RESEARCH', '뉴욕'); -- 정상실행
insert into dept01 (deptno, dname, loc) values (60, 'RESEARCH', '뉴욕'); -- 정상실행
insert into dept01 (deptno, dname, loc) values (50, 'TEACHER', '서울'); -- 에러 / primary key : not null && unique => unique 조건 미충족

-- 복합키로 기본키 지정
create table dept02 (deptno number(2), dname varchar2(15), loc varchar2(15), constraint dept02_dno_dnam_pk primary key(deptno, dname));

insert into dept02 values (15, '영업', '서울'); -- 정상실행
insert into dept02 values (15, '개발', '서울'); -- 정상실행
insert into dept02 values (15, '개발', '인천'); -- 에러 / deptno+dname된 데이터를 갖고 primary key 제약조건 검사 => unique 조건 미충족

-- 제약조건 CHECK
create table emp05 (empno number(4) primary key, ename varchar2(10) not null, gender varchar2(1) check (gender in('M','F')));
rollback; -- insert 이후 commit을 하지 않더라도 DDL 작성 시 처리되는 오토커밋에 의해 이전 작업까지 모두 처리된다. 

-- 제약조건 기술 순서는 상관 없다. 단, default 조건인 경우만 맨 처음에 기술해야 한다.
insert into emp05 values (7566, 'JONES', 'M'); -- 정상실행
insert into emp05 values (7577, 'LEMON', 'F'); -- 정상실행
insert into emp05 values (7588, 'TOMS', 'A'); -- 에러. check 제약조건 미충족 -> check = 'M' or 'F'만 가능
insert into emp05 values (7599, 'LEMON', 'f'); -- 에러. check 제약조건 미충족 -> check = 'M' or 'F'만 가능 ==> 값은 대소문자 구별함


create table emp07 (empno number(4) primary key, ename varchar2(10) not null, gender varchar2(1) check (gender in('M','F')), sal number(7,2) check(sal >= 1000 and sal <= 10000));

insert into emp07 values(1234, 'TOMS', 'M', 1500); -- 정상실행
insert into emp07 values (1234, 'TOMS', 'M', 15000); -- 에러. check 제약조건 미충족 -> 1000 <= sal <= 10000의 범위

drop table dept01;

-- dept 테이블을 복사해서 dept01 테이블 생성
create table dept01 as select * from dept;

-- FOREIGN KEY
create table emp06 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4) references dept01(deptno)); -- 에러. 부모 테이블의 기본키만 가져올 수 있음
-- 식별관계 시, deptno number(4) primary key, constraint emp05_deptno_fk forign key(deptno) references dept01(deptno);
alter table dept01 modify(deptno number(2) primary key); -- dept01 테이블을 수정합니다. (deptno 컬럼을 primary key(기본키)로
--create table emp06 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4) references dept01(deptno)); -- 정상실행

insert into emp06 values (7566, 'JONES', 'MANAGER', 50); -- 에러. dept01 테이블에 deptno 컬럼 내에 50 데이터 존재 X
insert into emp06 values (7566, 'JONES', 'MANAGER', null); -- 정상실행. foreign key = null 허용
insert into emp06 values (7588, 'JERRY', 'CEO', 90); -- 에러. dept01 테이블에 deptno 컬럼 내에 90 데이터 존재 X
insert into emp06 values (7588, 'JERRY', 'CEO', 10); -- 정상실행
insert into emp06 values (7599, 'JERRY', 'CEO', 10); -- 정상실행

create table emp08 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4), dnm varchar2(15), constraint emp08_deptno_fk foreign key(deptno, dnm) references dept02(deptno, dname));
-- dept02 테이블의 primary key는 deptno와 dname 모두임 ==> 부모의 기본키가 복합인 경우, 자식에서도 foreign key가 복합이여야 한다.

drop table dept01; -- 에러. 참조키가 있음
drop table emp06; -- 정상실행
drop table dept01; -- 정상실행 -> 부모/자식 관계일 경우, 자식 테이블부터 삭제 시 삭제 가능

drop table dept02 cascade constraints; -- 정상실행 -> 부모/자식 관계일 때, 부모 테이블을 먼저 삭제하는 방법. 부모/자식 상관관계 종료의 명령어
drop table emp07;

-- DEFAULT
create table dept01(deptno number(2) primary key, dname varchar2(20) not null, loc varchar2(50) default '서울');

insert into dept01 values (10, '인사', null); -- null -> 서울 대체 X
insert into dept01 (deptno, dname) values (20, '인사'); -- default : null값 조차도 들어가지 않아야 한다.

-- 제약조건
create table dept02 (deptno number(2));

alter table dept02 add constraint dept02_deptno_pk primary key(deptno);
alter table dept02 modify (deptno constraint dept02_dno_pk primary key); -- 에러. 'can have only one primary key' -> 이미 존재함
alter table dept02 add (dname varchar2(50));
--alter table dept02 add constraint dept02_deptno_nn not null(dname); -- 에러.
alter table dept02 add (dname varchar2(50) not null); -- 정상실행
alter table dept02 drop (dname);
alter table dept02 add dname varchar2(50) constraint dept02_deptno_nn not null; -- 정상실행. not null 제약 조건에 이름을 부여하는 방법
alter table dept02 modify (dname constraint dept02_dname_nn not null); -- 정상실행. not null 제약 조건에서 modify 사용하는 방법
alter table dept02 drop constraint dept02_deptno_nn;
alter table dept02 drop column dname;

-- 명명규칙
create table "Dept03" ("DeptNo" number(3));

insert into dept03 (deptno) values (100); -- 에러. 테이블명이 유효하지 않음 -> 테이블 생성할 때, 큰 따옴표 처리 시 큰 따옴표 작성 필수
insert into "Dept03" (DeptNo) values (100); -- 에러. DeptNo : 유효하지 않은 식별자입니다. => 컬럼 생성할 때, 큰 따옴표 처리 시 큰 따옴표도 작성해줘야함
insert into "Dept03" ("DeptNo") values (100); -- 정상실행

drop table "Dept03";

create table dept01 as select * from dept;
-- scott 계정에서 dept 테이블을 복제해 dept01 테이블 생성
create table dept01 as select * from scott.dept;
-- scott 계정에서 dept 테이블의 구조만 복제해 dept01 테이블 생성
create table dept01 as select * from scott.dept where 1 = 0;


insert into dept01 values (10, 'ACOOUNTING', 'NEW YORK');

savepoint c1;
insert into dept01 values (20, 'RESEARCH', 'DALLAS');

savepoint c2;
insert into dept01 values (30, 'SALES', 'SHICAHO');

savepoint c3;
insert into dept01 values (40, 'OPERATIONS', 'BOSTON');

rollback to c3; -- c3이라는 이름을 가진 savepoint로 롤백함 -> c3 이후 내용만 되돌리기
rollback to c3;
commit;

select * from dept01;

insert into dept01 values (40, 'OPERATIONS', 'BOSTON');
commit; 

rollback to c1; -- 에러. savepoint도 commit 시 확정처리 됨

-- 서브쿼리
-- 사원 이름이 'JONES'인 사원의 부서명 출력
select dname from dept where deptno = (select deptno from emp where ename = 'JONES');

-- 'SMITH'와 같은 부서에서 근무하는 사원의 정보를 출력
select * from emp where deptno = (select deptno from emp where ename = 'SMITH') and ename != 'SMITH';

-- OPERATIONS 부서에서 근무하는 사원의 사번, 이름, 직책, 부서번호 출력
select empno, ename, job, deptno from emp  where deptno = (select deptno from dept where dname = 'OPERATIONS'); -- emp 테이블 내 부서번호 40이 없어서 컬럼만 나옴

-- BLAKE가 담당하는 후임직원의 사번, 이름, 직책, 부서번호 출력
select empno, ename, job, deptno from emp where mgr = (select empno from emp where ename = 'BLAKE');

-- CHICAGO 지역에서 근무하는 사원의 사번, 이름, 부서번호 출력
select empno, ename, deptno from emp where deptno = (select deptno from dept where loc = 'CHICAGO');

-- 'ALLEN'과 동일한 년도에 입사한 사원의 사번, 이름, 입사일자 출력
select empno, ename, hiredate from emp where substr(hiredate, 1, 2) = (select substr(hiredate,1,2) from emp where ename = 'ALLEN') and ename != 'ALLEN';
select empno, ename, hiredate from emp where to_char(hiredate, 'YYYY') = (select to_char(hiredate, 'YYYY') from emp where ename = 'ALLEN') and ename != 'ALLEN';

-- WARD보다 더 많은 연봉을 받는 사원의 사번, 이름, 연봉 출력
select empno, ename, sal from emp where sal > (select sal from emp where ename = 'WARD');
-- 서브쿼리 : 
--select sal from emp where ename = 'WARD';

-- 'RESEARCH' 부서가 아닌 다른 부서에서 근무하는 사원의 사번, 이름, 부서번호 출력
select empno, ename, deptno from emp where deptno != (select deptno from dept where dname = 'RESEARCH');
select empno, ename, deptno from emp where not deptno = (select deptno from dept where dname = 'RESEARCH');
select empno, ename, deptno from emp where not deptno <> (select deptno from dept where dname = 'RESEARCH'); -- <>도 아니다를 의미
-- 서브쿼리 : 
--select deptno from dept where dname = 'RESEARCH';