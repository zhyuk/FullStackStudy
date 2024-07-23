-- 셀프 조인 : SELF JOIN

-- 사원 이름 및 사원 번호를 해당 관리자 이름 및 관리자 번호와 함께 표시, 열 머리글을 각각 사원이름, 사원번호, 관리자 이름, 관리자 번호으로 표시
select e.ename 사원이름, e.empno 사원번호, d.ename as "관리자 이름", d.deptno as "관리자 번호" from emp e, emp d where e.mgr = d.empno;
select e.ename 사원이름, e.empno 사원번호, d.ename as "관리자 이름", d.deptno as "관리자 번호" from emp e inner join emp d on e.mgr = d.empno;

-- 특정 사원을 담당하는 매니저 사원의 이름을 출력한다. WORK과 MANAGER로 별칭을 부여한다.
select work.ename || '의 매니저는 ' || manager.ename || '입니다.' MANAGER from emp work,emp manager  where work.mgr = manager.empno; -- INHNER JOIN
select work.ename || '의 매니저는 ' || manager.ename || '입니다.' MANAGER from emp work inner join emp manager  on work.mgr = manager.empno; -- ANSI INNER JOIN

create table test1(id number(2) constraint test1_id_pk primary key, name varchar2(10), age number(2));
create table test2(id number(2) constraint test2_id_fk references test1(id), job varchar2(20));

insert into test1 values(1, '장희빈', 10);
insert into test1 values(2, '이효리', 25);
insert into test1 values(3, '이나영', 40);
insert into test1 values(5, '이혜리', 35);
insert into test1 values(6, '주진모', 15);

insert into test2 values(1, '한국사');
insert into test2 values(3, '대중가요');
insert into test2 values(5, '연기');
insert into test2 values(3, '뮤지컬');
insert into test2 values(4, '연구'); -- 에러. test1 id 컬럼에 '4' 존재 X
commit;

-- test1, test2 테이블의 이너조인 결과
select * from test1, test2 where test1.id = test2.id;
select * from test1 inner join test2 on test1.id = test2.id;

create table lno as select loc from dept;
alter table lno add (lnum varchar2(5));

update lno set lnum = '001' where loc = 'NEW YORK';
update lno set lnum = '002' where loc = 'DALLAS';
update lno set lnum = '003' where loc = 'CHICAGO';
update lno set lnum = '004' where loc = 'BOSTON';
commit;

-- 사원번호, 사원이름, 부서번호, 부서명, 위치, 위치번호가 출력이 되도록 처리
select e.empno, e.ename, d.deptno, d.dname, d.loc, l.lnum from emp e, dept d, lno l where e.deptno = d.deptno and d.loc = l.loc;
select e.empno, e.ename, d.deptno, d.dname, d.loc, l.lnum from emp e inner join dept d on e.deptno = d.deptno inner join lno l on d.loc = l.loc; -- ANSI INNER JOIN
-- from Table1 inner join Table2 on 조건1 inner join Table 3 on 조건2

-- using을 이용한 조인 조건 지정. on 대신 사용 가능. 단, 조인 조건에 사용되는 컬럼명이 동일한 경우만 가능.
-- 두 테이블의 컬럼명이 동일한 경우, ANSI INNER JOIN + USING(중복되는 컬럼명)을 이용해 중복되는 컬럼을 하나만, 가장 먼저 출력할 수 있다.
select * from emp inner join dept using(deptno);

insert into emp (empno, ename) values (8000, 'TEST');
commit;

-- 사원번호, 사원명, 부서번호, 부서명 출력하는데 부서가 할당되지 않은 사원 출력을 해주세요.
select empno, ename, d.deptno, dname from emp, dept d where emp.deptno = d.deptno(+); -- LEFT OUTER JOIN
select empno, ename, d.deptno, dname from emp left outer join dept d on emp.deptno = d.deptno; -- ANSI LEFT OUTER JOIN
select empno, ename, d.deptno, dname from dept d, emp where d.deptno(+) = emp.deptno; -- RIGHT OUTER JOIN
select empno, ename, d.deptno, dname from dept d right outer join emp on d.deptno = emp.deptno; -- ANSI RIGHT OUTER JOIN

