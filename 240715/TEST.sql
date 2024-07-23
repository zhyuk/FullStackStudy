-- 의사컬럼 : rownum
select * from customers where rownum <= 1000 and cust_gender = 'M'; -- rownum이 1000 이하 그리고 cust_gender 컬럼의 데이터가 M인 데이터만 출력
--select * from customers where rownum > 1000 and cust_gender = 'M'; -- 출력 X, 단순쿼리일 때 rownum은 크다 사용 불가.

-- 서브쿼리 시
select rownum rn, c.* from (select * from customers where cust_gender = 'M') c where rownum <= 500;
select * from (select rownum rn,sc.* from customers sc where cust_gender = 'M')c where rn >= 50; // 서브쿼리 내에서 rownum에 대한 데이터를 출력한 뒤에 메인쿼리로 나와야만 '크다, 크거나 같다'의 조건도 쓸 수 있다.


select * from (select rownum rn, c2.* from customers c2 where cust_gender = 'M') where rn between 10 and 13;
--select rownum rn, c2.* from customers c2 where cust_gender = 'M'를 통해 rownum의 값을 rn 컬럼에 출력된다.
select * from(select rownum rn, c2.* from customers c2 where cust_gender = 'M' order by cust_id desc) where rn >= 50 and rn <= 100; -- ROWNUM이 50~100 사이인 데이터 출력
select rownum rn, c2.* from customers c2 where cust_gender = 'M' order by cust_id desc; -- order by절을 사용할 경우, 조건에 의해 rownum이 섞이게 된다.
select * from(select rownum rn, c1.* from (select c2.* from customers c2 where cust_gender = 'M' order by cust_id desc)c1) where rn between 10 and 20; -- 따라서 이와 같이 서브쿼리로 엮은 뒤 rownum 생성


-- MERGE명령문 
-- EMP 테이블에 VARCHAR2(20)자료형 DNAME 컬럼 생성
alter table emp add (dname varchar2(20));
-- on (emp.deptno = dept.deptno) : emp 테이블의 deptno 컬럼과 dept 테이블의 deptno 컬럼의 데이터가 동일하는지 확인 -> 일치 시 when matched then 실행, 미일치 시 when not matched then 실행
merge into emp using dept on (emp.deptno = dept.deptno) when matched then update set emp.dname = dept.dname delete where emp.mgr is null when not matched then insert (empno, ename) values (9999, 'TEST');
rollback; -- insert, update, delete는 DML이라 가능

create table emp01 as select * from emp;
merge into emp01 a using (select empno, sal, job from emp where deptno = 10) b on (a.empno = b.empno) when matched then update set a.sal = b.sal + b.sal * 0.01 when not matched then insert (a.empno, sal, job) values (b.empno, b.sal, b.job);
select empno, sal, job from emp where deptno = 10; -- deptno가 10인 empno, sal, job 데이터 출력
rollback;

merge into emp01 a using (select empno, sal, job from emp where deptno = 20)b on (a.empno = b.empno) when not matched then insert (a.empno, sal, job) values (b.empno, b.sal, b.job) when matched then update set a.sal = b.sal + b.sal * 0.01;
rollback;

merge into emp01 a using (select empno, sal, job from emp where ename = 'KING' and deptno = 10) b on (a.empno = b.empno) when matched then update set a.sal = 8000 when not matched then insert (a.empno,sal, job) values (b.empno, b.sal, b.job);
rollback;

-- delte문은 조건에 걸린것만 적용된다.
merge into emp01 a using (select empno, sal, job from emp where ename = 'KING' and deptno = 10) b on (a.empno = b.empno) when matched then update set a.sal = 8000 delete where a.deptno = 10 when not matched then insert (a.empno,sal, job) values (b.empno, b.sal, b.job);
rollback;

merge into (select * from emp01 where deptno = 10)A using (select empno, sal, job from emp)B on (A.empno = B.empno) when matched then update set A.sal = 8000 when not matched then insert(A.empno, A.sal, A.job) values (B.empno, B.sal, B.job);
-- select * from emp01 where deptno = 10; -- 7782, 7839, 7934
-- select empno, sal, job from emp; -- 7369, 7499, 7521, 7566, 7654, 7698, 7782, 7839, 7844, 7900, 7902, 7934
-- 7782, 7839, 7934 행의 sal = 8000 그 외 9개의 행은 insert 됨
rollback;

