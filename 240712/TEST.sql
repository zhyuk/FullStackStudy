-- INDEX
select * from customers where cust_id = 4141; -- 0.002s
select * from ct where cust_id = 4141; -- 0.006s

select * from customers where cust_id = 23697; -- 0.002s
select * from ct where cust_id = 23697; -- 0.008s

select * from customers where cust_id = 11252; -- 0.001s
select * from ct where cust_id = 11252; -- 0.003s

-- INDEX ����
-- : alter index �����ε����� rename to ���ο� �ε�����;
-- �������ǿ� ���� �ڵ����� ������ index�� ���, �������Ǹ� = �ε������� �ȴ�.
alter index customers_cust_id_pk rename to ct_custid_index;

-- INDEX ����
-- : create index [������.]�ε����� on [������.]���̺��(�÷���);
create index ct_cust_id_idx on ct(cust_id);

-- INDEX ����
-- : drop index �ε�����;
drop index ct_cust_id_idx;

-- ���� INDEX ����
-- : create index [������.]�ε����� on [������.]���̺��(�÷�1, �÷�2, ...);
-- �÷��� ���, index�� �������� �� ���� ���� �÷� �ۼ�
create index ct_cust_id_name_idx on ct(cust_id, cust_name);

select * from all_indexes; -- ��� ������ �ε��� Ȯ���ϴ� ��ɾ�
select * from user_indexes; -- ���� ������ �ε��� Ȯ���ϴ� ��ɾ�

drop index ct_cust_id_name_idx;

-- UNIQUE INDEX ����
-- : �ε����� ������ �÷��� �ߺ����� ����ϸ� �ش� �÷����� UNIQUE INDEX�� ������ �� ����.
create unique index ct_index_nm_mail on ct (cust_email); -- ����. cust_email �÷����� �������� ���� 
create unique index ct_index_nm_mail on ct (cust_id); -- �������.

drop index ct_index_nm_mail;

create index ct_index_id on ct(cust_id); -- ���̺� �� - �ε���- UNIQUENESS�� NONUNIQUE�� ���, �Ϲ� �ε����� �ǹ�.
drop index ct_index_id;

-- INDEX ������
-- alter index �ε����� rebuild;
-- �����͸� ����ϴ� ���� �������� �� ����ϸ� �ȴ�.
alter index ct_cust_id_idx rebuild;

--select substr(hiredate, 1, 3) ,substr(hiredate, 1, length(hiredate)) from employ;
--select * from employ where to_char(hiredate,'YYYY') >= '2000';

--���̺� : employees e, departments d , countries c , locations l, jobs j, job_history jh// ����, �������� �̿�
-- 1. �μ��� �ҵ��� ���� ����� �˻� 
select * from employees e where not exists(select * from departments d where e.department_id = d.department_id);
-- 2. Roma ������ �ִ� �μ����� �μ����� �˻�
select * from departments d, locations l where d.location_id = (select l.location_id from locations l where city = 'Roma');
-- 3. Accounting Manager ��å�� ���� ��� �˻�
select * from employees e where e.job_id = (select  job_id from jobs where job_title = 'Accounting Manager');
-- 4. Payam Kaufling�� ���� �� �ִ� �ּҿ����� �ִ뿬�� �˻�
select min_salary, max_salary from jobs j where j.job_id = (select job_id from employees where first_name || ' ' || last_name = 'Payam Kaufling');
--select min_salary, max_salary from jobs j where j.job_id = (select job_id from employees where first_name = 'Payam' and last_name = 'Kaufling');

-- 5. Australia ������ �����ִ� �μ��� ���� �˻�
select * from departments d where location_id in (select location_id from locations l where country_id = (select country_id from countries where country_name = 'Australia'));
-- 1. select country_id from countries where country_name = 'Australia';
-- 2. select location_id from locations where country_id = 'AU';
-- 3. select * from departments where department_id = 2200;
-- 4. select location_id from locations l where country_id = (select country_id from countries where country_name = 'Australia');

select country_id from countries where country_name = 'Canada';
select location_id from locations where country_id = 'CA';
select * from departments where location_id in (1800,1900) ;

-- departments ���̺��� location_id���� 2500, 2700�� �����ϰ� �ִ� ����� ���
select location_id from departments d where d.location_id in (2500,2700);
select country_id from locations l where location_id in(select location_id from departments d where d.location_id in (2500,2700));
select country_name from countries where country_id in(select country_id from locations l where location_id in(select location_id from departments d where d.location_id in (2500,2700)));

-- �����÷�
-- int�ڷ��� (= number(38)�� ����) : ����, 0, ����� ǥ�� 
create table board(no int primary key, subject varchar2(30), content varchar2(50), w_date date);

