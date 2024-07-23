--SELECT SUM(SAL) FROM EMP;
--SELECT AVG(SAL) FROM EMP;
--SELECT MAX(SAL), MIN(SAL) FROM EMP;
--SELECT COUNT(COMM) FROM EMP;


SELECT DEPTNO, COUNT(DEPTNO) AS "부서 인원" FROM EMP GROUP BY DEPTNO; -- DEPTNO 컬럼에 따라 묶은 뒤, 해당 집합의 갯수를 출력하고 중복 제거
SELECT DEPTNO, SUM(SAL)AS "연봉 합계" FROM EMP GROUP BY DEPTNO; 
SELECT COUNT(DEPTNO) FROM EMP; -- DEPTNO 컬럼의 총 행 수 출력

SELECT COMM, COUNT(COMM) FROM EMP GROUP BY COMM; -- COUNT(컬럼) : NULL 값 제거
SELECT COMM, COUNT(*) FROM EMP GROUP BY COMM; -- COUNT(*) : NULL 값 포함

-- 부서별 급여의 최대값이 2900을 초과하는 경우 부서별 최대값과 최소값 자료만 출력
SELECT DEPTNO, MAX(SAL), MIN(SAL)FROM EMP GROUP BY DEPTNO HAVING MAX(SAL) > 2900;


-- 테이블에서 1000 이상의 급여를 가지고 있는 사람들에 대해서만 부서별로 평균을 구한 후 구해진 부서별 평균 급여가 2000 이상인 부서번호와 부서별 평균 급여를 부서의 오름차순 출력
SELECT DEPTNO, AVG(SAL) FROM EMP WHERE SAL >= 1000 GROUP BY DEPTNO HAVING AVG(SAL) >= 2000 ORDER BY DEPTNO ASC;

-- 직종별, 부서별 급여의 합과 인원수를 구한 후 20번 부서의 내용만 출력
SELECT JOB, DEPTNO, SUM(SAL), COUNT(*) FROM EMP WHERE DEPTNO = 20 GROUP BY JOB, DEPTNO;

-- 부서별 급여의 평균과 합을 구한 후 각 부서별 인원이 5명 이상인 부서들만 출력
SELECT DEPTNO, AVG(SAL), SUM(SAL) FROM EMP GROUP BY DEPTNO HAVING COUNT(*) >= 5; 

-- 각 부서별, 직책 종류가 어떻게 되는지 검색
SELECT DEPTNO, JOB FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
SELECT DISTINCT DEPTNO, JOB FROM EMP ORDER BY DEPTNO, JOB;

-- CEIL(실수값)
SELECT CEIL(34.5678) FROM DUAL;

-- FLOOR (실수값)
SELECT FLOOR(34.5678) FROM DUAL;

-- ROUND (실수값) : 정수값으로 반올림처리
SELECT ROUND(34.5678) FROM DUAL;

-- ROUND (실수값, 소수점자리수) : 소수점자리수로 반올림처리
SELECT ROUND(34.5678, 2) FROM DUAL;

-- MOD (피젯수, 젯수) : 나머지 출력
SELECT MOD(34, 2), MOD(34, 5), MOD(34, 7) FROM DUAL;

-- 사번이 짝수인 사원들의 EMPNO, ENAME, JOB 출력
SELECT EMPNO, ENAME, JOB FROM EMP WHERE MOD(EMPNO, 2) = 0;

SELECT ROUND(345.678,2) FROM DUAL; -- 소수점 3자리숫자를 반올림해 소수점 2자리까지 출력

SELECT ROUND(345.678,0) FROM DUAL; -- 정수값까지 반올림

SELECT ROUND(345.678) FROM DUAL; -- 정수값까지 반올림

SELECT ROUND(345.678, -1) FROM DUAL; -- 소수점을 기준으로 왼쪽으로 한 칸 당겨 반올림

SELECT 'DataBase', LOWER('DataBase') FROM DUAL; -- DataBase를 모두 소문자로

