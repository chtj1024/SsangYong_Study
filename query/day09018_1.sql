-- transaction ����
create table test_transaction(
name varchar2(15),
address varchar2(30)
);

create table test_transaction2(
name varchar2(15),
address varchar2(15)
);

--���ڵ� �߰�
-- ����
insert into test_transaction(name,address)
values('�׽�Ʈ','�����');

insert into test_transaction2(name,address)
values('�׽�Ʈ','�����');

select * from test_transaction;
select * from test_transaction2;
commit; --transaction�Ϸ�
 --����  -> �������� ( �ϳ��� ���̺��� ���ڵ尡 ����  =>�ϰ����� ���� )
insert into test_transaction(name,address)
values('�׽�Ʈ','����� ������ ����');

insert into test_transaction2(name,address)
values('�׽�Ʈ','����� ������ ����');


select * from test_transaction;
select * from test_transaction2;

insert into test_transaction(name,address)
values('�׽�Ʈ2','����� ������ ����');

insert into test_transaction2(name,address)
values('�׽�Ʈ2','����� ������ ����');

select * from test_transaction;
select * from test_transaction2;
-- test_transaction�� �߰��� ���ڵ嵵 ���
rollback; --������ ���̺� �۾��� ��ҽ��� �ϰ����� ����.


------------select-----------------------------------
-- ������̺��� ������� �����ȣ,�����, ����,���ʽ��� �˻�
select  empno, ename, sal, comm
from		emp;

-- ������̺��� ������� ��� �÷��� �˻�
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
FROM EMP;

SELECT *
FROM EMP;

--�μ����̺��� ��� �μ��� �μ���ȣ,��ġ �˻�.
select	deptno, loc
from		dept;

--�л����̺� ����
create table student(
num number(2),
name varchar2(15byte),
tel varchar2(13),
address varchar2(100),
class char(1),
height number(4,1),
weight number(4,1),
input_date date
);

--���ڵ� �߰�
insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(1,'����','010-1234-5678','����� ������ ���ﵿ','A',
	205.5, 75.2,sysdate);
commit;

insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(2,'����','test@a.com','����� ���빮�� ���ﵿ','A',
	5.5, 75.2,sysdate);
commit;

insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(3,'����','010-1234-4321','test@test.com','Z',
	152.9, 49.2,'2025-09-17');
commit;

select * from STUDENT;


