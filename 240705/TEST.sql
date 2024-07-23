--SELECT SUM(SAL) FROM EMP;
--SELECT AVG(SAL) FROM EMP;
--SELECT MAX(SAL), MIN(SAL) FROM EMP;
--SELECT COUNT(COMM) FROM EMP;


SELECT DEPTNO, COUNT(DEPTNO) AS "�μ� �ο�" FROM EMP GROUP BY DEPTNO; -- DEPTNO �÷��� ���� ���� ��, �ش� ������ ������ ����ϰ� �ߺ� ����
SELECT DEPTNO, SUM(SAL)AS "���� �հ�" FROM EMP GROUP BY DEPTNO; 
SELECT COUNT(DEPTNO) FROM EMP; -- DEPTNO �÷��� �� �� �� ���

SELECT COMM, COUNT(COMM) FROM EMP GROUP BY COMM; -- COUNT(�÷�) : NULL �� ����
SELECT COMM, COUNT(*) FROM EMP GROUP BY COMM; -- COUNT(*) : NULL �� ����

-- �μ��� �޿��� �ִ밪�� 2900�� �ʰ��ϴ� ��� �μ��� �ִ밪�� �ּҰ� �ڷḸ ���
SELECT DEPTNO, MAX(SAL), MIN(SAL)FROM EMP GROUP BY DEPTNO HAVING MAX(SAL) > 2900;


-- ���̺��� 1000 �̻��� �޿��� ������ �ִ� ����鿡 ���ؼ��� �μ����� ����� ���� �� ������ �μ��� ��� �޿��� 2000 �̻��� �μ���ȣ�� �μ��� ��� �޿��� �μ��� �������� ���
SELECT DEPTNO, AVG(SAL) FROM EMP WHERE SAL >= 1000 GROUP BY DEPTNO HAVING AVG(SAL) >= 2000 ORDER BY DEPTNO ASC;

-- ������, �μ��� �޿��� �հ� �ο����� ���� �� 20�� �μ��� ���븸 ���
SELECT JOB, DEPTNO, SUM(SAL), COUNT(*) FROM EMP WHERE DEPTNO = 20 GROUP BY JOB, DEPTNO;

-- �μ��� �޿��� ��հ� ���� ���� �� �� �μ��� �ο��� 5�� �̻��� �μ��鸸 ���
SELECT DEPTNO, AVG(SAL), SUM(SAL) FROM EMP GROUP BY DEPTNO HAVING COUNT(*) >= 5; 

-- �� �μ���, ��å ������ ��� �Ǵ��� �˻�
SELECT DEPTNO, JOB FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
SELECT DISTINCT DEPTNO, JOB FROM EMP ORDER BY DEPTNO, JOB;

-- CEIL(�Ǽ���)
SELECT CEIL(34.5678) FROM DUAL;

-- FLOOR (�Ǽ���)
SELECT FLOOR(34.5678) FROM DUAL;

-- ROUND (�Ǽ���) : ���������� �ݿø�ó��
SELECT ROUND(34.5678) FROM DUAL;

-- ROUND (�Ǽ���, �Ҽ����ڸ���) : �Ҽ����ڸ����� �ݿø�ó��
SELECT ROUND(34.5678, 2) FROM DUAL;

-- MOD (������, ����) : ������ ���
SELECT MOD(34, 2), MOD(34, 5), MOD(34, 7) FROM DUAL;

-- ����� ¦���� ������� EMPNO, ENAME, JOB ���
SELECT EMPNO, ENAME, JOB FROM EMP WHERE MOD(EMPNO, 2) = 0;

SELECT ROUND(345.678,2) FROM DUAL; -- �Ҽ��� 3�ڸ����ڸ� �ݿø��� �Ҽ��� 2�ڸ����� ���

SELECT ROUND(345.678,0) FROM DUAL; -- ���������� �ݿø�

SELECT ROUND(345.678) FROM DUAL; -- ���������� �ݿø�

SELECT ROUND(345.678, -1) FROM DUAL; -- �Ҽ����� �������� �������� �� ĭ ��� �ݿø�

