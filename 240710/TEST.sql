-- ��� �޿����� �� ���� �޿��� �޴� ����� �˻�, ���� �޴� ��� ������ ���
select * from emp where sal > (select avg(sal) from emp) order by sal desc;

-- �μ���ȣ�� 10���� ��� �߿��� �ִ� �޿��� �޴� ����� ��� ��ȣ�� �����
select empno, ename from emp where sal = (select max(sal) from emp where deptno = 10) and deptno = 10;

-- �μ���ȣ�� �Ҵ�� ������ ������ ����������
select * from emp where deptno in(select deptno from dept);

-- ������ �Ҵ���� ���� �μ��� �μ���ȣ, �μ���, ��ġ ��� 
select *  from dept where deptno not in(select distinct deptno from emp where deptno is not null);
select * from dept where not deptno in(select distinct deptno from emp where deptno is not null);

-- �޿��� 3000 �̻� �޴� ����� ������ �μ����� ���ϴ� ������� �����, �޿�, �μ���ȣ
select ename, sal, deptno from emp where deptno in (select deptno from emp where sal >= 3000);

-- �� �μ��� �ּ� ������ �޴� ������ ������ �޿��� �޴� ����� �����, �޿�, �μ���ȣ ���
select ename, sal, deptno from emp where sal in (select min(sal) from emp group by deptno);

-- ALL ������
select * from emp where sal < all (1000,2000,3000) order by sal; -- �÷��� < all () : ���� ���� ���� 1000 ��ȯ => 1000���� ���� ������ ���� ����� ���� ���
select * from emp where sal > all (1000,2000,3000) order by sal; -- �÷��� > all () : ���� ū ���� 3000 ��ȯ => 3000���� ū ������ ���� ����� ���� ���

select ename, sal from emp where sal > all(select sal from emp where deptno = 30); -- �������� : 2850 ��ȯ -> ������ 2850 �̻��� ����� �̸�, ���� ���
-- select sal from emp where deptno = 30; 

-- �μ���ȣ�� 30���� ������� �޿� �� ���� ���� ������ ���� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ ���
select ename, sal, deptno from emp where sal < all(select sal from emp where deptno = 30);

-- �μ��� ��� ���� �� �ִ� ��� �������� �� ū ������ �޴� ����� ���, �̸�, ��å, ���� ���
select empno, ename, job, sal from emp where sal > all(select avg(sal) from emp group by deptno); -- 2916.6666.. ���� ū ������ ����
--select avg(sal) from emp group by deptno;

-- ANY ������
select * from emp where sal < any(1000,2000,3000) order by sal; -- �÷��� < any () : ���� ū �� ��ȯ ->  3000���� ���� ������ ���� ����� ���� ���
select * from emp where sal > any(1000,2000,3000) order by sal; -- �÷��� > any () : ���� ���� �� ��ȯ ->  1000���� ū ������ ���� ����� ���� ���

-- SALES �μ��� �ٹ��ϴ� ������� �ּҿ������� ū ������ �޴� ��� �� SALES �μ��� ������ ����� ���, �̸�, �μ���ȣ, ���� ���
select empno, ename, deptno, sal from emp where deptno != (select deptno from dept where dname = 'SALES') and sal > any (select sal from emp where deptno = (select deptno from dept where dname = 'SALES'));

-- CLERK ��å�� �ƴϸ鼭 CLERK�� �޴� �ְ� �޿����� �� ���� �޿��� �޴� ����� ���
select * from emp where job != 'CLERK' and sal < any(select sal from emp where job = 'CLERK');
select sal from emp where job = 'CLERK';
-- CLERK �繫��, ���

drop table dept01;

-- emp ���̺� ������ ������ emp04, emp05 ���̺� ����
create table emp04 as select * from emp where 1 = 0;
create table emp05 as select * from emp where 1 = 0;

-- INSERT ALL INTO : ���� ���� ���̺� ���� ���� �����͸� �����ϴ� ��ɹ�
insert all into emp04 values (empno, ename, job, mgr, hiredate, sal, comm, deptno) select * from emp; -- emp ���̺��� ������ �״�� emp04 ���̺� ����
select * from emp;
rollback;

insert all into emp04 (empno, ename, deptno) values (empno, ename, deptno) select empno, ename, deptno from emp;
/* select empno, ename, deptno from emp; -- 7369	SMITH	20 / 7499	ALLEN	30 / .... �� �پ� �����´�. 
    -> �� �پ� ������ �����͸� emp04 values (empno, ename, deptno) ������� ����
    -> emp04 ���̺� ������
*/
--insert all into emp04 (empno, ename, deptno) values (empno, ename, deptno) select * from emp; -- ������. ���������� ��� ������ ������ ���������� empno, ename, deptno �����͸� ����Ѵٴ� �ǹ�
rollback;

