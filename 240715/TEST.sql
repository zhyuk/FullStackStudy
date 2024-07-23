-- �ǻ��÷� : rownum
select * from customers where rownum <= 1000 and cust_gender = 'M'; -- rownum�� 1000 ���� �׸��� cust_gender �÷��� �����Ͱ� M�� �����͸� ���
--select * from customers where rownum > 1000 and cust_gender = 'M'; -- ��� X, �ܼ������� �� rownum�� ũ�� ��� �Ұ�.

-- �������� ��
select rownum rn, c.* from (select * from customers where cust_gender = 'M') c where rownum <= 500;
select * from (select rownum rn,sc.* from customers sc where cust_gender = 'M')c where rn >= 50; // �������� ������ rownum�� ���� �����͸� ����� �ڿ� ���������� ���;߸� 'ũ��, ũ�ų� ����'�� ���ǵ� �� �� �ִ�.


select * from (select rownum rn, c2.* from customers c2 where cust_gender = 'M') where rn between 10 and 13;
--select rownum rn, c2.* from customers c2 where cust_gender = 'M'�� ���� rownum�� ���� rn �÷��� ��µȴ�.
select * from(select rownum rn, c2.* from customers c2 where cust_gender = 'M' order by cust_id desc) where rn >= 50 and rn <= 100; -- ROWNUM�� 50~100 ������ ������ ���
select rownum rn, c2.* from customers c2 where cust_gender = 'M' order by cust_id desc; -- order by���� ����� ���, ���ǿ� ���� rownum�� ���̰� �ȴ�.
select * from(select rownum rn, c1.* from (select c2.* from customers c2 where cust_gender = 'M' order by cust_id desc)c1) where rn between 10 and 20; -- ���� �̿� ���� ���������� ���� �� rownum ����


-- MERGE��ɹ� 
-- EMP ���̺� VARCHAR2(20)�ڷ��� DNAME �÷� ����
alter table emp add (dname varchar2(20));
-- on (emp.deptno = dept.deptno) : emp ���̺��� deptno �÷��� dept ���̺��� deptno �÷��� �����Ͱ� �����ϴ��� Ȯ�� -> ��ġ �� when matched then ����, ����ġ �� when not matched then ����
merge into emp using dept on (emp.deptno = dept.deptno) when matched then update set emp.dname = dept.dname delete where emp.mgr is null when not matched then insert (empno, ename) values (9999, 'TEST');
rollback; -- insert, update, delete�� DML�̶� ����

create table emp01 as select * from emp;
merge into emp01 a using (select empno, sal, job from emp where deptno = 10) b on (a.empno = b.empno) when matched then update set a.sal = b.sal + b.sal * 0.01 when not matched then insert (a.empno, sal, job) values (b.empno, b.sal, b.job);
select empno, sal, job from emp where deptno = 10; -- deptno�� 10�� empno, sal, job ������ ���
rollback;

merge into emp01 a using (select empno, sal, job from emp where deptno = 20)b on (a.empno = b.empno) when not matched then insert (a.empno, sal, job) values (b.empno, b.sal, b.job) when matched then update set a.sal = b.sal + b.sal * 0.01;
rollback;

merge into emp01 a using (select empno, sal, job from emp where ename = 'KING' and deptno = 10) b on (a.empno = b.empno) when matched then update set a.sal = 8000 when not matched then insert (a.empno,sal, job) values (b.empno, b.sal, b.job);
rollback;

-- delte���� ���ǿ� �ɸ��͸� ����ȴ�.
merge into emp01 a using (select empno, sal, job from emp where ename = 'KING' and deptno = 10) b on (a.empno = b.empno) when matched then update set a.sal = 8000 delete where a.deptno = 10 when not matched then insert (a.empno,sal, job) values (b.empno, b.sal, b.job);
rollback;

merge into (select * from emp01 where deptno = 10)A using (select empno, sal, job from emp)B on (A.empno = B.empno) when matched then update set A.sal = 8000 when not matched then insert(A.empno, A.sal, A.job) values (B.empno, B.sal, B.job);
-- select * from emp01 where deptno = 10; -- 7782, 7839, 7934
-- select empno, sal, job from emp; -- 7369, 7499, 7521, 7566, 7654, 7698, 7782, 7839, 7844, 7900, 7902, 7934
-- 7782, 7839, 7934 ���� sal = 8000 �� �� 9���� ���� insert ��
rollback;