SELECT 'DataBase', LOWER('DataBase') FROM DUAL; -- DataBase�� ��� �ҹ��ڷ�

SELECT ENAME, LOWER(ENAME) FROM EMP WHERE DEPTNO = 10; 

SELECT 'DataBase', UPPER('DataBase') FROM DUAL;

SELECT EMPNO, ENAME, JOB FROM EMP WHERE JOB = UPPER('MANAGER');

-- ���� ��ҹ��� ������� SMITH�� ������ ���
SELECT * FROM EMP WHERE ENAME = UPPER('smith');
SELECT * FROM EMP WHERE LOWER(ENAME) = 'smith';

-- �÷����� WC�� ����, ����� �̸�, ����
SELECT ENAME || ', ' || JOB WC FROM EMP;

SELECT COUNT(DEPTNO) FROM EMP; -- 12 ���
SELECT COUNT(DISTINCT DEPTNO) FROM EMP; -- 3 ��� : �Լ� ���� DISTINCT Ȥ�� �Լ� ��� ��ø����

-- ������� ���̺��� �μ���ȣ�� 20�� ����� �̸�, �Ի�⵵ ������ �������µ�, �Ի�⵵ �÷��� �� �� ù��° ���ں��� 2�� ���
SELECT ENAME, SUBSTR(HIREDATE, 1, 2) FROM EMP WHERE DEPTNO = 20;

-- 82�⵵�� �Ի��� ���
SELECT ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 1, 2) = '82';
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

-- �̸��� S�� ������ ���
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME, -1, 1) = 'S';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S';

SELECT DEPTNO, ENAME, INSTR(ENAME, 'E') FROM EMP WHERE DEPTNO = 30;

-- INSTR(���,ã�� ����, ������ġ, �� ��° �߰�) : Ư�� ������ ��ġ�� ��ȯ
SELECT INSTR('DataBase', 'a', 3, 1) FROM DUAL; -- 4 ��ȯ
SELECT INSTR('DataBase', 'a', -5, 2) FROM DUAL; -- 2 ��ȯ
SELECT INSTR('�����ͺ��̽�', '��', 3, 1) FROM DUAL; -- 5 ��ȯ

-- LPAD, RPAD (Ư�� ��ȣ�� ä���)
SELECT LPAD('DataBase', 20, '$') FROM DUAL; -- ���ڿ� ĭ���� 20ĭ���� ���� �� ��ĭ�� ���ʺ��� $�� �ִ´�.
SELECT RPAD('DataBase', 20, '$') FROM DUAL;
-- 2407050001 ó�� �ֹ���ȣ ����ϱ�
SELECT '240705' ||LPAD('1', 4, '0') FROM DUAL;

-- TRIM (Ư�� ���� �߶󳻱�)
SELECT LTRIM('aaaaaDataBase Programingaaaa', 'a'), RTRIM('aaaaaDataBase Programingaaaa', 'a'), TRIM('a' FROM 'aaaaaaaDataBase Programingaaaaaaaa') FROM DUAL;

-- NVL(�ش��÷�, null�� �� ������ ��) : ù ��° ���ڰ��� null�̸� �ι�° ���ڰ����� ����
SELECT AVG(NVL(COMM, 0)) AS AVG FROM EMP; -- COMM�� ���ڰ��� null�̸� 0���� ��ü �� ��հ� ���

-- ������� ���̺��� �����, ����, Ŀ�̼�, ����*12 + Ŀ�̼��� ���� ���
SELECT ENAME, SAL, COMM, SAL*12 + COMM AS TOTAL FROM EMP; -- COMM�� null ������ ���� ���ȵǴ� ��� �߻�
SELECT ENAME, SAL, COMM, SAL * 12 + NVL(COMM,0) AS TOTAL FROM EMP;  -- COMM�� null���� 0���� ���� �� TOTAL ��� -> �������

-- ������� ���̺��� Ŀ�̼��� ������ ���
SELECT COUNT(COMM) FROM EMP; -- null�� ���Ե��� ����. -> 4 ���
SELECT COUNT(NVL(COMM, 0)) FROM EMP; -- COMM�� null ���� 0���� ��ü �� ��� -> 12 ���

-- ������� ���̺��� Ŀ�̼��� 0���� ũ�ų� ���� ������� �ο��� ���
SELECT COUNT(*) FROM EMP WHERE COMM >= 0; -- 4 ���
SELECT COUNT(*) FROM EMP WHERE NVL(COMM, 0) >= 0; -- comm�� null ���� 0���� ��ü �� ��� -> 12 ���

-- NVL2(�ش��÷�, null�� �ƴ� �� ������ ��, null�� �� ������ ��)
select ename, comm, mgr, sal, nvl2(comm, sal+50, sal*01) from emp; -- comm�� ���� null�� �ƴҶ��� ���� + 50, null�� ���� ���� * 01

select ename, comm, mgr, sal, nvl2(comm, '', 50) from emp; -- null�� �ƴ� ��� null������ ������ �� ����.

-- COALESCE(������, ������, ...) : �����Ͱ� null�� �ƴ� ���� ù��° ���� ��ȯ
select empno, comm, mgr sal, coalesce(comm, mgr, sal) from emp; -- comm�� �����Ͱ� null�̸� mgr�� ������ ��ȯ
select empno, comm, mgr sal, coalesce(comm, sal*0.1) from emp;
select empno, comm, mgr sal, nvl(comm, sal * 0.1) from emp;

-- �������
SELECT POWER(5,3), ROUND(SQRT(2),4) FROM DUAL;

-- �����÷�
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
SELECT SYSDATE -1 ����, SYSDATE ����, SYSDATE + 1 ���� FROM DUAL; -- SYSDATE�� SYSDATE +1, -1ó�� �� ����� �����ϴ�.
SELECT SYSTIMESTAMP -1, SYSTIMESTAMP, SYSTIMESTAMP +1 FROM DUAL; -- SYSTIMESTAMP�� SYSTIMESTAMP +1 ���� �� �ð��κ� ����� ���� �ȵ�
SELECT ENAME, SYSDATE, HIREDATE, SYSDATE - HIREDATE AS �ټ����� FROM EMP WHERE DEPTNO = 10;

-- ROUND �Լ��� �پ��� ����
select hiredate, round(hiredate, 'MONTH') from emp where deptno = 10; -- 16���� �������� �ݿø� -> �ݿø� ��, ���� �� 01�Ϸ� ���
select hiredate, round(hiredate, 'YEAR') from emp where deptno = 10; -- 7���� �������� �ݿø� -> �ݿø� �� �����⵵ 01�� 01�Ϸ� ���

-- TRUNC �Լ��� �پ��� ����
SELECT HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP WHERE DEPTNO = 10;
SELECT TRUNC(234.567,1), TRUNC(234.567), TRUNC(234.567, -1), TRUNC(234.567, -2) FROM DUAL; -- 234.5, 234, 230, 200 ���

-- TO_CHAR (������, '�������') : �����͸� ������Ĵ�� �������ڷ��� ������ ��ȯ�ϴ� �Լ�
select sysdate, to_char(sysdate, 'YYYY.MM.DD HH:MI:SS AM DAY') from dual; -- ����Ŭ�� ��ҹ��� ���� X, �ð��� MI���� �ۼ�
select sysdate, to_char(sysdate, 'YYYY.MM.DD HH:MI:SS AM DAY'), systimestamp, to_char(systimestamp, 'YYYY.MM.DD HH:MI:SS.FF3 AM') from dual;

select to_char(hiredate, 'YYYY/MM/DD DAY') startday from emp where deptno = 10; // �ش��ϴ� ��¥�� ���ϵ� ����� �� ����
select to_char(sysdate, 'YYYY/MM/DD AM') startday from dual; -- AM : �ѱ۷� '����' ��µ�
-- DAY, AM�� ���� ������ ���� �޶����� �����͸� ���� ���, nls_date_language=������ -> ������ ǥ��ǥ������� ǥ���ϴ� ��� 
select to_char(sysdate, 'AM', 'NLS_DATE_LANGUAGE=AMERICAN') as AMERICAN, to_char(sysdate, 'AM', 'nls_date_language=korean') as KOREAN from dual;