-- 집합연산자
create table goods_kor(seq number primary key, country varchar2(10), goods varchar2(80) not null);
create sequence kor_seq nocache;

insert into goods_kor(seq, country, goods) values (1, '한국', '원유제외 석유류');
insert into goods_kor values(2, '한국', '자동차');
insert into goods_kor values(3, '한국', '전자집적회로');
insert into goods_kor values(4, '한국', '선박');
insert into goods_kor values(5, '한국', 'LCD');
insert into goods_kor values(6, '한국', '자동차부품');
insert into goods_kor values(7, '한국', '휴대전화');

create table goods_jap(seq number primary key, country varchar2(10), goods varchar2(80) not null);
create sequence jap_seq nocache;

insert into goods_jap values(1, '일본', '자동차');
insert into goods_jap values(2, '일본', '자동차부품');
insert into goods_jap values(3, '일본', '화물차');
insert into goods_jap values(4, '일본', '건설기계');
insert into goods_jap values(5, '일본', '다이오드');
insert into goods_jap values(6, '일본', '트랜지스터');
insert into goods_jap values(7, '일본', '반도체웨이퍼');

commit;

-- 합집합 UNION, UNION ALL
SELECT GOODS FROM GOODS_KOR UNION SELECT GOODS FROM GOODS_JAP; -- 정렬을 하지않아 영어-한글 순으로 오름차순됨.
SELECT GOODS FROM GOODS_KOR UNION ALL SELECT GOODS FROM GOODS_JAP; -- A 테이블의 모든 컬럼 출력 후 B 테이블의 모든 컬럼 출력.
SELECT GOODS FROM GOODS_JAP UNION SELECT GOODS FROM GOODS_KOR; -- A,B 테이블의 위치가 다르지만 중복을 제거하고 정렬하지 않아 자동으로 오름차순되기 때문에 동일한 값 출력
-- SELECT COUNTRY, GOODS FROM GOODS_KOR UNION SELECT GOODS FROM GOODS_JAP; -- 에러. 컬럼의 갯수와 컬럼의 자료형의 위치가 동일해야만 집합 가능
SELECT COUNTRY, GOODS FROM GOODS_KOR UNION SELECT COUNTRY, GOODS FROM GOODS_JAP; 
-- SELECT GOODS FROM GOODS_KOR UNION SELECT DNAME FROM DEPT ORDER BY GOODS; -- 컬럼의 갯수, 컬럼의 자료형을 맞췄기 때문에 출력됨.
-- SELECT GOODS FROM GOODS_KOR UNION SELECT DNAME FROM DEPT ORDER BY DNAME; -- 에러. ORDERT BY절에는 왼쪽 혹은 위에 기술된(먼저 기술된) 테이블만 인식할 수 있기때문

-- 교집합 INTERSECT
SELECT GOODS FROM GOODS_KOR INTERSECT SELECT GOODS FROM GOODS_JAP;

UPDATE GOODS_KOR SET GOODS='자동차' WHERE SEQ = 3;
UPDATE GOODS_KOR SET GOODS='자동차부품' WHERE SEQ = 4;
COMMIT;

SELECT GOODS FROM GOODS_KOR INTERSECT SELECT GOODS FROM GOODS_JAP;
SELECT GOODS FROM GOODS_KOR UNION SELECT GOODS FROM GOODS_JAP;
SELECT GOODS FROM GOODS_KOR UNION ALL SELECT GOODS FROM GOODS_JAP;

-- 차집합 MINUS
SELECT GOODS FROM GOODS_KOR;
SELECT GOODS FROM GOODS_JAP;
SELECT GOODS FROM GOODS_KOR MINUS SELECT GOODS FROM GOODS_JAP; -- GOODS_KOR과 GOODS_JAP에 중복되지 않은 데이터 출력

rollback; -- 오라클 내에서 작업한 것은 롤백 가능. 하지만, 자바에서는 뭐든지 자동커밋됨.