SELECT ENAME, LOWER(ENAME) FROM EMP WHERE DEPTNO = 10; 

SELECT 'DataBase', UPPER('DataBase') FROM DUAL;

SELECT EMPNO, ENAME, JOB FROM EMP WHERE JOB = UPPER('MANAGER');

-- 값의 대소문자 관계없이 SMITH의 정보를 출력
SELECT * FROM EMP WHERE ENAME = UPPER('smith');
SELECT * FROM EMP WHERE LOWER(ENAME) = 'smith';

-- 컬럼명을 WC로 변경, 출력을 이름, 직업
SELECT ENAME || ', ' || JOB WC FROM EMP;

SELECT COUNT(DEPTNO) FROM EMP; -- 12 출력
SELECT COUNT(DISTINCT DEPTNO) FROM EMP; -- 3 출력 : 함수 내에 DISTINCT 혹은 함수 모두 중첩가능

-- 사원정보 테이블에서 부서번호가 20인 사람의 이름, 입사년도 정보를 가져오는데, 입사년도 컬럼의 값 중 첫번째 글자부터 2개 출력
SELECT ENAME, SUBSTR(HIREDATE, 1, 2) FROM EMP WHERE DEPTNO = 20;

-- 82년도에 입사한 사원
SELECT ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 1, 2) = '82';
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

-- 이름이 S로 끝나는 사원
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME, -1, 1) = 'S';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S';

SELECT DEPTNO, ENAME, INSTR(ENAME, 'E') FROM EMP WHERE DEPTNO = 30;

-- INSTR(대상,찾을 글자, 시작위치, 몇 번째 발견) : 특정 문자의 위치를 반환
SELECT INSTR('DataBase', 'a', 3, 1) FROM DUAL; -- 4 반환
SELECT INSTR('DataBase', 'a', -5, 2) FROM DUAL; -- 2 반환
SELECT INSTR('데이터베이스', '이', 3, 1) FROM DUAL; -- 5 반환

-- LPAD, RPAD (특정 기호로 채우기)
SELECT LPAD('DataBase', 20, '$') FROM DUAL; -- 문자열 칸수를 20칸으로 설정 후 빈칸에 왼쪽부터 $로 넣는다.
SELECT RPAD('DataBase', 20, '$') FROM DUAL;
-- 2407050001 처럼 주문번호 출력하기
SELECT '240705' ||LPAD('1', 4, '0') FROM DUAL;

-- TRIM (특정 문자 잘라내기)
SELECT LTRIM('aaaaaDataBase Programingaaaa', 'a'), RTRIM('aaaaaDataBase Programingaaaa', 'a'), TRIM('a' FROM 'aaaaaaaDataBase Programingaaaaaaaa') FROM DUAL;

-- NVL(해당컬럼, null일 때 돌려줄 값) : 첫 번째 인자값이 null이면 두번째 인자값으로 변경
SELECT AVG(NVL(COMM, 0)) AS AVG FROM EMP; -- COMM의 인자값이 null이면 0으로 대체 후 평균값 출력

-- 사원정보 테이블에서 사원명, 연봉, 커미션, 연봉*12 + 커미션의 값을 출력
SELECT ENAME, SAL, COMM, SAL*12 + COMM AS TOTAL FROM EMP; -- COMM의 null 값으로 인해 계산안되는 경우 발생
SELECT ENAME, SAL, COMM, SAL * 12 + NVL(COMM,0) AS TOTAL FROM EMP;  -- COMM의 null값을 0으로 변경 후 TOTAL 계산 -> 정상출력

-- 사원정보 테이블에서 커미션의 갯수를 출력
SELECT COUNT(COMM) FROM EMP; -- null은 포함되지 않음. -> 4 출력
SELECT COUNT(NVL(COMM, 0)) FROM EMP; -- COMM의 null 값을 0으로 대체 후 출력 -> 12 출력

-- 사원정보 테이블에서 커미션이 0보다 크거나 같은 사람들의 인원수 출력
SELECT COUNT(*) FROM EMP WHERE COMM >= 0; -- 4 출력
SELECT COUNT(*) FROM EMP WHERE NVL(COMM, 0) >= 0; -- comm의 null 값을 0으로 대체 후 출력 -> 12 출력

