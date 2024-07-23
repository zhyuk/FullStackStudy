-- ���� ���� : SELF JOIN

-- ��� �̸� �� ��� ��ȣ�� �ش� ������ �̸� �� ������ ��ȣ�� �Բ� ǥ��, �� �Ӹ����� ���� ����̸�, �����ȣ, ������ �̸�, ������ ��ȣ���� ǥ��
select e.ename ����̸�, e.empno �����ȣ, d.ename as "������ �̸�", d.deptno as "������ ��ȣ" from emp e, emp d where e.mgr = d.empno;
select e.ename ����̸�, e.empno �����ȣ, d.ename as "������ �̸�", d.deptno as "������ ��ȣ" from emp e inner join emp d on e.mgr = d.empno;

-- Ư�� ����� ����ϴ� �Ŵ��� ����� �̸��� ����Ѵ�. WORK�� MANAGER�� ��Ī�� �ο��Ѵ�.
select work.ename || '�� �Ŵ����� ' || manager.ename || '�Դϴ�.' MANAGER from emp work,emp manager  where work.mgr = manager.empno; -- INHNER JOIN
select work.ename || '�� �Ŵ����� ' || manager.ename || '�Դϴ�.' MANAGER from emp work inner join emp manager  on work.mgr = manager.empno; -- ANSI INNER JOIN

create table test1(id number(2) constraint test1_id_pk primary key, name varchar2(10), age number(2));
create table test2(id number(2) constraint test2_id_fk references test1(id), job varchar2(20));

insert into test1 values(1, '�����', 10);
insert into test1 values(2, '��ȿ��', 25);
insert into test1 values(3, '�̳���', 40);
insert into test1 values(5, '������', 35);
insert into test1 values(6, '������', 15);

insert into test2 values(1, '�ѱ���');
insert into test2 values(3, '���߰���');
insert into test2 values(5, '����');
insert into test2 values(3, '������');
insert into test2 values(4, '����'); -- ����. test1 id �÷��� '4' ���� X
commit;

-- test1, test2 ���̺��� �̳����� ���
select * from test1, test2 where test1.id = test2.id;
select * from test1 inner join test2 on test1.id = test2.id;

create table lno as select loc from dept;
alter table lno add (lnum varchar2(5));

update lno set lnum = '001' where loc = 'NEW YORK';
update lno set lnum = '002' where loc = 'DALLAS';
update lno set lnum = '003' where loc = 'CHICAGO';
update lno set lnum = '004' where loc = 'BOSTON';
commit;

-- �����ȣ, ����̸�, �μ���ȣ, �μ���, ��ġ, ��ġ��ȣ�� ����� �ǵ��� ó��
select e.empno, e.ename, d.deptno, d.dname, d.loc, l.lnum from emp e, dept d, lno l where e.deptno = d.deptno and d.loc = l.loc;
select e.empno, e.ename, d.deptno, d.dname, d.loc, l.lnum from emp e inner join dept d on e.deptno = d.deptno inner join lno l on d.loc = l.loc; -- ANSI INNER JOIN
-- from Table1 inner join Table2 on ����1 inner join Table 3 on ����2

-- using�� �̿��� ���� ���� ����. on ��� ��� ����. ��, ���� ���ǿ� ���Ǵ� �÷����� ������ ��츸 ����.
-- �� ���̺��� �÷����� ������ ���, ANSI INNER JOIN + USING(�ߺ��Ǵ� �÷���)�� �̿��� �ߺ��Ǵ� �÷��� �ϳ���, ���� ���� ����� �� �ִ�.
select * from emp inner join dept using(deptno);

insert into emp (empno, ename) values (8000, 'TEST');
commit;

-- �����ȣ, �����, �μ���ȣ, �μ��� ����ϴµ� �μ��� �Ҵ���� ���� ��� ����� ���ּ���.
select empno, ename, d.deptno, dname from emp, dept d where emp.deptno = d.deptno(+); -- LEFT OUTER JOIN
select empno, ename, d.deptno, dname from emp left outer join dept d on emp.deptno = d.deptno; -- ANSI LEFT OUTER JOIN
select empno, ename, d.deptno, dname from dept d, emp where d.deptno(+) = emp.deptno; -- RIGHT OUTER JOIN
select empno, ename, d.deptno, dname from dept d right outer join emp on d.deptno = emp.deptno; -- ANSI RIGHT OUTER JOIN