-- 사원번호, 사원명, 부서번호, 부서명 출력하는데 부서가 할당되지 않은 사원과 사원이 할당되지 않은 부서의 정보 출력을 해주세요.
-- A 테이블에 갖고있는 모든 데이터, B 테이블에 갖고있는 모든 데이터를 출력(= B 테이블의 값이 NULL인 경우도, A 테이블의 값이 NULL인 경우도 출력해주는) : FULL OUTER JOIN
select empno, ename, d.deptno, dname from emp full outer join dept d on emp.deptno = d.deptno; -- ANSI FULL OUTER JOIN

select count(*) from employees;

-- 1. 사원번호 , 사원명 별칭 NAME , 부서번호, 부서명이 출력되도록 처리해주세요.
select e.employee_id, e.first_name || ' ' || e.last_name as name, d.department_id, d.department_name from employees e, departments d where e.department_id = d.department_id; -- INNER JOIN
select e.employee_id, e.first_name || ' ' || e.last_name as name, d.department_id, d.department_name from employees e join departments d on e.department_id = d.department_id; -- ANSI INNER JOIN

-- 2. 사원번호, 부서번호, 부서명, 상위부서명을 출력하는데, 부서를 할당받지 못한 인턴사원까지 출력해주세요.
select e.employee_id, e.first_name || ' ' || e.last_name as name,  d.department_id, d.department_name, d.manager_id from employees e, departments d where e.department_id  = d.department_id(+);

-- 3. 사원번호, 사원명 별칭 NAME, 부서번호, 부서명을 출력하는데, 사원이 할당되지 않은 부서에 대해서도 출력해주세요.
select e.employee_id, d.department_id, d.department_name, d.manager_id from employees e, departments d where e.department_id(+)  = d.department_id;

-- 테이블: EMPLOYEES , JOB_HISTORY , JOBS
-- JOB_HISTORY 테이블의 START_DATE (해당 직책이 시작된 일자), END_DATE(해당 직책이 종료된 일자)
-- JOBS :  JOB_ID : 직책아이디,  JOB_TITLE : 직책명
-- 직책이 변경된 직원의 사원번호, 사원명 별칭 NAME, 부서번호, 부서명, 직책명, 해당 직책이 시작된 일자,  해당 직책이 종료된 일자를 출력해주세요.
select e.employee_id, e.first_name || ' ' || e.last_name as name, j.department_id,js.job_title, j.start_date, j.end_date from employees e inner join job_history j on e.employee_id = j.employee_id join jobs js on j.job_id = js.job_id order by e.employee_id, j.start_date asc;

-- 테이블: EMPLOYEES, JOBS
-- JOBS테이블의 JOB_ID : 직책아이디, JOB_TITLE : 직책명, MIN_SALARY : 최소 연봉, MAX_SALARY: 최대연봉
-- 'Nancy Greenberg'가 받을 수 있는 사원번호, 사원명, 최대연봉과 최소 연봉, 직책아이디, 직책명을 사원번호 오름차순으로 출력하세요.
select e.employee_id, e.first_name || ' ' || e.last_name, j.max_salary, j.min_salary, j.job_id, j.job_title from employees e, jobs j where e.job_id = j.job_id and e.first_name || ' ' || e.last_name = 'Nancy Greenberg' order by e.employee_id;

drop table test1;
drop table test2;

delete from emp where empno = 8000; -- emp 테이블에서 empno가 8000인 행 삭제
commit;

-- VIEW : 단일뷰
create table emp01 as select * from emp;

create view view_emp01 as select empno, ename, sal, deptno from emp01 where deptno = 10;
desc view_emp01; -- view_emp01의 구조 보기
select * from view_emp01;  -- view_emp01을 생성할 때의 조건에 부합하는 원본 데이터만 출력

insert into view_emp01 values(8000, 'ANGEL', 7000, 10); -- 단일뷰는 원본과 명확하게 연결되어 있어 컬럼을 정확하게 찾을 수 있음 -> DML 사용해서 원본 수정 가능
commit;
drop view view_emp01;

