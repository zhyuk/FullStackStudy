-- 평균 급여보다 더 많은 급여를 받는 사원을 검색, 많이 받는 사람 순으로 출력
select * from emp where sal > (select avg(sal) from emp) order by sal desc;

-- 부서번호가 10번인 사원 중에서 최대 급여를 받는 사원의 사원 번호와 사원명
select empno, ename from emp where sal = (select max(sal) from emp where deptno = 10) and deptno = 10;

-- 부서번호가 할당된 직원의 정보를 가져오세요
select * from emp where deptno in(select deptno from dept);

-- 직원이 할당되지 않은 부서의 부서번호, 부서명, 위치 출력 
select *  from dept where deptno not in(select distinct deptno from emp where deptno is not null);
select * from dept where not deptno in(select distinct deptno from emp where deptno is not null);

-- 급여를 3000 이상 받는 사원과 동일한 부서에서 일하는 사원들의 사원명, 급여, 부서번호
select ename, sal, deptno from emp where deptno in (select deptno from emp where sal >= 3000);

-- 각 부서별 최소 연봉을 받는 사람들과 동일한 급여를 받는 사원의 사원명, 급여, 부서번호 출력
select ename, sal, deptno from emp where sal in (select min(sal) from emp group by deptno);

-- ALL 연산자
select * from emp where sal < all (1000,2000,3000) order by sal; -- 컬럼명 < all () : 가장 작은 값인 1000 반환 => 1000보다 작은 연봉을 가진 사람의 정보 출력
select * from emp where sal > all (1000,2000,3000) order by sal; -- 컬럼명 > all () : 가장 큰 값인 3000 반환 => 3000보다 큰 연봉을 가진 사람의 정보 출력

select ename, sal from emp where sal > all(select sal from emp where deptno = 30); -- 서브쿼리 : 2850 반환 -> 연봉이 2850 이상인 사람의 이름, 연봉 출력
-- select sal from emp where deptno = 30; 

-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값보다 적은 급여를 받는 사람의 이름, 급여, 부서번호 출력
select ename, sal, deptno from emp where sal < all(select sal from emp where deptno = 30);

-- 부서별 평균 연봉 중 최대 평균 연봉보다 더 큰 연봉을 받는 사원의 사번, 이름, 직책, 연봉 출력
select empno, ename, job, sal from emp where sal > all(select avg(sal) from emp group by deptno); -- 2916.6666.. 보다 큰 연봉을 가진
--select avg(sal) from emp group by deptno;

-- ANY 연산자
select * from emp where sal < any(1000,2000,3000) order by sal; -- 컬럼명 < any () : 가장 큰 값 반환 ->  3000보다 작은 연봉을 가진 사람의 정보 출력
select * from emp where sal > any(1000,2000,3000) order by sal; -- 컬럼명 > any () : 가장 작은 값 반환 ->  1000보다 큰 연봉을 가진 사람의 정보 출력

-- SALES 부서에 근무하는 사원들의 최소연봉보다 큰 연봉을 받는 사원 중 SALES 부서를 제외한 사원의 사번, 이름, 부서번호, 연봉 출력
select empno, ename, deptno, sal from emp where deptno != (select deptno from dept where dname = 'SALES') and sal > any (select sal from emp where deptno = (select deptno from dept where dname = 'SALES'));

-- CLERK 직책이 아니면서 CLERK이 받는 최고 급여보다 더 적은 급여를 받는 사원을 출력
select * from emp where job != 'CLERK' and sal < any(select sal from emp where job = 'CLERK');
select sal from emp where job = 'CLERK';
-- CLERK 사무직, 사원

drop table dept01;

-- emp 테이블 구조만 복사해 emp04, emp05 테이블 생성
create table emp04 as select * from emp where 1 = 0;
create table emp05 as select * from emp where 1 = 0;

-- INSERT ALL INTO : 여러 개의 테이블에 여러 행의 데이터를 삽입하는 명령문
insert all into emp04 values (empno, ename, job, mgr, hiredate, sal, comm, deptno) select * from emp; -- emp 테이블의 데이터 그대로 emp04 테이블에 삽입
select * from emp;
rollback;

insert all into emp04 (empno, ename, deptno) values (empno, ename, deptno) select empno, ename, deptno from emp;
/* select empno, ename, deptno from emp; -- 7369	SMITH	20 / 7499	ALLEN	30 / .... 한 줄씩 가져온다. 
    -> 한 줄씩 가져온 데이터를 emp04 values (empno, ename, deptno) 순서대로 대입
    -> emp04 테이블 생성됨
*/
--insert all into emp04 (empno, ename, deptno) values (empno, ename, deptno) select * from emp; -- 가능함. 서브쿼리의 모든 정보를 가져와 서브쿼리의 empno, ename, deptno 데이터만 사용한다는 의미
rollback;