-- �����ȣ, �����, �μ���ȣ, �μ��� ����ϴµ� �μ��� �Ҵ���� ���� ����� ����� �Ҵ���� ���� �μ��� ���� ����� ���ּ���.
-- A ���̺� �����ִ� ��� ������, B ���̺� �����ִ� ��� �����͸� ���(= B ���̺��� ���� NULL�� ��쵵, A ���̺��� ���� NULL�� ��쵵 ������ִ�) : FULL OUTER JOIN
select empno, ename, d.deptno, dname from emp full outer join dept d on emp.deptno = d.deptno; -- ANSI FULL OUTER JOIN

select count(*) from employees;

-- 1. �����ȣ , ����� ��Ī NAME , �μ���ȣ, �μ����� ��µǵ��� ó�����ּ���.
select e.employee_id, e.first_name || ' ' || e.last_name as name, d.department_id, d.department_name from employees e, departments d where e.department_id = d.department_id; -- INNER JOIN
select e.employee_id, e.first_name || ' ' || e.last_name as name, d.department_id, d.department_name from employees e join departments d on e.department_id = d.department_id; -- ANSI INNER JOIN

-- 2. �����ȣ, �μ���ȣ, �μ���, �����μ����� ����ϴµ�, �μ��� �Ҵ���� ���� ���ϻ������ ������ּ���.
select e.employee_id, e.first_name || ' ' || e.last_name as name,  d.department_id, d.department_name, d.manager_id from employees e, departments d where e.department_id  = d.department_id(+);

-- 3. �����ȣ, ����� ��Ī NAME, �μ���ȣ, �μ����� ����ϴµ�, ����� �Ҵ���� ���� �μ��� ���ؼ��� ������ּ���.
select e.employee_id, d.department_id, d.department_name, d.manager_id from employees e, departments d where e.department_id(+)  = d.department_id;

-- ���̺�: EMPLOYEES , JOB_HISTORY , JOBS
-- JOB_HISTORY ���̺��� START_DATE (�ش� ��å�� ���۵� ����), END_DATE(�ش� ��å�� ����� ����)
-- JOBS :  JOB_ID : ��å���̵�,  JOB_TITLE : ��å��
-- ��å�� ����� ������ �����ȣ, ����� ��Ī NAME, �μ���ȣ, �μ���, ��å��, �ش� ��å�� ���۵� ����,  �ش� ��å�� ����� ���ڸ� ������ּ���.
select e.employee_id, e.first_name || ' ' || e.last_name as name, j.department_id,js.job_title, j.start_date, j.end_date from employees e inner join job_history j on e.employee_id = j.employee_id join jobs js on j.job_id = js.job_id order by e.employee_id, j.start_date asc;

-- ���̺�: EMPLOYEES, JOBS
-- JOBS���̺��� JOB_ID : ��å���̵�, JOB_TITLE : ��å��, MIN_SALARY : �ּ� ����, MAX_SALARY: �ִ뿬��
-- 'Nancy Greenberg'�� ���� �� �ִ� �����ȣ, �����, �ִ뿬���� �ּ� ����, ��å���̵�, ��å���� �����ȣ ������������ ����ϼ���.
select e.employee_id, e.first_name || ' ' || e.last_name, j.max_salary, j.min_salary, j.job_id, j.job_title from employees e, jobs j where e.job_id = j.job_id and e.first_name || ' ' || e.last_name = 'Nancy Greenberg' order by e.employee_id;

drop table test1;
drop table test2;

delete from emp where empno = 8000; -- emp ���̺��� empno�� 8000�� �� ����
commit;

-- VIEW : ���Ϻ�
create table emp01 as select * from emp;

create view view_emp01 as select empno, ename, sal, deptno from emp01 where deptno = 10;
desc view_emp01; -- view_emp01�� ���� ����
select * from view_emp01;  -- view_emp01�� ������ ���� ���ǿ� �����ϴ� ���� �����͸� ���

insert into view_emp01 values(8000, 'ANGEL', 7000, 10); -- ���Ϻ�� ������ ��Ȯ�ϰ� ����Ǿ� �־� �÷��� ��Ȯ�ϰ� ã�� �� ���� -> DML ����ؼ� ���� ���� ����
commit;
drop view view_emp01;