-- board�� no �÷��� ����� ������ ����
create sequence seq_no nocache; -- 1���� 1�� �����ϴ� ������

insert into board values (seq_no.nextval, 'java1', 'java', sysdate);
insert into board values (seq_no.nextval, 'java2', '�ڹ�', sysdate);
insert into board values (seq_no.nextval, 'java3', ����, sysdate); -- ����. �ڷ����� ����Ǵ� ���� ���� �Է� �õ�
insert into board values (seq_no.nextval, 'java3', '����', sysdate); -- 88�� ������ ���� nextval�� ������� �ʾ���. -> �ڷ����� ����Ǵ� ������ ����� ������ ���, ������ �������� ����

-- seq_no �������� ���簪 ����ϴ� ���� ���̺�
select seq_no.currval from dual;
select seq_no.nextval from dual;

insert into board values (seq_no.nextval, 'java2', '����', sysdate); -- seq_no.nextval = 5 // 93�� �ٿ��� seq_no.nextval ������� ���� 4�� �̹� ����

select * from all_sequences; -- ��� ������ ���
select * from user_sequences; -- ���� ������ ��� ������ ���

select seq_no.currval from dual; -- nextval�� ��� �� ���� ����Ǳ� ������ currval ��� �� ��µ� ���� +1�� ���ش�.
rollback;

insert into board values (seq_no.nextval, 'java2', '����', sysdate); -- �ѹ������� ������ ���� �ѹ���� ����. �� �� nextval�� ���� ���� ���� �� ����

drop sequence seq_no; -- ������ ����Ģ seq_�÷��� / �÷���_seq

truncate table board; -- board ���̺� �� ��� ������ �߶�. -> �ڵ� commit��

create sequence seq_no start with 5 increment by -2 maxvalue 5 nocache;
-- start with 5 �κ��� ���� ����, maxvalue 5 �κ��� start���� max���� ũ�� �ȵǹǷ� ���� �Ұ�. nocache �κ��� ����Ʈ�� nocache �̹Ƿ� ���� ����

insert into board values (seq_no.nextval, 'java1', 'java', sysdate);
insert into board values (seq_no.nextval, 'java2', '�ڹ�', sysdate);
insert into board values (seq_no.nextval, 'java3', '����', sysdate);
insert into board values (seq_no.nextval, 'java2', '����', sysdate);
insert into board values (seq_no.nextval, 'java2', '����', sysdate);
insert into board values (seq_no.nextval, 'java2', '���', sysdate);
insert into board values (seq_no.nextval, 'java2', '����', sysdate);
insert into board values (seq_no.nextval, 'java2', '�ѹ�', sysdate);

drop sequence seq_no;
truncate table board;

create sequence seq_no increment by 2 maxvalue 5 cycle cache 2; -- cycle�� ���� �ݺ��� �ǹ�, start with�� ���� ������ minvalue���� ����

insert into board values (seq_no.nextval, 'java1', 'java', sysdate);
insert into board values (seq_no.nextval, 'java2', '�ڹ�', sysdate);
insert into board values (seq_no.nextval, 'java3', '����', sysdate);
insert into board values (seq_no.nextval, 'java2', '����', sysdate); -- primary key ���ŵǱ� ���� �ߺ����� ������� �ʾ� ���� �� ����. 
insert into board values (seq_no.nextval, 'java2', '����', sysdate); -- ������ ������ nextval �����߱� ������ 1�� �ƴ� 3���� ��
insert into board values (seq_no.nextval, 'java2', '���', sysdate);
insert into board values (seq_no.nextval, 'java2', '����', sysdate);
insert into board values (seq_no.nextval, 'java2', '�ѹ�', sysdate);

alter table board drop constraint SYS_C007116;

drop sequence seq_no;
drop table board;

create sequence seq_no nocache; -- start �� : 1, 1�� ������ ��� nocache�� �־��ָ� ��.
select * from emp07;

-- test -> ���ڿ� ��ȯ ==> �Է��� ���ڿ��� ũ�⸸ŭ�� char �ڷ������� �ڵ�����
-- create table emp08 as select 'test' ename, deptno, sal, job from emp;
-- drop table emp08;

-- seq_no.nextval -> ���ڰ� ��ȯ. ==> ���������� ���� ���� ǥ���� �� �ִ� number(38) �ڷ������� �ڵ�����
create table emp07 as select seq_no.nextval empno, ename, deptno, sal, job from emp;

-- empno�� 13���� ����. -> 148�� ���� seq_no.nextval�� 1���� ����Ǵ� ���� �ƴ� �� �ึ�� ����Ȱ��� --> emp ���̺��� �����ŭ ����.
insert into emp07 values (seq_no.nextval, 'MARIA', 90, 6000, 'BABO'); 