-- ���տ�����
create table goods_kor(seq number primary key, country varchar2(10), goods varchar2(80) not null);
create sequence kor_seq nocache;

insert into goods_kor(seq, country, goods) values (1, '�ѱ�', '�������� ������');
insert into goods_kor values(2, '�ѱ�', '�ڵ���');
insert into goods_kor values(3, '�ѱ�', '��������ȸ��');
insert into goods_kor values(4, '�ѱ�', '����');
insert into goods_kor values(5, '�ѱ�', 'LCD');
insert into goods_kor values(6, '�ѱ�', '�ڵ�����ǰ');
insert into goods_kor values(7, '�ѱ�', '�޴���ȭ');

create table goods_jap(seq number primary key, country varchar2(10), goods varchar2(80) not null);
create sequence jap_seq nocache;

insert into goods_jap values(1, '�Ϻ�', '�ڵ���');
insert into goods_jap values(2, '�Ϻ�', '�ڵ�����ǰ');
insert into goods_jap values(3, '�Ϻ�', 'ȭ����');
insert into goods_jap values(4, '�Ϻ�', '�Ǽ����');
insert into goods_jap values(5, '�Ϻ�', '���̿���');
insert into goods_jap values(6, '�Ϻ�', 'Ʈ��������');
insert into goods_jap values(7, '�Ϻ�', '�ݵ�ü������');

commit;

-- ������ UNION, UNION ALL
SELECT GOODS FROM GOODS_KOR UNION SELECT GOODS FROM GOODS_JAP; -- ������ �����ʾ� ����-�ѱ� ������ ����������.
SELECT GOODS FROM GOODS_KOR UNION ALL SELECT GOODS FROM GOODS_JAP; -- A ���̺��� ��� �÷� ��� �� B ���̺��� ��� �÷� ���.
SELECT GOODS FROM GOODS_JAP UNION SELECT GOODS FROM GOODS_KOR; -- A,B ���̺��� ��ġ�� �ٸ����� �ߺ��� �����ϰ� �������� �ʾ� �ڵ����� ���������Ǳ� ������ ������ �� ���
-- SELECT COUNTRY, GOODS FROM GOODS_KOR UNION SELECT GOODS FROM GOODS_JAP; -- ����. �÷��� ������ �÷��� �ڷ����� ��ġ�� �����ؾ߸� ���� ����
SELECT COUNTRY, GOODS FROM GOODS_KOR UNION SELECT COUNTRY, GOODS FROM GOODS_JAP; 
-- SELECT GOODS FROM GOODS_KOR UNION SELECT DNAME FROM DEPT ORDER BY GOODS; -- �÷��� ����, �÷��� �ڷ����� ����� ������ ��µ�.
-- SELECT GOODS FROM GOODS_KOR UNION SELECT DNAME FROM DEPT ORDER BY DNAME; -- ����. ORDERT BY������ ���� Ȥ�� ���� �����(���� �����) ���̺� �ν��� �� �ֱ⶧��

-- ������ INTERSECT
SELECT GOODS FROM GOODS_KOR INTERSECT SELECT GOODS FROM GOODS_JAP;

UPDATE GOODS_KOR SET GOODS='�ڵ���' WHERE SEQ = 3;
UPDATE GOODS_KOR SET GOODS='�ڵ�����ǰ' WHERE SEQ = 4;
COMMIT;

SELECT GOODS FROM GOODS_KOR INTERSECT SELECT GOODS FROM GOODS_JAP;
SELECT GOODS FROM GOODS_KOR UNION SELECT GOODS FROM GOODS_JAP;
SELECT GOODS FROM GOODS_KOR UNION ALL SELECT GOODS FROM GOODS_JAP;

-- ������ MINUS
SELECT GOODS FROM GOODS_KOR;
SELECT GOODS FROM GOODS_JAP;
SELECT GOODS FROM GOODS_KOR MINUS SELECT GOODS FROM GOODS_JAP; -- GOODS_KOR�� GOODS_JAP�� �ߺ����� ���� ������ ���

rollback; -- ����Ŭ ������ �۾��� ���� �ѹ� ����. ������, �ڹٿ����� ������ �ڵ�Ŀ�Ե�.