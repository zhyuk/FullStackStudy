-- 테이블의 구조를 확인하는 명령어
DESC EMP;

commit; -- 데이터를 확정처리해 DB에 데이터를 삽입한다. (미입력 시 임시저장 중)
rollback; -- 전체 되돌리기

select * from dept01; -- dept01 테이블 열기
select * from emp01; -- emp01 테이블 열기

create table DEPT01(deptno number(2,0), dname varchar2(14), loc varchar2(13)); -- number(총 자리수, 소수점 자리수)
insert into dept01 (deptno, dname, loc) values (10, 'ACCOUNTING', 'NEW YORK'); -- dept01테이블의 모든 컬럼에 데이터 삽입 (정식형식)
insert into dept01 (deptno, dname) values (10, 'ACCOUNTING'); -- dept01 테이블의 deptno, dname 컬럼에만 데이터 삽입
insert into dept01 values(20, 'RESEARCH', 'DALLAS'); -- detp01 테이블의 모든 컬럼에 데이터 삽입 (단축형식)

insert into dept01 (deptno, dname) values (30, 'SALES');
insert into dept01 values (40, 'OPERATIONS', null);
insert into dept01 (deptno, loc) values (50, 'CHICAGO');

-- UPDATE
update dept01 set deptno = 90, dname = 'TEST' where deptno = 10 and loc is null; -- loc의 값이 null인 : loc is null

-- emp 테이블의 구조와 데이터를 복사해 emp01 테이블 생성
create table emp01 as select * from emp;

-- emp01 테이블에서 모든 사원의 부서번호를 30번으로 수정
update emp01 set deptno = 30;
-- emp01 테이블에서 모든 사원의 급여를 10% 인상
update emp01 set sal = sal + sal * 0.1;
update emp01 set sal = sal * 1.1;
-- emp01 테이블에서 입사일을 오늘로 수정
update emp01 set hiredate = sysdate;

-- emp01 테이블에서 부서번호가 10번인 사원의 부서번호를 30번으로 수정
update emp01 set deptno = 30 where deptno = 10; 
-- emp01 테이블에서 급여가 3000 이상인 사원만 급여를 10% 인상
update emp01 set sal = sal * 1.1 where sal >= 3000;
-- emp01 테이블에서 1982년에 입사한 사원의 입사일을 오늘로 수정

-- 작은 따옴표와 년도 YYYY로 작성하는 것 주의.
update emp01 set hiredate = sysdate where hiredate between '1982/01/01' and '1982/12/31';
update emp01 set hiredate = sysdate where substr(hiredate, 1, 2) = '82';

-- emp01 테이블에서 JAMES의 부서번호를 20, 직책을 MANAGER로 변경
update emp01 set deptno = 20, job = 'MANAGER' where ename = 'JAMES';
-- emp01 테이블에서 82년에 입사한 사원의 입사일을 1991년 5월 6일 17시 56분으로 변경
update emp01 set hiredate = to_date('1991/05/06 05:56:04', 'YYYY/MM/DD HH12:MI:SS') where hiredate between '1982/01/01' and '1982/12/31';
update emp01 set hiredate = to_date('1991/05/06 17:56:04', 'YYYY/MM/DD HH24:MI:SS') where substr(hiredate, 1, 2) = 80;

-- DELETE
-- emp01 테이블 삭제
delete from emp01;
-- emp01 테이블에서 부서번호가 30인 정보 삭제
delete from emp01 where deptno = 30;
-- emp01 테이블에서 입사일이 1985년 01월 01일 이상인 정보 삭제
delete from emp01 where hiredate >= '1985/01/01';

insert into dept01 values (11, '경리부', '서울');
insert into dept01 values (12, '인사부', '인천');
insert into dept01 values (13, '영업부', '용인');
insert into dept01 values (14, '전산부', '수원');
insert into dept01 values (15, '생산관리부', '안산'); -- VARCHAR2(14BYTE) 이므로 5글자는 불가함.
insert into emp01 (deptno, ename, empno, job, sal, comm, hiredate) values (40, '홍길동', 9999, 'MANAGER', 800, 100, '2022-07-01');
insert into emp01 (deptno, ename, empno, job, sal, comm, hiredate) values (40, '고길동', 1111, 'CEO', 5000, 2500, '1980-01-01');
insert into emp01 (deptno, ename, empno, job) values (30, '강영희', 5555, 'WORKER');