select * from dba_constraints; -- 모든 계정에 존재하는 제약조건 확인
select * from user_tables; -- test 계정에 존재하는 모든 테이블 확인
select * from user_views; -- test 계정에 존재하는 모든 view 확인

-- VIEW : 복합뷰
create view view_emp_dept as select ename, dname from emp, dept where emp.deptno = dept.deptno;

delete from view_emp_dept where dname = 'ACCOUNTING'; -- 에러. view가 정확하게 한 테이블에 연결되어있지 않습니다.
insert into view_emp_dept (ename, dname) values ('MICLE', 'ARTIST'); -- 에러. view가 정확하게 한 테이블에 연결되어있지 않습니다.

-- emp 테이블에 WORD의 이름뒤에 D를 더 붙이는 방법
update emp set ename = 'WARDDD' where ename = 'WARD'; -- update 테이블명 set 변경할 컬럼 = 변경할 값 where 조건;
commit;

select * from view_emp_dept; --> 원본 테이블의 데이터를 가상으로 가져와 보여주기 때문에 원본이 수정되면 같이 수정된다.
drop table emp; --> 원본인 emp 테이블이 삭제되어 view도 영향을 받는다.

create table emp as select * from scott.emp;
drop view view_emp_dept; --> = create view view_emp_dept as select ename, dname from emp, dept where emp.deptno = dept.deptno; 쿼리문 삭제

-- VIEW : 인라인뷰
select * from (select 25/5 as result from dual);
-- select 25/5 as result from dual; --> 서브쿼리, 가상테이블도 값을 테이블구조로 반환하기 때문에 from절에 올 수 있다.

select IMSI.*, 'TEST' as TEST from (select ename, dname from emp e, dept d where e.deptno = d.deptno) IMSI;
-- select ename, dname from emp e, dept d where e.deptno = d.deptno; --> inner join을 통해 emp 테이블의 ename 컬럼, dept 테이블의 dname 컬럼의 데이터 반환

-- 세미조인 : 포함하는의 의미
select * from dept d where exists(select * from emp e where e.deptno = d.deptno);
-- exists를 사용한 세미조인인 경우, 서브쿼리여도 메인쿼리와 동시에 조건을 비교해야한다. 

select * from emp e where exists(select * from dept d where d.deptno = e.deptno);
select * from dept d where d.deptno in (select distinct deptno from emp where sal >= 3000);
-- select distinct deptno from emp where sal >= 3000; ==> 10, 20 반환
-- select * from dept d where d.deptno in (10,20); 136번줄과 동일한 의미임.

-- 안티조인 : 포함하지 않는의 의미
select * from dept b where not exists (select * from emp e where e.deptno = b.deptno);
-- dept 테이블의 deptno = 10일때, emp 테이블의 deptno과 동일한 데이터가 없는 dept 테이블의 모든 정보를 가져온다.

select * from dept b where b.deptno not in (select distinct deptno from emp where sal >= 3000);
-- select distinct deptno from emp where sal >= 3000; ==> 10,20 반환
-- select * from dept b where b.deptno not in (10,20); 141번줄과 동일한 의미임. ==> dept 테이블에 deptno 컬럼에 10, 20이 포함되지 않는 모든 정보 출력

create table ct as select * from customers;

-- 제약조건 추가 : alter table 테이블명 add constraint 제약조건명 제약조건유형(컬럼);
alter table customers add constraint customers_cust_id_pk primary key(cust_id);

-- 테스트 준비
create table employ (empid  number(4) constraint employ_id_pk primary key, name  varchar2(10) not null, job  varchar2(10) not null, deptid  number(3), salary  number(4) not null, bonus  number(3), mgrid  number(4), hiredate  date  not null);

