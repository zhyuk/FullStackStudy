-- ���̺��� ������ Ȯ���ϴ� ��ɾ�
DESC EMP;

commit; -- �����͸� Ȯ��ó���� DB�� �����͸� �����Ѵ�. (���Է� �� �ӽ����� ��)
rollback; -- ��ü �ǵ�����

select * from dept01; -- dept01 ���̺� ����
select * from emp01; -- emp01 ���̺� ����

create table DEPT01(deptno number(2,0), dname varchar2(14), loc varchar2(13)); -- number(�� �ڸ���, �Ҽ��� �ڸ���)
insert into dept01 (deptno, dname, loc) values (10, 'ACCOUNTING', 'NEW YORK'); -- dept01���̺��� ��� �÷��� ������ ���� (��������)
insert into dept01 (deptno, dname) values (10, 'ACCOUNTING'); -- dept01 ���̺��� deptno, dname �÷����� ������ ����
insert into dept01 values(20, 'RESEARCH', 'DALLAS'); -- detp01 ���̺��� ��� �÷��� ������ ���� (��������)

insert into dept01 (deptno, dname) values (30, 'SALES');
insert into dept01 values (40, 'OPERATIONS', null);
insert into dept01 (deptno, loc) values (50, 'CHICAGO');

-- UPDATE
update dept01 set deptno = 90, dname = 'TEST' where deptno = 10 and loc is null; -- loc�� ���� null�� : loc is null

-- emp ���̺��� ������ �����͸� ������ emp01 ���̺� ����
create table emp01 as select * from emp;

-- emp01 ���̺��� ��� ����� �μ���ȣ�� 30������ ����
update emp01 set deptno = 30;
-- emp01 ���̺��� ��� ����� �޿��� 10% �λ�
update emp01 set sal = sal + sal * 0.1;
update emp01 set sal = sal * 1.1;
-- emp01 ���̺��� �Ի����� ���÷� ����
update emp01 set hiredate = sysdate;

-- emp01 ���̺��� �μ���ȣ�� 10���� ����� �μ���ȣ�� 30������ ����
update emp01 set deptno = 30 where deptno = 10; 
-- emp01 ���̺��� �޿��� 3000 �̻��� ����� �޿��� 10% �λ�
update emp01 set sal = sal * 1.1 where sal >= 3000;
-- emp01 ���̺��� 1982�⿡ �Ի��� ����� �Ի����� ���÷� ����

-- ���� ����ǥ�� �⵵ YYYY�� �ۼ��ϴ� �� ����.
update emp01 set hiredate = sysdate where hiredate between '1982/01/01' and '1982/12/31';
update emp01 set hiredate = sysdate where substr(hiredate, 1, 2) = '82';

-- emp01 ���̺��� JAMES�� �μ���ȣ�� 20, ��å�� MANAGER�� ����
update emp01 set deptno = 20, job = 'MANAGER' where ename = 'JAMES';
-- emp01 ���̺��� 82�⿡ �Ի��� ����� �Ի����� 1991�� 5�� 6�� 17�� 56������ ����
update emp01 set hiredate = to_date('1991/05/06 05:56:04', 'YYYY/MM/DD HH12:MI:SS') where hiredate between '1982/01/01' and '1982/12/31';
update emp01 set hiredate = to_date('1991/05/06 17:56:04', 'YYYY/MM/DD HH24:MI:SS') where substr(hiredate, 1, 2) = 80;

-- DELETE
-- emp01 ���̺� ����
delete from emp01;
-- emp01 ���̺��� �μ���ȣ�� 30�� ���� ����
delete from emp01 where deptno = 30;
-- emp01 ���̺��� �Ի����� 1985�� 01�� 01�� �̻��� ���� ����
delete from emp01 where hiredate >= '1985/01/01';

insert into dept01 values (11, '�渮��', '����');
insert into dept01 values (12, '�λ��', '��õ');
insert into dept01 values (13, '������', '����');
insert into dept01 values (14, '�����', '����');
insert into dept01 values (15, '���������', '�Ȼ�'); -- VARCHAR2(14BYTE) �̹Ƿ� 5���ڴ� �Ұ���.
insert into emp01 (deptno, ename, empno, job, sal, comm, hiredate) values (40, 'ȫ�浿', 9999, 'MANAGER', 800, 100, '2022-07-01');
insert into emp01 (deptno, ename, empno, job, sal, comm, hiredate) values (40, '��浿', 1111, 'CEO', 5000, 2500, '1980-01-01');
insert into emp01 (deptno, ename, empno, job) values (30, '������', 5555, 'WORKER');