-- emp01 테이블의 데이터 수정하기
-- deptno가 10인 데이터의 deptno의 값을 11로 수정하기
update emp01 set deptno = 11 where deptno = 10;
-- deptno가 20인 데이터의 deptno의 값을 12로 수정하기
update emp01 set deptno = 12 where deptno = 20;
-- deptno가 30인 데이터의 deptno의 값을 13로 수정하기
update emp01 set deptno = 13 where deptno = 30;
-- deptno가 40인 데이터의 deptno의 값을 14로 수정하기
update emp01 set deptno = 14 where deptno = 40;

-- 직책이 CLERK인 사원의 직책을 점원으로 수정
update emp01 set job = '점원' where job = 'CLERK';
-- 직책이 SALESMAN인 사원의 직책을 영업사원으로 수정
update emp01 set job = '영업직' where job = 'SALESMAN'; -- VARCHAR2 (9 BYTE)라 4글자 불가
-- 직책이 MANAGER인 사원의 직책을 관리자으로 수정
update emp01 set job = '관리자' where job = 'MANAGER';
-- 직책이 ANALYST인 사원의 직책을 분석가으로 수정
update emp01 set job = '분석가' where job = 'ANALYST';
-- 직책이 PRESIDENT인 사원의 직책을 회장으로 수정
update emp01 set job = '회장' where job = 'PRESIDENT';
-- 직책이 CEO인 사원의 직책을 전무으로 수정
update emp01 set job = '전무' where job = 'CEO';
-- 직책이 WORKER인 사원의 직책을 생산자으로 수정
update emp01 set job = '생산자' where job = 'WORKER';


create table employ (empid number(4,0), name varchar2(10), job varchar2(10), deptid number(3,0), salary number(4,0), bonus number(3,0), mgrid number(4,0), hiredate date);
select * from employ;
drop table employ purge;

--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (6200, '김철수', '이사', 200, 5000, '', '', '1997/12/17');
--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (6311, '전우치', '부장', 100, 3500, '', 6200, '1998/12/17');
--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (7489, '송아지', '세일즈', 400, 1850, 200, 6321, '1999/02/27');
--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (7522, '오라클', '세일즈', 400, 1850, 300, 6321, '1998/02/28');

drop table emp01 purge; -- purge : 임시 저장소도 모두 제거.
drop table dept01 purge;


-- 사원번호, 사원명, 급여 3개의 칼럼으로 구성된 EMP01 테이블 생성
create table emp01(empno number(4), ename varchar2(10char), sal number(7,2));

-- dept 테이블과 동일한 구조의 테이블을 dept01로 생성
create table dept01(deptno number(2), dname varchar2(14), loc varchar2(13));
select * from dept01;
desc dept01; -- dept01 테이블의 구조 확인하는 명령어

-- 테이블의 구조 변경 :  컬럼 추가
-- emp01 테이블에 문자 타입(20)의 직급(job)칼럼 추가
alter table emp01 add (job varchar2(20));
-- dept01 테이블에 설립일자 컬럼(credate)을 날짜형으로 추가
alter table dept01 add (credate date);

-- 테이블의 구조 변경 :  컬럼 수정
alter table emp01 modify (job varchar2(30));

drop table emp01 purge;

-- emp 테이블을 복사해서 emp01 테이블 생성
create table emp01 as select * from emp; 

-- job 컬럼에 데이터가 있더라도 정상적으로 크기는 늘릴 수 있다.
alter table emp01 modify (job varchar2(30));
alter table emp01 modify (job varchar2(10));
alter table emp01 modify (job varchar2(7)); -- 9 BYTE의 크기를 가진 데이터도 있기 때문에 변경 불가

-- emp01 테이블에 deptno 컬럼의 크기를 정수 4자리로 변경
alter table emp01 modify (deptno number(4)); -- 정상실행
alter table emp01 modify (deptno number(2)); -- 에러. // 숫자 자료형은 한 번 크기를 변경하면 그 크기보다 작게 줄일 수 없다.

