-- ���� �������� Ȯ���ϴ� ��ɾ�
select * from user_constraints;

create table emp03 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4));

insert into emp03 values(7499, 'ALLEN', 'SALESMAN', 30); -- �������
insert into emp03 values(7499, 'JONES', 'MANAGER', 20); -- ���� / primary key : not null && unique => unique ���� ������
insert into emp03 values(NULL, 'JONES', 'MANAGER', 20); -- ���� / primary key : not null && unique => not null ���� ������

-- �������� ������������ ���̺� ����
-- ������������ �ۼ� ��, �������� �̸��� ���� �ش� ���������� ����Ǵ� ��ġ�� �� �� �ְ� ���������� �ڵ鸵�ϱ� ������
create table dept01 ( deptno number(2) constraint dept01_deptno_pk primary key, dname varchar2(15), loc varchar2(15));

insert into dept01 values(50, 'RESEARCH', '����'); -- �������
insert into dept01 (deptno, dname, loc) values (60, 'RESEARCH', '����'); -- �������
insert into dept01 (deptno, dname, loc) values (50, 'TEACHER', '����'); -- ���� / primary key : not null && unique => unique ���� ������

-- ����Ű�� �⺻Ű ����
create table dept02 (deptno number(2), dname varchar2(15), loc varchar2(15), constraint dept02_dno_dnam_pk primary key(deptno, dname));

insert into dept02 values (15, '����', '����'); -- �������
insert into dept02 values (15, '����', '����'); -- �������
insert into dept02 values (15, '����', '��õ'); -- ���� / deptno+dname�� �����͸� ���� primary key �������� �˻� => unique ���� ������

-- �������� CHECK
create table emp05 (empno number(4) primary key, ename varchar2(10) not null, gender varchar2(1) check (gender in('M','F')));
rollback; -- insert ���� commit�� ���� �ʴ��� DDL �ۼ� �� ó���Ǵ� ����Ŀ�Կ� ���� ���� �۾����� ��� ó���ȴ�. 

-- �������� ��� ������ ��� ����. ��, default ������ ��츸 �� ó���� ����ؾ� �Ѵ�.
insert into emp05 values (7566, 'JONES', 'M'); -- �������
insert into emp05 values (7577, 'LEMON', 'F'); -- �������
insert into emp05 values (7588, 'TOMS', 'A'); -- ����. check �������� ������ -> check = 'M' or 'F'�� ����
insert into emp05 values (7599, 'LEMON', 'f'); -- ����. check �������� ������ -> check = 'M' or 'F'�� ���� ==> ���� ��ҹ��� ������


create table emp07 (empno number(4) primary key, ename varchar2(10) not null, gender varchar2(1) check (gender in('M','F')), sal number(7,2) check(sal >= 1000 and sal <= 10000));

insert into emp07 values(1234, 'TOMS', 'M', 1500); -- �������
insert into emp07 values (1234, 'TOMS', 'M', 15000); -- ����. check �������� ������ -> 1000 <= sal <= 10000�� ����

drop table dept01;

-- dept ���̺��� �����ؼ� dept01 ���̺� ����
create table dept01 as select * from dept;

-- FOREIGN KEY
create table emp06 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4) references dept01(deptno)); -- ����. �θ� ���̺��� �⺻Ű�� ������ �� ����
-- �ĺ����� ��, deptno number(4) primary key, constraint emp05_deptno_fk forign key(deptno) references dept01(deptno);
alter table dept01 modify(deptno number(2) primary key); -- dept01 ���̺��� �����մϴ�. (deptno �÷��� primary key(�⺻Ű)��
--create table emp06 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4) references dept01(deptno)); -- �������

insert into emp06 values (7566, 'JONES', 'MANAGER', 50); -- ����. dept01 ���̺� deptno �÷� ���� 50 ������ ���� X
insert into emp06 values (7566, 'JONES', 'MANAGER', null); -- �������. foreign key = null ���
insert into emp06 values (7588, 'JERRY', 'CEO', 90); -- ����. dept01 ���̺� deptno �÷� ���� 90 ������ ���� X
insert into emp06 values (7588, 'JERRY', 'CEO', 10); -- �������
insert into emp06 values (7599, 'JERRY', 'CEO', 10); -- �������

create table emp08 (empno number(4) primary key, ename varchar2(10) not null, job varchar2(9), deptno number(4), dnm varchar2(15), constraint emp08_deptno_fk foreign key(deptno, dnm) references dept02(deptno, dname));
-- dept02 ���̺��� primary key�� deptno�� dname ����� ==> �θ��� �⺻Ű�� ������ ���, �ڽĿ����� foreign key�� �����̿��� �Ѵ�.

drop table dept01; -- ����. ����Ű�� ����
drop table emp06; -- �������
drop table dept01; -- ������� -> �θ�/�ڽ� ������ ���, �ڽ� ���̺���� ���� �� ���� ����

drop table dept02 cascade constraints; -- ������� -> �θ�/�ڽ� ������ ��, �θ� ���̺��� ���� �����ϴ� ���. �θ�/�ڽ� ������� ������ ��ɾ�
drop table emp07;

-- DEFAULT
create table dept01(deptno number(2) primary key, dname varchar2(20) not null, loc varchar2(50) default '����');