select * from dba_constraints; -- ��� ������ �����ϴ� �������� Ȯ��
select * from user_tables; -- test ������ �����ϴ� ��� ���̺� Ȯ��
select * from user_views; -- test ������ �����ϴ� ��� view Ȯ��

-- VIEW : ���պ�
create view view_emp_dept as select ename, dname from emp, dept where emp.deptno = dept.deptno;

delete from view_emp_dept where dname = 'ACCOUNTING'; -- ����. view�� ��Ȯ�ϰ� �� ���̺� ����Ǿ����� �ʽ��ϴ�.
insert into view_emp_dept (ename, dname) values ('MICLE', 'ARTIST'); -- ����. view�� ��Ȯ�ϰ� �� ���̺� ����Ǿ����� �ʽ��ϴ�.

-- emp ���̺� WORD�� �̸��ڿ� D�� �� ���̴� ���
update emp set ename = 'WARDDD' where ename = 'WARD'; -- update ���̺�� set ������ �÷� = ������ �� where ����;
commit;

select * from view_emp_dept; --> ���� ���̺��� �����͸� �������� ������ �����ֱ� ������ ������ �����Ǹ� ���� �����ȴ�.
drop table emp; --> ������ emp ���̺��� �����Ǿ� view�� ������ �޴´�.

create table emp as select * from scott.emp;
drop view view_emp_dept; --> = create view view_emp_dept as select ename, dname from emp, dept where emp.deptno = dept.deptno; ������ ����

-- VIEW : �ζ��κ�
select * from (select 25/5 as result from dual);
-- select 25/5 as result from dual; --> ��������, �������̺� ���� ���̺����� ��ȯ�ϱ� ������ from���� �� �� �ִ�.

select IMSI.*, 'TEST' as TEST from (select ename, dname from emp e, dept d where e.deptno = d.deptno) IMSI;
-- select ename, dname from emp e, dept d where e.deptno = d.deptno; --> inner join�� ���� emp ���̺��� ename �÷�, dept ���̺��� dname �÷��� ������ ��ȯ

-- �������� : �����ϴ��� �ǹ�
select * from dept d where exists(select * from emp e where e.deptno = d.deptno);
-- exists�� ����� ���������� ���, ������������ ���������� ���ÿ� ������ ���ؾ��Ѵ�. 

select * from emp e where exists(select * from dept d where d.deptno = e.deptno);
select * from dept d where d.deptno in (select distinct deptno from emp where sal >= 3000);
-- select distinct deptno from emp where sal >= 3000; ==> 10, 20 ��ȯ
-- select * from dept d where d.deptno in (10,20); 136���ٰ� ������ �ǹ���.

-- ��Ƽ���� : �������� �ʴ��� �ǹ�
select * from dept b where not exists (select * from emp e where e.deptno = b.deptno);
-- dept ���̺��� deptno = 10�϶�, emp ���̺��� deptno�� ������ �����Ͱ� ���� dept ���̺��� ��� ������ �����´�.

select * from dept b where b.deptno not in (select distinct deptno from emp where sal >= 3000);
-- select distinct deptno from emp where sal >= 3000; ==> 10,20 ��ȯ
-- select * from dept b where b.deptno not in (10,20); 141���ٰ� ������ �ǹ���. ==> dept ���̺� deptno �÷��� 10, 20�� ���Ե��� �ʴ� ��� ���� ���

create table ct as select * from customers;

-- �������� �߰� : alter table ���̺�� add constraint �������Ǹ� ������������(�÷�);
alter table customers add constraint customers_cust_id_pk primary key(cust_id);

-- �׽�Ʈ �غ�
create table employ (empid  number(4) constraint employ_id_pk primary key, name  varchar2(10) not null, job  varchar2(10) not null, deptid  number(3), salary  number(4) not null, bonus  number(3), mgrid  number(4), hiredate  date  not null);