insert into employ values (6200,'김철수','이사',200, 5000,null,null,'1997-12-17');
insert into employ values (6311,'전우치','부장',100,3500,null,6200,'1998-12-17');
insert into employ values (7489,'송아지','세일즈',400,1850,200,6321,'1999-02-27');
insert into employ values (7522,'오라클','세일즈',400,1850,300,6321,'1998-02-28');
insert into employ values (6321,'강아지','부장',400,3800,500,6200,'1999-04-20');
insert into employ values (6351,'고구려','부장',300,2850,null,6200,'2000-05-31');
insert into employ values (7910,'이영희','경리',300,1000,null,6351,'2001-05-01');
insert into employ values (6361,'이발소','부장',200,3200,null,6200,'2000-06-09');
insert into employ values (7878,'박수처','연구직',200,3000,null,6361,'2001-06-05');
insert into employ values (7854,'최우수','세일즈',400,1500,0,6321,'2001-09-08');
insert into employ values (7872,'임꺽정','사무직',100,1500,null,6311,'2001-02-12');
insert into employ values (7920,'김말이','사무직',300,1050,null,6351,'2001-03-18');
insert into employ values (7901,'정동진','연구직',null,3000,null,null,'2001-12-03');
insert into employ values (7933,'홍길동','사무직',200,1050,null,6361,'2002-01-02');

--1. 사원의 급여에 12를 곱한 결과만 출력되도록 수식을 적용하고, 수식의 별칭을 "연봉" 으로 표시하시오.
select salary * 1.1 연봉 from employ;
select salary + salary * 0.1 연봉 from employ;
--2. 업무가 '세일즈' 인 사원의 이름, 업무, 부서아이디를 검색하시오.
select name, job, deptid from employ where job = '세일즈';
--3. 입사일이 '2001년 12월 3일' 인 사원을 검색하시오.
select * from employ where hiredate = '2001/12/03';
--4. 부서아이디가 200 인 사원의 이름, 업무, 입사일, 부서아이디를 검색하시오.
select name, job, hiredate, deptid from employ where deptid = 200;
--5. 급여가 3000 이상이고 5000 이하인 사원의 이름, 급여를 검색하시오.
select name, salary from employ where salary between 3000 and 5000;
--6. 관리자아이디가 6311, 6361, 6351 중에서 해당하는 경우의 사원아이디, 관리자아이디, 이름, 부서아이디를 검색하시오.
select empid, mgrid, name, deptid from employ where mgrid in(6311, 6361, 6351);
select empid, mgrid, name, deptid from employ where mgrid = 6311 or mgrid = 6361 or mgrid = 6351;
--7. 업무가 '사무직' 이거나 '경리' 인 사원을 검색하시오.
select * from employ where job = '사무직' or job = '경리';
select * from employ where job in ('사무직','경리');
--8. 급여가 3000 이상이고 업무가 '부장' 인 사원을 검색하시오.
select * from employ where salary >= 3000 and job = '부장';
--9. 업무가 ( '세일즈' 이거나 '사무직' ) 이 아닌 사원을 검색하시오.
select * from employ where job not in ('세일즈', '사무직');
select * from employ where job != ('세일즈') and job != ('사무직');
--10. 급여가 1500 ~ 2500 사이가 아닌 사원을 검색하시오.
select * from employ where salary not between 1500 and 2500;
--11. 업무가 '경리' 이거나 '부장' 이고, 급여가 3000 이 넘는 사원을 검색하시오.
select * from employ where job in ('경리','부장') and salary > 3000;
--12. 입사일이 2000년 이후인 사원을 검색하시오.
select * from employ where hiredate >= '2000/01/01';
select * from employ where to_char(hiredate, 'yyyy') >= '2000';
--13. 이름에 '철' 이라는 문자를 포함하는 경우의 사원을 검색하시오.
select * from employ where name like('%철%');
--14. 보너스를 받지 않는(보너스가 null인) 사원을 검색하시오.
select * from employ where bonus is null or bonus = 0;
select * from employ where nvl(bonus,0) = 0;
--15. 입사일이 1999년도인 사원을 검색하시오.
select * from employ where substr(hiredate, 1, 2) = '99';
--16. 급여가 3000 이상인 사원만 급여를 10% 인상하시오.
-- update 테이블명 set 컬럼명 = 변경할값 where 조건;
update employ set salary = salary * 1.1 where salary >= 3000;
--17. 2001년 이후에 입사한 사원을 삭제하시오.
delete from employ where hiredate >= '2000/01/01';
rollback;

drop table emp01;
drop table lno;