-- NVL2(해당컬럼, null이 아닐 때 돌려줄 값, null일 때 돌려줄 값)
select ename, comm, mgr, sal, nvl2(comm, sal+50, sal*01) from emp; -- comm의 값이 null이 아닐때는 연봉 + 50, null일 때는 연봉 * 01

select ename, comm, mgr, sal, nvl2(comm, '', 50) from emp; -- null이 아닐 경우 null값으로 돌려줄 수 있음.

-- COALESCE(데이터, 데이터, ...) : 데이터가 null이 아닌 것의 첫번째 값을 반환
select empno, comm, mgr sal, coalesce(comm, mgr, sal) from emp; -- comm의 데이터가 null이면 mgr의 데이터 반환
select empno, comm, mgr sal, coalesce(comm, sal*0.1) from emp;
select empno, comm, mgr sal, nvl(comm, sal * 0.1) from emp;

-- 산술관련
SELECT POWER(5,3), ROUND(SQRT(2),4) FROM DUAL;

-- 슈도컬럼
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
SELECT SYSDATE -1 어제, SYSDATE 오늘, SYSDATE + 1 내일 FROM DUAL; -- SYSDATE는 SYSDATE +1, -1처럼 값 계산이 가능하다.
SELECT SYSTIMESTAMP -1, SYSTIMESTAMP, SYSTIMESTAMP +1 FROM DUAL; -- SYSTIMESTAMP는 SYSTIMESTAMP +1 진행 시 시간부분 계산이 진행 안됨
SELECT ENAME, SYSDATE, HIREDATE, SYSDATE - HIREDATE AS 근속일자 FROM EMP WHERE DEPTNO = 10;

-- ROUND 함수의 다양한 적용
select hiredate, round(hiredate, 'MONTH') from emp where deptno = 10; -- 16일을 기준으로 반올림 -> 반올림 시, 다음 달 01일로 계산
select hiredate, round(hiredate, 'YEAR') from emp where deptno = 10; -- 7월을 기준으로 반올림 -> 반올림 시 다음년도 01월 01일로 계산

-- TRUNC 함수의 다양한 적용
SELECT HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP WHERE DEPTNO = 10;
SELECT TRUNC(234.567,1), TRUNC(234.567), TRUNC(234.567, -1), TRUNC(234.567, -2) FROM DUAL; -- 234.5, 234, 230, 200 출력

-- TO_CHAR (데이터, '출력형식') : 데이터를 출력형식대로 문자형자료형 값으로 변환하는 함수
select sysdate, to_char(sysdate, 'YYYY.MM.DD HH:MI:SS AM DAY') from dual; -- 오라클은 대소문자 구별 X, 시간은 MI으로 작성
select sysdate, to_char(sysdate, 'YYYY.MM.DD HH:MI:SS AM DAY'), systimestamp, to_char(systimestamp, 'YYYY.MM.DD HH:MI:SS.FF3 AM') from dual;

select to_char(hiredate, 'YYYY/MM/DD DAY') startday from emp where deptno = 10; // 해당하는 날짜의 요일도 출력할 수 있음
select to_char(sysdate, 'YYYY/MM/DD AM') startday from dual; -- AM : 한글로 '오후' 출력됨
-- DAY, AM과 같은 국가에 따라 달라지는 데이터를 가진 경우, nls_date_language=국가명 -> 국가의 표준표기법으로 표기하는 방법 
select to_char(sysdate, 'AM', 'NLS_DATE_LANGUAGE=AMERICAN') as AMERICAN, to_char(sysdate, 'AM', 'nls_date_language=korean') as KOREAN from dual;