-- emp01 ���̺��� ������ �����ϱ�
-- deptno�� 10�� �������� deptno�� ���� 11�� �����ϱ�
update emp01 set deptno = 11 where deptno = 10;
-- deptno�� 20�� �������� deptno�� ���� 12�� �����ϱ�
update emp01 set deptno = 12 where deptno = 20;
-- deptno�� 30�� �������� deptno�� ���� 13�� �����ϱ�
update emp01 set deptno = 13 where deptno = 30;
-- deptno�� 40�� �������� deptno�� ���� 14�� �����ϱ�
update emp01 set deptno = 14 where deptno = 40;

-- ��å�� CLERK�� ����� ��å�� �������� ����
update emp01 set job = '����' where job = 'CLERK';
-- ��å�� SALESMAN�� ����� ��å�� ����������� ����
update emp01 set job = '������' where job = 'SALESMAN'; -- VARCHAR2 (9 BYTE)�� 4���� �Ұ�
-- ��å�� MANAGER�� ����� ��å�� ���������� ����
update emp01 set job = '������' where job = 'MANAGER';
-- ��å�� ANALYST�� ����� ��å�� �м������� ����
update emp01 set job = '�м���' where job = 'ANALYST';
-- ��å�� PRESIDENT�� ����� ��å�� ȸ������ ����
update emp01 set job = 'ȸ��' where job = 'PRESIDENT';
-- ��å�� CEO�� ����� ��å�� �������� ����
update emp01 set job = '����' where job = 'CEO';
-- ��å�� WORKER�� ����� ��å�� ���������� ����
update emp01 set job = '������' where job = 'WORKER';


create table employ (empid number(4,0), name varchar2(10), job varchar2(10), deptid number(3,0), salary number(4,0), bonus number(3,0), mgrid number(4,0), hiredate date);
select * from employ;
drop table employ purge;

--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (6200, '��ö��', '�̻�', 200, 5000, '', '', '1997/12/17');
--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (6311, '����ġ', '����', 100, 3500, '', 6200, '1998/12/17');
--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (7489, '�۾���', '������', 400, 1850, 200, 6321, '1999/02/27');
--insert into employ (empid, name, job, deptid, salary, bonus, mgrid, hiredate) values (7522, '����Ŭ', '������', 400, 1850, 300, 6321, '1998/02/28');

drop table emp01 purge; -- purge : �ӽ� ����ҵ� ��� ����.
drop table dept01 purge;


-- �����ȣ, �����, �޿� 3���� Į������ ������ EMP01 ���̺� ����
create table emp01(empno number(4), ename varchar2(10char), sal number(7,2));

-- dept ���̺�� ������ ������ ���̺��� dept01�� ����
create table dept01(deptno number(2), dname varchar2(14), loc varchar2(13));
select * from dept01;
desc dept01; -- dept01 ���̺��� ���� Ȯ���ϴ� ��ɾ�

-- ���̺��� ���� ���� :  �÷� �߰�
-- emp01 ���̺� ���� Ÿ��(20)�� ����(job)Į�� �߰�
alter table emp01 add (job varchar2(20));
-- dept01 ���̺� �������� �÷�(credate)�� ��¥������ �߰�
alter table dept01 add (credate date);

-- ���̺��� ���� ���� :  �÷� ����
alter table emp01 modify (job varchar2(30));

drop table emp01 purge;

-- emp ���̺��� �����ؼ� emp01 ���̺� ����
create table emp01 as select * from emp; 

-- job �÷��� �����Ͱ� �ִ��� ���������� ũ��� �ø� �� �ִ�.
alter table emp01 modify (job varchar2(30));
alter table emp01 modify (job varchar2(10));
alter table emp01 modify (job varchar2(7)); -- 9 BYTE�� ũ�⸦ ���� �����͵� �ֱ� ������ ���� �Ұ�

-- emp01 ���̺� deptno �÷��� ũ�⸦ ���� 4�ڸ��� ����
alter table emp01 modify (deptno number(4)); -- �������
alter table emp01 modify (deptno number(2)); -- ����. // ���� �ڷ����� �� �� ũ�⸦ �����ϸ� �� ũ�⺸�� �۰� ���� �� ����.

alter table emp01 modify (comm varchar2(10)); -- ����. // comm �÷��� �����Ͱ� �����ϱ� ������ �ڷ����� ������ �� ����.

-- ������ ����
update emp01 set comm = '';
commit;

alter table emp01 modify (comm varchar2(10)); -- �������

-- dept01 ���̺��� ������(loc) Į���� ũ�⸦ 20���� ����
alter table dept01 modify (loc varchar2(20));

-- ���̺��� ���� ���� :  �÷� �̸� ����
alter table emp01 rename column comm to bonus;
alter table emp01 rename column sal to salary;

-- ���̺��� ���� ���� :  �÷� ����
alter table emp01 drop column job; -- �ϳ��� �÷����� �����ϴ� ����
alter table emp01 drop (job); -- �� �� �̻��� �÷��� �����ϴ� ����
alter table emp01 drop (mgr, salary);

-- dept01 ���̺��� credate �÷� ����
alter table dept01 drop (credate);

create table emp02 as select * from emp  where deptno = 30;
--emp ���̺��� empno, ename, deptno �÷��� ��ȸ�Ͽ� emp03 ���̺� ����
create table emp03 as select empno, ename, deptno from emp;

-- emp ���̺��� empno, ename, deptno �÷� ��ȸ�Ͽ� emp04 ���̺��� ����µ� �÷����� ���, �̸�, �μ���ȣ�� �������� ����
create table emp04 as select empno ���, ename �̸�, deptno �μ���ȣ from emp;

-- emp ���̺��� ������ �����ؿ��� ���  : where���� ������ false�� ��ȯ�ϴ� ������ �ɾ��ش�.
create table emp05 as select * from emp where 1 = 0;

-- emp04 ���̺��� ���̺���� emp07�� ����
rename emp04 to emp07;
--alter emp04 rename to emp07;

drop table emp02; -- �ǹ����� �߸� �������� ���, �����뿡�� ������ �� �ֵ��� purge ��ɾ�� ������� �ʴ� ���� ����.
drop table emp03;
drop table emp05;
drop table emp07;

delete from emp01;
rollback;

-- ���̺��� ��� ROW ����
truncate table emp01;

drop table emp01;
drop table dept01;

-- ������ ���Ἲ
create table emp01 (empno number(4), ename varchar2(10), job varchar2(9), deptno number(4));
select * from emp01;

insert into emp01 values(null, '', 'SALESMAN', 30);
insert into emp01 values(null, 'TOM', 'SALESMAN', 30);

-- ���� ���� : not null
create table emp02 (empno number(4) not null, ename varchar2(10) not null, job varchar2(9), deptno number(4)); -- empno, ename �÷��� null �Ұ���

insert into emp02 values(null, null, 'SALESMAN', 10); -- ����/ "test ���� �� emp02��� ���̺� �� empno �÷��� null�� ���� �� ����." empno �÷��� �� �־ ename �÷� ����
insert into emp02 values(1401, 'TOM', 'SALESMAN', 10); -- �������

-- ���� ���� : unique
create table emp03 (empid varchar2(20) unique not null, empno number(4) unique, ename varchar2(10) not null, job varchar2(9), deptno number(4));

insert into emp03 values('emp03', 7499, 'ALLEN', 'SALESMAN', 30); -- �������
insert into emp03 values('emp02', 7499, 'JONES', 'MANAGER', 20); -- ����/ ALLEN �÷��� ������ ��� -> unique ���� ���� ������
insert into emp03 values('emp05', null, 'JONES', 'SALESMAN', 10); -- �������

-- ���� ���� : primary key
create table emp04 (empid varchar2(20) primary key, empno number(4) unique, ename varchar2(10) not null, job varchar2(9), deptno number(4));

insert into emp04 values('emp03', 7499, 'ALLEN', 'SALESMAN', 30); -- �������
insert into emp04 values('emp03', 7777, 'JONES', 'MANAGER', 20); -- ����/ emp03 �ߺ� -> primary key ���� ���� ������
insert into emp04 values('emp05', null, 'JONES', 'SALESMAN', 10); -- �������