insert all into emp04 into emp05 values (empno, ename, job, mgr, hiredate, sal,  comm, deptno) select * from emp; --> emp04, emp05, emp ���̺� ��� ������ �Ȱ��Ƽ� values �ϳ��� ��� ����
/*  select * from emp : 7369	SMITH	20 / 7499	ALLEN	30 / .... => emp ���̺��� ��� ���� ������.
    values (empno, ename, job, mgr, hiredate, comm, deptno) : emp ���̺��� empno, ename, job, mgr, hiredate, comm, deptno �÷��� ���� �־���
    emp04, emp05 ���̺� ����
*/
rollback;

-- emp04 ���̺��� empno, ename, job �÷���, emp05 ���̺��� empno, ename, mgr, job �÷��� �����
alter table emp04 drop (mgr, hiredate, sal, comm, deptno);
alter table emp05 drop (hiredate, sal, comm, deptno);

insert all into emp04 values(empno, ename, job) into emp05 values(empno, ename, job, mgr) select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
-- ����. emp05 values(empno, ename, mgr, job) -> �÷��� ������ �� �ִ� ���� �� �÷��� ������� ���� �ִ� ���� ������
rollback;

insert all into emp04 values (empno, ename, job) into emp05 values (empno, ename, job, empno) select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
-- �������. empno�� mgr�� �ڷ����� ������ 4�ڸ��� �����ϱ� ������ ����
rollback;

drop table emp04;
drop table emp05;

-- emp ���̺��� empno, ename, sal �÷��� ������ ������ emp01 ���̺� ����
create table emp01 as select empno, ename, sal from emp where 1 = 0;
-- emp ���̺��� empno, ename �÷��� ������ �����͸� ������ emp02 ���̺� ����
create table emp02 as select empno, ename from emp;

-- emp���̺��� �μ���ȣ�� 20�� �̻��� ������� �����͸� �����ͼ� emp01 ���̺�� emp02 ���̺� ������ ��������
insert all into emp01 values (empno, ename, sal) into emp02 values (empno, ename) select * from emp where deptno >= 20;
rollback;

-- emp02 ���̺� comm �÷� �߰�
alter table emp02 add (comm number(7,2));

-- emp ���̺��� ��ձ޿����� �� ���� ����� ������ �����ͼ� emp01 ���̺��� ���, �̸�, ������ �ְ�, emp02 ���̺��� ���, �̸��� ��������.
insert all into emp01 values (empno, ename, sal) into emp02 (empno, ename) values (empno, ename) select * from emp where sal > (select avg(sal) from emp);
insert all into emp01 values (empno, ename, sal) into emp02 values (empno, ename, '') select * from emp where sal > (select avg(sal) from emp);
--select * from emp where sal > (select avg(sal) from emp); -- ��������
rollback;

drop table emp01;
drop table emp02;

-- dept ���̺��� ������ �����ؼ� dept01 ���̺� ����
create table dept01 as select * from dept where 1 = 0;

insert all into dept01 values (deptno, dname, loc) select * from dept;
commit;

-- dept ���̺��� 40�� �μ��� ��ġ�� �����ͼ� dept01 ���̺� ���� 10�� �μ��� �ش��ϴ� ��ġ�� ���� ����
--update ���̺�� set �÷��� = �� where ���ǹ�
update dept01 set loc = (select loc from dept where deptno = 40) where deptno = 10;
--select loc from dept where deptno = 40 : ��������

-- �����÷� ��������
-- emp ���̺� �� empno �÷�, enames �÷��� ���� 7839, 'KING'�� �������� ��
select * from emp where (empno, ename) = (select 7839, 'KING' from dual); -- emp ���̺� �� empno�� ���� 7839�� ���� ���� ��� -> ���� �÷� ���� ��
select * from emp where (empno, ename) in (select empno, ename from emp where deptno = 20); -- -> ���� �÷� ���� ��

-- dept01 ���̺��� �μ���ȣ�� 20�� �������� �μ���� ��Ҹ� dept ���̺��� �μ���ȣ�� 30�� �������� �μ���� ��ҷ� ����
update dept01 set(dname,loc) = (select dname, loc from dept where deptno = 30) where deptno = 20;
-- ���� ������ :     20  RESEARCH    DALLAS
-- ���� ������ :     20  SALES       CHICAGO
rollback;

create table emp01 as select * from emp;

alter table emp01 add (dnm varchar2(20));

-- dept ���̺��� �ش� �μ����� �����ͼ� emp01 ���̺� ��������
update emp01 e set dnm = (select dname from dept d where d.deptno = e.deptno);
-- ���̺��� ��Ī���� �� 'as' ��� ����
commit;

update emp01 set (empno, ename) = (select 1111, 'ù°' from dual); -- emp01 ���̺� ��� ���� empno, ename �÷��� 1111, 'ù°'�� ����
rollback;