alter table emp01 modify (comm varchar2(10)); -- 에러. // comm 컬럼에 데이터가 존재하기 때문에 자료형을 변경할 수 없다.

-- 데이터 변경
update emp01 set comm = '';
commit;

alter table emp01 modify (comm varchar2(10)); -- 정상실행

-- dept01 테이블의 지역명(loc) 칼럼의 크기를 20으로 변경
alter table dept01 modify (loc varchar2(20));

-- 테이블의 구조 변경 :  컬럼 이름 변경
alter table emp01 rename column comm to bonus;
alter table emp01 rename column sal to salary;

-- 테이블의 구조 변경 :  컬럼 삭제
alter table emp01 drop column job; -- 하나의 컬럼만을 삭제하는 형식
alter table emp01 drop (job); -- 한 개 이상의 컬럼을 삭제하는 형식
alter table emp01 drop (mgr, salary);

-- dept01 테이블의 credate 컬럼 삭제
alter table dept01 drop (credate);

create table emp02 as select * from emp  where deptno = 30;
--emp 테이블에서 empno, ename, deptno 컬럼을 조회하여 emp03 테이블 생성
create table emp03 as select empno, ename, deptno from emp;

-- emp 테이블에서 empno, ename, deptno 컬럼 조회하여 emp04 테이블을 만드는데 컬럼명이 사번, 이름, 부서번호로 나오도록 생성
create table emp04 as select empno 사번, ename 이름, deptno 부서번호 from emp;

-- emp 테이블에서 구조만 복사해오는 방법  : where절에 무조건 false를 반환하는 조건을 걸어준다.
create table emp05 as select * from emp where 1 = 0;

-- emp04 테이블의 테이블명을 emp07로 변경
rename emp04 to emp07;
--alter emp04 rename to emp07;

drop table emp02; -- 실무에서 잘못 삭제했을 경우, 휴지통에서 복구할 수 있도록 purge 명령어는 사용하지 않는 것이 좋다.
drop table emp03;
drop table emp05;
drop table emp07;

delete from emp01;
rollback;

-- 테이블의 모든 ROW 제거
truncate table emp01;

drop table emp01;
drop table dept01;

-- 데이터 무결성
create table emp01 (empno number(4), ename varchar2(10), job varchar2(9), deptno number(4));
select * from emp01;

insert into emp01 values(null, '', 'SALESMAN', 30);
insert into emp01 values(null, 'TOM', 'SALESMAN', 30);

-- 제약 조건 : not null
create table emp02 (empno number(4) not null, ename varchar2(10) not null, job varchar2(9), deptno number(4)); -- empno, ename 컬럼은 null 불가능

insert into emp02 values(null, null, 'SALESMAN', 10); -- 에러/ "test 계정 내 emp02라는 테이블 내 empno 컬럼에 null을 넣을 수 없음." empno 컬럼에 값 넣어도 ename 컬럼 오류
insert into emp02 values(1401, 'TOM', 'SALESMAN', 10); -- 정상실행

-- 제약 조건 : unique
create table emp03 (empid varchar2(20) unique not null, empno number(4) unique, ename varchar2(10) not null, job varchar2(9), deptno number(4));

insert into emp03 values('emp03', 7499, 'ALLEN', 'SALESMAN', 30); -- 정상실행
insert into emp03 values('emp02', 7499, 'JONES', 'MANAGER', 20); -- 에러/ ALLEN 컬럼과 동일한 사번 -> unique 제약 조건 미충족
insert into emp03 values('emp05', null, 'JONES', 'SALESMAN', 10); -- 정상실행

-- 제약 조건 : primary key
create table emp04 (empid varchar2(20) primary key, empno number(4) unique, ename varchar2(10) not null, job varchar2(9), deptno number(4));

insert into emp04 values('emp03', 7499, 'ALLEN', 'SALESMAN', 30); -- 정상실행
insert into emp04 values('emp03', 7777, 'JONES', 'MANAGER', 20); -- 에러/ emp03 중복 -> primary key 제약 조건 미충족
insert into emp04 values('emp05', null, 'JONES', 'SALESMAN', 10); -- 정상실행