insert all into emp04 into emp05 values (empno, ename, job, mgr, hiredate, sal,  comm, deptno) select * from emp; --> emp04, emp05, emp 테이블 모두 구조가 똑같아서 values 하나만 기술 가능
/*  select * from emp : 7369	SMITH	20 / 7499	ALLEN	30 / .... => emp 테이블의 모든 정보 가져옴.
    values (empno, ename, job, mgr, hiredate, comm, deptno) : emp 테이블의 empno, ename, job, mgr, hiredate, comm, deptno 컬럼의 값을 넣어줌
    emp04, emp05 테이블 생성
*/
rollback;

-- emp04 테이블은 empno, ename, job 컬럼만, emp05 테이블은 empno, ename, mgr, job 컬럼만 남기기
alter table emp04 drop (mgr, hiredate, sal, comm, deptno);
alter table emp05 drop (hiredate, sal, comm, deptno);

insert all into emp04 values(empno, ename, job) into emp05 values(empno, ename, job, mgr) select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
-- 에러. emp05 values(empno, ename, mgr, job) -> 컬럼을 생략할 수 있는 조건 중 컬럼의 순서대로 값을 넣는 조건 미충족
rollback;

insert all into emp04 values (empno, ename, job) into emp05 values (empno, ename, job, empno) select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
-- 정상실행. empno와 mgr의 자료형은 정수형 4자리로 동일하기 때문에 가능
rollback;

drop table emp04;
drop table emp05;

-- emp 테이블의 empno, ename, sal 컬럼의 구조만 복사해 emp01 테이블 생성
create table emp01 as select empno, ename, sal from emp where 1 = 0;
-- emp 테이블의 empno, ename 컬럼만 구조와 데이터를 복사해 emp02 테이블 생성
create table emp02 as select empno, ename from emp;

-- emp테이블에서 부서번호가 20번 이상의 사원들의 데이터를 가져와서 emp01 테이블과 emp02 테이블에 복사해 넣으세요
insert all into emp01 values (empno, ename, sal) into emp02 values (empno, ename) select * from emp where deptno >= 20;
rollback;

-- emp02 테이블에 comm 컬럼 추가
alter table emp02 add (comm number(7,2));

-- emp 테이블에서 평균급여보다 더 높은 사원의 정보를 가져와서 emp01 테이블에는 사번, 이름, 연봉을 넣고, emp02 테이블에는 사번, 이름만 넣으세요.
insert all into emp01 values (empno, ename, sal) into emp02 (empno, ename) values (empno, ename) select * from emp where sal > (select avg(sal) from emp);
insert all into emp01 values (empno, ename, sal) into emp02 values (empno, ename, '') select * from emp where sal > (select avg(sal) from emp);
--select * from emp where sal > (select avg(sal) from emp); -- 서브쿼리
rollback;

drop table emp01;
drop table emp02;

-- dept 테이블의 구조만 복사해서 dept01 테이블 생성
create table dept01 as select * from dept where 1 = 0;

insert all into dept01 values (deptno, dname, loc) select * from dept;
commit;

-- dept 테이블에서 40번 부서의 위치를 가져와서 dept01 테이블 안의 10번 부서에 해당하는 위치의 값을 변경
--update 테이블명 set 컬럼명 = 값 where 조건문
update dept01 set loc = (select loc from dept where deptno = 40) where deptno = 10;
--select loc from dept where deptno = 40 : 서브쿼리

-- 다중컬럼 서브쿼리
-- emp 테이블 내 empno 컬럼, enames 컬럼의 값이 7839, 'KING'과 동일한지 비교
select * from emp where (empno, ename) = (select 7839, 'KING' from dual); -- emp 테이블 내 empno의 값이 7839와 같은 행을 출력 -> 다중 컬럼 단일 행
select * from emp where (empno, ename) in (select empno, ename from emp where deptno = 20); -- -> 다중 컬럼 다중 행

-- dept01 테이블에서 부서번호가 20인 데이터의 부서명과 장소를 dept 테이블의 부서번호가 30인 데이터의 부서명과 장소로 변경
update dept01 set(dname,loc) = (select dname, loc from dept where deptno = 30) where deptno = 20;
-- 기존 데이터 :     20  RESEARCH    DALLAS
-- 변경 데이터 :     20  SALES       CHICAGO
rollback;

create table emp01 as select * from emp;

alter table emp01 add (dnm varchar2(20));

-- dept 테이블에서 해당 부서명을 가져와서 emp01 테이블에 넣으세요
update emp01 e set dnm = (select dname from dept d where d.deptno = e.deptno);
-- 테이블의 별칭선언 시 'as' 사용 금지
commit;

update emp01 set (empno, ename) = (select 1111, '첫째' from dual); -- emp01 테이블에 모든 행의 empno, ename 컬럼을 1111, '첫째'로 변경
rollback;

