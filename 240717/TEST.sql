create table tb_member(m_seq number constraint pk_member_seq primary key, m_userid varchar2(20) not null, m_pwd varchar2(20) not null, m_email varchar2(50), m_hp varchar2(20), m_registdate date default sysdate, m_point number default 0);
create sequence seq_tb_member;

insert into tb_member (m_seq, m_userid, m_pwd, m_email, m_hp) values (seq_tb_member.nextval, 'apple', '1111', 'apple@apple.com', '010-8888-9999');
-- nextval : ���� �ڷ����� ����Ǵ� ���� �ƴ� �̻�, nextval�� ����ȴ�.
-- m_registdate, m_point �÷��� ������� �ʾұ� ������ �� �÷��� default ���� ����.
commit;

-- ȸ�� �α���
select * from tb_member where m_yn = 'Y' and m_userid = 'honggd123' and m_pwd = '1234';
select * from tb_member where m_yn = 'Y' and m_userid = 'apple' and m_pwd = '1111';

--��üȸ����� ��ȸ(����)
select * from tb_member; -- ArrayList<> Ŭ���� �̿�

-- �α����� ����� ��������(�� ��������, Ư������� �˻� �޴�)
select * from tb_member where m_seq = 1 and  m_yn = 'Y'; -- VO,DTO Ŭ���� �̿�

-- ȸ������
insert into tb_member(m_seq, m_userid, m_pwd, m_email, m_hp, m_yn) values (seq_tb_member.nextval, 'honggd123', '1234', 'hgd@hi.com', '01011118888', 'Y');

-- ������ ����, Ư������� ����  ����
update tb_member set m_email = 'hhh@hi.com' where m_userid = 'honggd123' and m_yn = 'Y';

-- ȸ��Ż��
update tb_member set m_yn = 'N' where m_userid = 'hoggd123'; 

alter table tb_member add(m_yn varchar2(1));
alter table tb_member modify(m_yn varchar2(1) not null check(y_yn in ('Y', 'N')));
alter table tb_member modify(m_yn varchar2(1) default 'Y');