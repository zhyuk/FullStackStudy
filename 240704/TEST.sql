--SELECT ENAME || '�� �� �޿��� ' || (SAL+COMM) || '�Դϴ�.' AS "���"
--FROM EMP
--WHERE COMM IS NOT NULL;

--SELECT DISTINCT DEPTNO, ENAME FROM EMP; -- DISTINCT : ���� �ߺ� ���� �� ���, DISTINCT �÷���1, �÷���2 : �÷���1 �÷���2�� ���� �� �ߺ� ���� ���� -> �ٿ��� ��� ��µ�
--SELECT DISTINCT JOB FROM EMP; -- ������̺��� ��å�� ������ ��������
--SELECT * FROM EMP WHERE MGR = 7566; -- JONES�� �����ϴ� �������� ��������
--SELECT DISTINCT JOB FROM EMP WHERE MGR = 7698; -- BLAKE�� �����ϴ� ���������� �˻��� �� �ش� ������������ ��å�� � ���� �ִ��� ��������


/*  �÷� ��Ī : SELECT �÷��� [AS] ��Ī��
    �÷� ��Ī : SELECT �÷��� [AS] "��Ī��"
    "" ū ����ǥ�� �ٿ����ϴ� ���� : ��Ī�� ������ �� �ְų�, Ư�����ڰ� ���Եǰų�, ��ҹ��ڸ� �����ؼ� ����ϰ��� �Ҷ�
*/