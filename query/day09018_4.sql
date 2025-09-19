--�������� : �������� ���迬���ڸ� �ٿ��� ������ ��.
--������̺��� ������ 1250�̻� 3000������ �������
-- �����ȣ, �����, ����, ����, ���ʽ�, �μ���ȣ�� �˻�.

select  empno, ename, job, sal, comm, deptno
from 		emp
where   sal >= 1250 and sal <= 3000;
--where   sal > 1249 and sal < 3001;

--between A and B

select  empno, ename, job, sal, comm, deptno
from 		emp
where   sal between 1250 and 3000;

--������̺��� ������ 'SALESMAN'�̸鼭 ������ 1250�� �ʰ��ϴ� �����
-- �����, ����, ���ʽ�, �μ���ȣ, ������ ��ȸ

-- ������̺��� ������ 'SALESMAN','CLERK','ANALYST'�� �������
-- �����ȣ, �����, ����, ���ʽ�, ���� ��ȸ
select	empno, ename, sal, comm, job
from 		emp
where 	job in ('SALESMAN','CLERK','ANALYST');
--where		job=  'SALESMAN' or job='CLERK' or job='ANALYST';

--������̺��� ���ʽ��� ���� ������� �����ȣ,�����,����, ���ʽ� �˻�.
select	empno, ename , sal, comm
from		emp
where		comm is null;
--where		comm = null;

--������̺��� ���ʽ��� �����ϴ� ������� �����ȣ,�����,����, ���ʽ� �˻�.
select	empno, ename , sal, comm
from		emp
where		comm is not null;
--where		comm != null;

-------���ڿ� ������ ( like ������ )--------------------------------
-- like�� Ư������ (%,_)�� ������� ������ ���迬������ = ������ ������ ����

select	empno, ename, job, mgr, sal
from		emp
where		ename like 'WARD';
--where		ename like '�����';

select * from EMP;

create table test_like(
name varchar2(30),
addr varchar2(300)
);

insert into test_like(name, addr) values('�Ӵٹ�','����� ������ ���ﵿ');
insert into test_like(name, addr) values('�Ӽ���','����� ������ ���ʵ�');
insert into test_like(name, addr) values('���ں�','��⵵ ��õ�� ��� ');
insert into test_like(name, addr) values('���ھƺ�','���ֽ� �ϵ� �̵�');
insert into test_like(name, addr) values('�����ں�','����� �߱� ��ȸ��');
insert into test_like(name, addr) values('������','����� ���빮�� ���빮��');
insert into test_like(name, addr) values('���ؿ�','��õ������ ������ ���ʵ�');
insert into test_like(name, addr) values('�����','����� ���۱� ��絿');
commit;

--test_like���̺��� ���� '��'���� ȸ���� �̸��� �ּҸ� �˻�
select	name,addr
from 		test_like
where  	name like '��%';

--test_like���̺��� '�����'�� �������� ȸ���� �̸��� �ּҸ� �˻�
select	name,addr
from 		test_like
where  	addr like '�����%';

--�̸��� '��'�� ������ �̸�,�ּ��� �˻�
select	name,addr
from 		test_like
where  	name like '%��';

--�ּҰ� '���ʵ�'���� ������ �̸�,�ּ��� �˻�
select	name,addr
from 		test_like
where  	addr like '%���ʵ�';

--�̸��� '��'�� ����ִ��̸�,�ּҸ� �˻�
select	name,addr
from 		test_like
where  	name like '%��%';

select * from TEST_LIKE