insert into employ values (6200,'��ö��','�̻�',200, 5000,null,null,'1997-12-17');
insert into employ values (6311,'����ġ','����',100,3500,null,6200,'1998-12-17');
insert into employ values (7489,'�۾���','������',400,1850,200,6321,'1999-02-27');
insert into employ values (7522,'����Ŭ','������',400,1850,300,6321,'1998-02-28');
insert into employ values (6321,'������','����',400,3800,500,6200,'1999-04-20');
insert into employ values (6351,'����','����',300,2850,null,6200,'2000-05-31');
insert into employ values (7910,'�̿���','�渮',300,1000,null,6351,'2001-05-01');
insert into employ values (6361,'�̹߼�','����',200,3200,null,6200,'2000-06-09');
insert into employ values (7878,'�ڼ�ó','������',200,3000,null,6361,'2001-06-05');
insert into employ values (7854,'�ֿ��','������',400,1500,0,6321,'2001-09-08');
insert into employ values (7872,'�Ӳ���','�繫��',100,1500,null,6311,'2001-02-12');
insert into employ values (7920,'�踻��','�繫��',300,1050,null,6351,'2001-03-18');
insert into employ values (7901,'������','������',null,3000,null,null,'2001-12-03');
insert into employ values (7933,'ȫ�浿','�繫��',200,1050,null,6361,'2002-01-02');

--1. ����� �޿��� 12�� ���� ����� ��µǵ��� ������ �����ϰ�, ������ ��Ī�� "����" ���� ǥ���Ͻÿ�.
select salary * 1.1 ���� from employ;
select salary + salary * 0.1 ���� from employ;
--2. ������ '������' �� ����� �̸�, ����, �μ����̵� �˻��Ͻÿ�.
select name, job, deptid from employ where job = '������';
--3. �Ի����� '2001�� 12�� 3��' �� ����� �˻��Ͻÿ�.
select * from employ where hiredate = '2001/12/03';
--4. �μ����̵� 200 �� ����� �̸�, ����, �Ի���, �μ����̵� �˻��Ͻÿ�.
select name, job, hiredate, deptid from employ where deptid = 200;
--5. �޿��� 3000 �̻��̰� 5000 ������ ����� �̸�, �޿��� �˻��Ͻÿ�.
select name, salary from employ where salary between 3000 and 5000;
--6. �����ھ��̵� 6311, 6361, 6351 �߿��� �ش��ϴ� ����� ������̵�, �����ھ��̵�, �̸�, �μ����̵� �˻��Ͻÿ�.
select empid, mgrid, name, deptid from employ where mgrid in(6311, 6361, 6351);
select empid, mgrid, name, deptid from employ where mgrid = 6311 or mgrid = 6361 or mgrid = 6351;
--7. ������ '�繫��' �̰ų� '�渮' �� ����� �˻��Ͻÿ�.
select * from employ where job = '�繫��' or job = '�渮';
select * from employ where job in ('�繫��','�渮');
--8. �޿��� 3000 �̻��̰� ������ '����' �� ����� �˻��Ͻÿ�.
select * from employ where salary >= 3000 and job = '����';
--9. ������ ( '������' �̰ų� '�繫��' ) �� �ƴ� ����� �˻��Ͻÿ�.
select * from employ where job not in ('������', '�繫��');
select * from employ where job != ('������') and job != ('�繫��');
--10. �޿��� 1500 ~ 2500 ���̰� �ƴ� ����� �˻��Ͻÿ�.
select * from employ where salary not between 1500 and 2500;
--11. ������ '�渮' �̰ų� '����' �̰�, �޿��� 3000 �� �Ѵ� ����� �˻��Ͻÿ�.
select * from employ where job in ('�渮','����') and salary > 3000;
--12. �Ի����� 2000�� ������ ����� �˻��Ͻÿ�.
select * from employ where hiredate >= '2000/01/01';
select * from employ where to_char(hiredate, 'yyyy') >= '2000';
--13. �̸��� 'ö' �̶�� ���ڸ� �����ϴ� ����� ����� �˻��Ͻÿ�.
select * from employ where name like('%ö%');
--14. ���ʽ��� ���� �ʴ�(���ʽ��� null��) ����� �˻��Ͻÿ�.
select * from employ where bonus is null or bonus = 0;
select * from employ where nvl(bonus,0) = 0;
--15. �Ի����� 1999�⵵�� ����� �˻��Ͻÿ�.
select * from employ where substr(hiredate, 1, 2) = '99';
--16. �޿��� 3000 �̻��� ����� �޿��� 10% �λ��Ͻÿ�.
-- update ���̺�� set �÷��� = �����Ұ� where ����;
update employ set salary = salary * 1.1 where salary >= 3000;
--17. 2001�� ���Ŀ� �Ի��� ����� �����Ͻÿ�.
delete from employ where hiredate >= '2000/01/01';
rollback;

drop table emp01;
drop table lno;