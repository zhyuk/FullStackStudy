--SELECT ENAME || '의 총 급여는 ' || (SAL+COMM) || '입니다.' AS "결과"
--FROM EMP
--WHERE COMM IS NOT NULL;

--SELECT DISTINCT DEPTNO, ENAME FROM EMP; -- DISTINCT : 값의 중복 제거 후 출력, DISTINCT 컬럼명1, 컬럼명2 : 컬럼명1 컬럼명2를 결합 후 중복 제거 실행 -> 붙여서 모두 출력됨
--SELECT DISTINCT JOB FROM EMP; -- 사원테이블에서 직책의 종류를 가져오기
--SELECT * FROM EMP WHERE MGR = 7566; -- JONES가 관리하는 부하직원 가져오기
--SELECT DISTINCT JOB FROM EMP WHERE MGR = 7698; -- BLAKE가 관리하는 부하직원을 검색한 뒤 해당 부하직원들의 직책은 어떤 것이 있는지 가져오기


/*  컬럼 별칭 : SELECT 컬럼명 [AS] 별칭명
    컬럼 별칭 : SELECT 컬럼명 [AS] "별칭명"
    "" 큰 따옴표를 붙여야하는 이유 : 별칭에 공백이 들어가 있거나, 특수문자가 포함되거나, 대소문자를 구분해서 출력하고자 할때
*/