-- 000,000,000 -> 우측정렬 / 999,999,999 -> 좌측정렬
select to_char(123456, '000,000,000'), to_char(123456, '999,999,999'), to_char(-123456, '000,000,000'), to_char(-123456, '999,999,999') from dual;
select to_char(123456, '00,000'), to_char(-123456, '000,000') from dual; -- 표현해야하는 데이터보다 표현범위가 작으면(데이터보다 칸수가 더 작으면) #### 출력 (값 깨짐)

select ename, nvl(to_char(mgr, ''), 'ceo') from emp where mgr is null; -- emp 테이블에서 mgr 값이 null인 사람의 사원명을 출력, mgr 값의 null을  ceo로 대체해 출력
select mgr, nvl(to_char(nvl(mgr,9999)), 'ceo') from emp;

select ename, hiredate from emp where hiredate = to_date('19810220', 'YYYYMMDD'); -- 오라클은 년도를 두 자리만 출력하지만, 1891년, 1981년, 2081년을 구별할 수 없어 년도는 네 자리로 작성할 것
select trunc((sysdate - to_date('2011-01-01', 'YYYY/MM/DD')) / 365) from dual; -- (오늘 날짜 - 2011년 1월 1일) / 365 : 근속년수 구하기


-- D: 요일을 숫자로 반환. 1 : 일요일, 2 : 월요일, ....
select to_char(to_date('2014-01-02'),'D') from dual;

select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'), systimestamp from dual;
select to_char(systimestamp, 'YYYY-MM-DD HH24:MI:SS'), systimestamp from dual;
--select to_date(systimestamp, 'YYYY-MM-DD HH24:MI.SS.FF3') from dual; -- 에러

-- next_day(기준날짜, 해당되는 요일) : 기준날짜를 기준으로 돌아오는 요일의 날짜 출력
select next_day(sysdate, '토요일') from dual; -- 24/07/06 출력
select next_day(sysdate, '금') from dual;
select next_day(sysdate, 7) from dual; -- 24/07/06 출력
select next_day(sysdate-8, '토요일') from dual; -- 24/06/29 출력
--select sysdate-8 from dual;

-- to_number (데이터, '출력형식') : 데이터를 숫자 자료형으로 변환 
-- ** 출력형식은 9만 가질 수 있음.
-- 숫자값에는 ,가 없기 때문에 '999,999' 형태의 형식을 넣어도 ,(콤마)는 출력되지 않는다.
-- 반드시 데이터의 자리수가 출력형식의 자리수보다 작아야만 한다. ex) to_number('10,000.123', '999,999.9) (X)
-- 출력형식에 지정한 자리수에 맞춰 데이터가 출력된다. ex) to_number('10,000', '999,999')와 to_number('10,000', '999,999,999')의 자리수는 차이가 있음
select to_number('1234567'), to_number('10,000.123', '999,999.999') from dual; -- 1234567 문자열 -> 숫자형으로 변환됨. 
select to_number('10,000', '999,999'), to_number('20,000', '999,999') from dual;
select to_number('10,000', '999,999') + to_number('20,000', '999,999') as sum from dual;
select to_number('10,000', '999,999'), to_number('20,000', '999,999') from dual;

-- 사원정보 테이블에서 사원명과 부서번호를 출력, 부서번호가 10이면 ACCOUNTING, 20이면 RESEARCH 그 외는 ETC로 출력되는데 그 컬럼의 이름은 DNAME으로 변경해서 출력
select ename, deptno, decode(
deptno,
10, 'ACCOUNTING',
20, 'RESEARCH',
'ETC'
) as DNAME from emp;

SELECT ENAME, JOB, SAL,
DECODE(
JOB,
'ANALYST', SAL + SAL *  0.05,
'SALESMAN', SAL + SAL * 0.1,
'MANAGER', SAL + SAL * 0.15,
'CLERK', SAL + SAL * 0.2
) AS "인상된 급여"
FROM EMP;

SELECT ENAME, SAL, 
CASE
    WHEN SAL >= 5000 THEN 'TOP'
	WHEN SAL >= 1500 THEN 'MID'
	WHEN SAL >= 3000 THEN 'HI'
	ELSE 'LOW'
END AS 비고
FROM EMP;