-- dept ���̺� �μ����� SALES�� ���� �μ���ȣ�� �����ͼ� �� ����  emp01 ���̺��� �μ���ȣ�� ������ ���� ���� --> �μ���ȣ�� 30�� �� ��� ����
delete from emp01 where deptno = (select deptno from dept where dname = 'SALES'); 
delete from emp01 where deptno != (select deptno from dept where dname = 'SALES'); --> �μ���ȣ�� 30�� �ƴ� �� ��� ����
delete from emp01 where deptno in (select deptno from dept where dname != 'SALES'); --> �μ���ȣ�� 30�� �ƴ� �μ���ȣ ��� => 10, 20, 40 ��� 
rollback;

drop table emp01;
drop table dept01;

-- dept ���̺� deptno -> primary key, dname -> not null
-- alter table ���̺�� add constraint �������Ǹ� ������������ (�÷���);
-- alter table ���̺�� modify (�÷��� constraint �������Ǹ� ������������);
alter table dept add constraint dept_deptno_pk primary key(deptno);
alter table dept modify (dname constraint dept_dname_nn not null);

-- emp ���̺� empno -> primary key, deptno -> r 
alter table emp add constraint emp_empno_pk primary key(empno);
--alter table emp modify (empno constraint emp_empno_pk primary key);
alter table emp add constraint emp_deptno_fk foreign key(deptno) REFERENCES dept(deptno);

drop table dept;
drop table emp;

create table emp as select * from scott.emp;
create table dept as select * from scott.dept;

create table emp01 as select * from emp; -- ���������� �Բ� ������� ����.
create table dept01 as select * from dept; -- ���������� �Բ� ������� ����.
drop table dept01;
drop table emp01;

-- �������� ����
alter table emp drop constraint emp_deptno_fk;
alter table emp drop constraint emp_empno_pk;
alter table dept drop constraint dept_deptno_pk;
alter table dept drop constraint dept_dname_nn;

-- �������� : Equi Join
-- from A ���̺�, B ���̺��� ��� A ���̺��� �����ͺ��� ��µǰ� �� �ڿ� B ���̺��� �������� �ٴ´�.
select * from emp,dept where emp.deptno = dept.deptno;
-- �������� : CATASIAN PRODUCT JOIN
select * from dept, emp;
-- �������� : ANSI CROSS JOIN
select * from dept cross join emp;

-- �������� (Inner Join)
-- ���̺�Ī�� ��µ��� ���� -> e.ename�� ��µ� �� ename���� ��µ�
select e.ename, d.dname, e.deptno as edno, d.deptno as ddno from emp e, dept d where e.deptno = d.deptno order by ddno;
-- �������� (ANSI INNER JOIN)
-- from A inner join B on �������� where where������
-- ANSI INNER JOIN�� ��� INNER ���� ����
-- �ؼ����� : FROM�� - ON�� - WHERE�� - SELECT�� - ORDER BY�� == SELECT������ ������ EDNO ��Ī�� ORDER BY�������� ��밡��
select e.ename, d.dname, e.deptno as edno, d.deptno as ddno from emp e inner join dept d on e.deptno = d.deptno where e.deptno = 20 order by ddno;
--select e.ename, d.dname, e.deptno as edno, d.deptno as ddno from emp e [inner] join dept d on e.deptno = d.deptno where e.deptno = 20 order by ddno;

-- emp ���̺�� departments ���̺��� �̳������Ͽ� emp ���̺��� ���,�̸�,�μ���ȣ�� departments ���̺��� �μ���ȣ, �μ���, �����μ���ȣ�� ��µǵ���
select e.empno, e.ename, e.deptno, d.department_id, d.department_name, d.manager_id from emp e inner join departments d on e.deptno = d.department_id; -- ANSI INNER JOIN
select e.empno, e.ename, e.deptno, d.department_id, d.department_name, d.manager_id from emp e, departments d where e.deptno = d.department_id ; -- INNER JOIN

-- emp ���̺��� ��� �÷�, departments ���̺����� �μ���� �����μ���ȣ�� ���
select e.*, d.department_name, d.manager_id from emp e inner join departments d on e.deptno = d.department_id;

-- Ŀ�̼��� �޴� ��� ����� �̸�, �μ���ȣ, �μ���, ��ġ ���
-- Ŀ�̼��� �޴� == 0�� �ƴϰ�, null�� �ƴ�
select e.ename, e.deptno, d.dname, d.loc from emp e inner join dept d on e.deptno = d.deptno where nvl(e.comm,0)> 0; -- ANSI INNER JOIN
select e.ename, e.deptno, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno and nvl(e.comm,0) > 0; -- INNER JOIN
-- �÷����� �ߺ��� ���� �ʼ��� ��Ī ����� �ʿ� X 

-- �̸��� a�� ���� ��� ����� �̸��� �μ��� ǥ��
select e.ename, d.dname from emp e, dept d where e.deptno = d.deptno and e.ename like('%A%'); -- INNER JOIN
select e.ename, d.dname from emp e inner join dept d on e.deptno = d.deptno where e.ename like('%A%'); -- ANSI INNER JOIN

-- ���������� select���� �� �� �ֱ� ������ �ش� ������ε� ����
select ename, (select dname from dept where dept.deptno = emp.deptno)dname from emp where ename like('%A%');