select name, addr
from test_like
where name like '____';

select name, addr
from test_like
where name like '��__';


select * from emp;
-- ��� ���̺��� ������� 'M' �Ǵ� 'K'�� �����ϴ� ��� �����
-- �����, �����ȣ, �Ŵ�����ȣ�� �˻�.

select ename, empno, mgr
from emp
where ename like 'M%' or ename like 'K%';

-- ��� ���̺��� 'R'�� �ΰ��� ��� �ִ� ����� �����, �����ȣ �˻�
select ename, empno
from emp
where ename like '%R%R%';

select * from emp;

--�ܺε����� �߰��ϱ�
--�����͸� �߰��� ���̺��� ����

create table zipcode(
	zipcode char(6),
	sido char(6),
	gugun varchar2(25),
	dong varchar2(200),
	bunji varchar2(25),
	seq number(5)
);

select count(*) from zipcode;

truncate table zipcode;

select * from zipcode;
select	sido, gugun, dong
from	zipcode
where	sido = '��õ' and gugun like '%����%';

--group by
-- ������̺��� ���� �˻�
select job, count(*)
from emp
group by job;

-- �ߺ����� ������� �ʴ´�.

--���� : group by �Ŀ� ������ ���� �÷� (empno)�� �Բ� ��ȸ�Ǹ� error�߻�
select job, empno
from emp
group by job;

--������̺��� 10, 20�� �μ��� ����, �μ���ȣ�� �˻�
--�� �μ���, �ߺ������� ������� �ʴ´�.
select job, deptno
from emp
--where deptno in (10, 20)
group by job, deptno
having	deptno in (10, 20);

--������̺��� �μ��� ������� 4���� �ʰ��ϴ� �μ��� �μ���ȣ�� �˻�.
select count(deptno), deptno
from emp
group by deptno
having count(deptno) > 4;

--������̺��� ������ ��ȸ
--��, �ߺ������� ��ȸ���� �ʴ´�.
select	distinct	job, empno
from	emp;

--distinct �����÷��� ����ϸ� �ڿ� �÷��� �������� �����Ͽ� ���ڵ带 �����ش�.
select distinct job, mgr
from emp;

select * from user_indexes;