-- dept 테이블에 부서명이 SALES인 행의 부서번호를 가져와서 그 값이  emp01 테이블의 부서번호와 동일한 행을 삭제 --> 부서번호가 30인 행 모두 삭제
delete from emp01 where deptno = (select deptno from dept where dname = 'SALES'); 
delete from emp01 where deptno != (select deptno from dept where dname = 'SALES'); --> 부서번호가 30이 아닌 행 모두 삭제
delete from emp01 where deptno in (select deptno from dept where dname != 'SALES'); --> 부서번호가 30이 아닌 부서번호 출력 => 10, 20, 40 출력 
rollback;

drop table emp01;
drop table dept01;

-- dept 테이블 deptno -> primary key, dname -> not null
-- alter table 테이블명 add constraint 제약조건명 제약조건유형 (컬럼명);
-- alter table 테이블명 modify (컬럼명 constraint 제약조건명 제약조건유형);
alter table dept add constraint dept_deptno_pk primary key(deptno);
alter table dept modify (dname constraint dept_dname_nn not null);

-- emp 테이블 empno -> primary key, deptno -> r 
alter table emp add constraint emp_empno_pk primary key(empno);
--alter table emp modify (empno constraint emp_empno_pk primary key);
alter table emp add constraint emp_deptno_fk foreign key(deptno) REFERENCES dept(deptno);

drop table dept;
drop table emp;

create table emp as select * from scott.emp;
create table dept as select * from scott.dept;

create table emp01 as select * from emp; -- 제약조건은 함께 복사되지 않음.
create table dept01 as select * from dept; -- 제약조건은 함께 복사되지 않음.
drop table dept01;
drop table emp01;

-- 제약조건 삭제
alter table emp drop constraint emp_deptno_fk;
alter table emp drop constraint emp_empno_pk;
alter table dept drop constraint dept_deptno_pk;
alter table dept drop constraint dept_dname_nn;

-- 동등조인 : Equi Join
-- from A 테이블, B 테이블인 경우 A 테이블의 데이터부터 출력되고 그 뒤에 B 테이블의 데이터이 붙는다.
select * from emp,dept where emp.deptno = dept.deptno;
-- 교차조인 : CATASIAN PRODUCT JOIN
select * from dept, emp;
-- 교차조인 : ANSI CROSS JOIN
select * from dept cross join emp;

-- 내부조인 (Inner Join)
-- 테이블별칭은 출력되지 않음 -> e.ename이 출력될 때 ename으로 출력됨
select e.ename, d.dname, e.deptno as edno, d.deptno as ddno from emp e, dept d where e.deptno = d.deptno order by ddno;
-- 내부조인 (ANSI INNER JOIN)
-- from A inner join B on 조인조건 where where조건절
-- ANSI INNER JOIN의 경우 INNER 생략 가능
-- 해석순서 : FROM절 - ON절 - WHERE절 - SELECT절 - ORDER BY절 == SELECT절에서 선언한 EDNO 별칭은 ORDER BY절에서만 사용가능
select e.ename, d.dname, e.deptno as edno, d.deptno as ddno from emp e inner join dept d on e.deptno = d.deptno where e.deptno = 20 order by ddno;
--select e.ename, d.dname, e.deptno as edno, d.deptno as ddno from emp e [inner] join dept d on e.deptno = d.deptno where e.deptno = 20 order by ddno;

-- emp 테이블과 departments 테이블을 이너조인하여 emp 테이블의 사번,이름,부서번호와 departments 테이블의 부서번호, 부서명, 상위부서번호가 출력되도록
select e.empno, e.ename, e.deptno, d.department_id, d.department_name, d.manager_id from emp e inner join departments d on e.deptno = d.department_id; -- ANSI INNER JOIN
select e.empno, e.ename, e.deptno, d.department_id, d.department_name, d.manager_id from emp e, departments d where e.deptno = d.department_id ; -- INNER JOIN

-- emp 테이블의 모든 컬럼, departments 테이블에서는 부서명과 상위부서번호만 출력
select e.*, d.department_name, d.manager_id from emp e inner join departments d on e.deptno = d.department_id;

-- 커미션을 받는 모든 사원의 이름, 부서번호, 부서명, 위치 출력
-- 커미션을 받는 == 0이 아니고, null이 아닌
select e.ename, e.deptno, d.dname, d.loc from emp e inner join dept d on e.deptno = d.deptno where nvl(e.comm,0)> 0; -- ANSI INNER JOIN
select e.ename, e.deptno, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno and nvl(e.comm,0) > 0; -- INNER JOIN
-- 컬럼명의 중복이 없어 필수로 별칭 사용할 필요 X 

-- 이름에 a가 들어가는 모든 사원의 이름과 부서명 표시
select e.ename, d.dname from emp e, dept d where e.deptno = d.deptno and e.ename like('%A%'); -- INNER JOIN
select e.ename, d.dname from emp e inner join dept d on e.deptno = d.deptno where e.ename like('%A%'); -- ANSI INNER JOIN

-- 서브쿼리가 select절에 올 수 있기 때문에 해당 방식으로도 가능
select ename, (select dname from dept where dept.deptno = emp.deptno)dname from emp where ename like('%A%');