insert into dept01 values (10, '�λ�', null); -- null -> ���� ��ü X
insert into dept01 (deptno, dname) values (20, '�λ�'); -- default : null�� ������ ���� �ʾƾ� �Ѵ�.

-- ��������
create table dept02 (deptno number(2));

alter table dept02 add constraint dept02_deptno_pk primary key(deptno);
alter table dept02 modify (deptno constraint dept02_dno_pk primary key); -- ����. 'can have only one primary key' -> �̹� ������
alter table dept02 add (dname varchar2(50));
--alter table dept02 add constraint dept02_deptno_nn not null(dname); -- ����.
alter table dept02 add (dname varchar2(50) not null); -- �������
alter table dept02 drop (dname);
alter table dept02 add dname varchar2(50) constraint dept02_deptno_nn not null; -- �������. not null ���� ���ǿ� �̸��� �ο��ϴ� ���
alter table dept02 modify (dname constraint dept02_dname_nn not null); -- �������. not null ���� ���ǿ��� modify ����ϴ� ���
alter table dept02 drop constraint dept02_deptno_nn;
alter table dept02 drop column dname;

-- ����Ģ
create table "Dept03" ("DeptNo" number(3));

insert into dept03 (deptno) values (100); -- ����. ���̺���� ��ȿ���� ���� -> ���̺� ������ ��, ū ����ǥ ó�� �� ū ����ǥ �ۼ� �ʼ�
insert into "Dept03" (DeptNo) values (100); -- ����. DeptNo : ��ȿ���� ���� �ĺ����Դϴ�. => �÷� ������ ��, ū ����ǥ ó�� �� ū ����ǥ�� �ۼ��������
insert into "Dept03" ("DeptNo") values (100); -- �������

drop table "Dept03";

create table dept01 as select * from dept;
-- scott �������� dept ���̺��� ������ dept01 ���̺� ����
create table dept01 as select * from scott.dept;
-- scott �������� dept ���̺��� ������ ������ dept01 ���̺� ����
create table dept01 as select * from scott.dept where 1 = 0;


insert into dept01 values (10, 'ACOOUNTING', 'NEW YORK');

savepoint c1;
insert into dept01 values (20, 'RESEARCH', 'DALLAS');

savepoint c2;
insert into dept01 values (30, 'SALES', 'SHICAHO');

savepoint c3;
insert into dept01 values (40, 'OPERATIONS', 'BOSTON');

rollback to c3; -- c3�̶�� �̸��� ���� savepoint�� �ѹ��� -> c3 ���� ���븸 �ǵ�����
rollback to c3;
commit;

select * from dept01;

insert into dept01 values (40, 'OPERATIONS', 'BOSTON');
commit; 

rollback to c1; -- ����. savepoint�� commit �� Ȯ��ó�� ��

-- ��������
-- ��� �̸��� 'JONES'�� ����� �μ��� ���
select dname from dept where deptno = (select deptno from emp where ename = 'JONES');

-- 'SMITH'�� ���� �μ����� �ٹ��ϴ� ����� ������ ���
select * from emp where deptno = (select deptno from emp where ename = 'SMITH') and ename != 'SMITH';

-- OPERATIONS �μ����� �ٹ��ϴ� ����� ���, �̸�, ��å, �μ���ȣ ���
select empno, ename, job, deptno from emp  where deptno = (select deptno from dept where dname = 'OPERATIONS'); -- emp ���̺� �� �μ���ȣ 40�� ��� �÷��� ����

-- BLAKE�� ����ϴ� ���������� ���, �̸�, ��å, �μ���ȣ ���
select empno, ename, job, deptno from emp where mgr = (select empno from emp where ename = 'BLAKE');

-- CHICAGO �������� �ٹ��ϴ� ����� ���, �̸�, �μ���ȣ ���
select empno, ename, deptno from emp where deptno = (select deptno from dept where loc = 'CHICAGO');

-- 'ALLEN'�� ������ �⵵�� �Ի��� ����� ���, �̸�, �Ի����� ���
select empno, ename, hiredate from emp where substr(hiredate, 1, 2) = (select substr(hiredate,1,2) from emp where ename = 'ALLEN') and ename != 'ALLEN';
select empno, ename, hiredate from emp where to_char(hiredate, 'YYYY') = (select to_char(hiredate, 'YYYY') from emp where ename = 'ALLEN') and ename != 'ALLEN';

-- WARD���� �� ���� ������ �޴� ����� ���, �̸�, ���� ���
select empno, ename, sal from emp where sal > (select sal from emp where ename = 'WARD');
-- �������� : 
--select sal from emp where ename = 'WARD';

-- 'RESEARCH' �μ��� �ƴ� �ٸ� �μ����� �ٹ��ϴ� ����� ���, �̸�, �μ���ȣ ���
select empno, ename, deptno from emp where deptno != (select deptno from dept where dname = 'RESEARCH');
select empno, ename, deptno from emp where not deptno = (select deptno from dept where dname = 'RESEARCH');
select empno, ename, deptno from emp where not deptno <> (select deptno from dept where dname = 'RESEARCH'); -- <>�� �ƴϴٸ� �ǹ�
-- �������� : 
--select deptno from dept where dname = 'RESEARCH';