-- 000,000,000 -> �������� / 999,999,999 -> ��������
select to_char(123456, '000,000,000'), to_char(123456, '999,999,999'), to_char(-123456, '000,000,000'), to_char(-123456, '999,999,999') from dual;
select to_char(123456, '00,000'), to_char(-123456, '000,000') from dual; -- ǥ���ؾ��ϴ� �����ͺ��� ǥ�������� ������(�����ͺ��� ĭ���� �� ������) #### ��� (�� ����)

select ename, nvl(to_char(mgr, ''), 'ceo') from emp where mgr is null; -- emp ���̺��� mgr ���� null�� ����� ������� ���, mgr ���� null��  ceo�� ��ü�� ���
select mgr, nvl(to_char(nvl(mgr,9999)), 'ceo') from emp;

select ename, hiredate from emp where hiredate = to_date('19810220', 'YYYYMMDD'); -- ����Ŭ�� �⵵�� �� �ڸ��� ���������, 1891��, 1981��, 2081���� ������ �� ���� �⵵�� �� �ڸ��� �ۼ��� ��
select trunc((sysdate - to_date('2011-01-01', 'YYYY/MM/DD')) / 365) from dual; -- (���� ��¥ - 2011�� 1�� 1��) / 365 : �ټӳ�� ���ϱ�


-- D: ������ ���ڷ� ��ȯ. 1 : �Ͽ���, 2 : ������, ....
select to_char(to_date('2014-01-02'),'D') from dual;

select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'), systimestamp from dual;
select to_char(systimestamp, 'YYYY-MM-DD HH24:MI:SS'), systimestamp from dual;
--select to_date(systimestamp, 'YYYY-MM-DD HH24:MI.SS.FF3') from dual; -- ����

-- next_day(���س�¥, �ش�Ǵ� ����) : ���س�¥�� �������� ���ƿ��� ������ ��¥ ���
select next_day(sysdate, '�����') from dual; -- 24/07/06 ���
select next_day(sysdate, '��') from dual;
select next_day(sysdate, 7) from dual; -- 24/07/06 ���
select next_day(sysdate-8, '�����') from dual; -- 24/06/29 ���
--select sysdate-8 from dual;

-- to_number (������, '�������') : �����͸� ���� �ڷ������� ��ȯ 
-- ** ��������� 9�� ���� �� ����.
-- ���ڰ����� ,�� ���� ������ '999,999' ������ ������ �־ ,(�޸�)�� ��µ��� �ʴ´�.
-- �ݵ�� �������� �ڸ����� ��������� �ڸ������� �۾ƾ߸� �Ѵ�. ex) to_number('10,000.123', '999,999.9) (X)
-- ������Ŀ� ������ �ڸ����� ���� �����Ͱ� ��µȴ�. ex) to_number('10,000', '999,999')�� to_number('10,000', '999,999,999')�� �ڸ����� ���̰� ����
select to_number('1234567'), to_number('10,000.123', '999,999.999') from dual; -- 1234567 ���ڿ� -> ���������� ��ȯ��. 
select to_number('10,000', '999,999'), to_number('20,000', '999,999') from dual;
select to_number('10,000', '999,999') + to_number('20,000', '999,999') as sum from dual;
select to_number('10,000', '999,999'), to_number('20,000', '999,999') from dual;

-- ������� ���̺��� ������ �μ���ȣ�� ���, �μ���ȣ�� 10�̸� ACCOUNTING, 20�̸� RESEARCH �� �ܴ� ETC�� ��µǴµ� �� �÷��� �̸��� DNAME���� �����ؼ� ���
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
) AS "�λ�� �޿�"
FROM EMP;

SELECT ENAME, SAL, 
CASE
    WHEN SAL >= 5000 THEN 'TOP'
	WHEN SAL >= 1500 THEN 'MID'
	WHEN SAL >= 3000 THEN 'HI'
	ELSE 'LOW'
END AS ���
FROM EMP;