update emp07 set empno = seq_no.nextval, deptno = seq_no.nextval where empno = 1; 
-- empno = 14��, deptno = 15�ΰ� �ƴ϶� seq_no.nextval�� �� �� �����ִ��� �� �࿡�� 1���� �����ȴ�.

insert into emp07 values (seq_no.nextval, 'ROSA', 90, 6000, 'CHUNJAE'); -- seq_no.nextval�� 16�� �ƴ� 15�� ���

drop sequence seq_no;
drop table emp07;

create table boa02 (seq number, name varchar2(20) not null);
create sequence bo_se nocache;
drop table boa02;
drop sequence bo_se;

-- dept ���̺��� ������ �����ؼ� dept01 ���̺��� �����ϼ���
create table dept01 as select * from dept where 1 = 0;

-- dept01 ���̺��� deptno �÷��� �ڷ����� number(4)�� ����
alter table dept01 modify (deptno number(4));

-- dept_seq �̸��� ������ ���� => �ɼ� : ���۰� 10, ������ 10, �ִ밪 30;
-- create sequence �������� start with ���۰� increment by ������ maxvalue �ִ밪;
-- cycle : �ݺ��� cache (ũ��) : ���� �̸� ��Ƶδ� ����� minvalue : �ּҰ�
create sequence dept_seq start with 10 increment by 10 maxvalue 30; -- ��������� ���۵Ǵ� �������� min�� ������ 1��.

insert into dept01 values (dept_seq.nextval, 'ACCOUNTING', 'NEW YORK');
insert into dept01 values (dept_seq.nextval, 'RESEARCH', 'DALLAS');
insert into dept01 values (dept_seq.nextval, 'SALES', 'CHICAGO');
insert into dept01 values (dept_seq.nextval, 'PRODUCT', 'TAIWAN'); -- max ���� 30�̰� cycle ������� �ʾұ� ������ ����.

drop sequence dept_seq ;
truncate table dept01;

create sequence dept_seq start with 10 increment by 10 maxvalue 30 cycle cache 2;

insert into dept01 values (dept_seq.nextval, 'ACCOUNTING', 'NEW YORK');
insert into dept01 values (dept_seq.nextval, 'RESEARCH', 'DALLAS');
insert into dept01 values (dept_seq.nextval, 'SALES', 'CHICAGO');
insert into dept01 values (dept_seq.nextval, 'PRODUCT', 'TAIWAN'); -- start with�� ó�� ����Ŭ������ �����ϴ� ����, �� ����Ŭ�� ������ min value���� ���� -> 1

-- sequence ���� ����: start with�� ������ ��� �� ���� ����.
alter sequence dept_seq increment by 10 maxvalue 30 cycle cache 2;
alter sequence dept_seq increment by 10 minvalue 1 maxvalue 30 cycle cache 2;

drop table dept01;

-- �ó��
-- �������Ǿ� ���� ��  �ó�Ը� ������_���̺��_sn�� �������. �ٸ�, �������� �������� ��� ���̺��_sn���� ���
create or replace public synonym dept01_sn for dept;

-- �ó���� ���, ���̺� ��ȸ�� ���·� ��ȸ���� --> �������Ǿ�� �������� ��µǴ� ���� �ƴ϶� �ش�Ǵ� ��ü�� �����ش�.
select * from dept01_sn;

-- scott ������ ��й�ȣ ����. -> �Ϸ� -> ���� - sql ��ũ��Ʈ scott ���� -> scott ��ũ��Ʈ �� select * from test.dept01_sn;�ص� ���� ��µ�.
alter user scott identified by 1111;

-- dept01_sn �ó�Կ� public ���� �ο�
grant select on dept01_sn to public;

-- scott ��ũ��Ʈ ������ select * from dept01_sn; --> ��µ�.

create or replace synonym dept01_sn for dept; -- ���� ������ �������Ǿ�� ��������Ǿ� ��� ������ ���, �ܺο����� �������Ǿ�, ���ο����� ��������Ǿ�� �۵��� 
-- ==> �������Ǿ��� ����� �ϱ⶧���� �������Ǿ�θ� �����ϴ� ���� ����.
drop synonym dept01_sn;
drop public synonym dept01_sn;

create or replace synonym dept01_sn for dept; -- private ������ ��������Ǿ� ����
grant select on dept01_sn to public -- ��ɹ����δ� Ʋ������ ���⶧���� ���� X, ���������� �ش� �ó���� �������Ǿ �ƴϱ� ������ public ������ �ο��ص� �ܺο��� ������ �� ����.
