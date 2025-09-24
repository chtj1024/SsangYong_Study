-- ��������� Ȯ���� �� �ִ� DD : user_constraints
select * from user_constraints;

-- DD�� �����ڰ� insert, update, delete�� ������ �� ����.
update	user_constraints
set			CONSTRAINT_NAME = 'ENAME_NOTNULL'
where		TABLE_NAME = 'EMP' and CONSTRAINT_TYPE = 'C';

--create subquery
--dept ���̺��� ����÷���, ��������, ũ��, ���ڵ带 �����Ͽ�
--CP_DEPT ���̺��� ����.

select * from user_constraints
where table_name = 'DEPT';

create table cp_dept as (select * from dept);

--��������� ������ �������̺� �߰�
insert into dept(deptno, dname, loc)
values(10, '���ߺ�', '����');

insert into cp_dept(deptno, dname, loc)
values(10, '���ߺ�', '����');

select * from cp_dept;

--dept ���̺��� �μ���ȣ �μ����� �÷���, ��������, ũ��, ���ڵ带
-- �����Ͽ� cp_dept2 ���̺��� ����.
create table	cp_dept2 as
(select	deptno, dname
from		dept);

select * from cp_dept2;

select * from user_constraints;

--emp���̺��� �����ȣ, �����, ����, �Ի�����
--�÷���, ��������, ũ�⸦ �����Ͽ� CP_EMP ���̺��� ����
create table cp_emp as
(select	empno, ename, job, hiredate
from		emp); -- ���� �̹� ��������־ ����� �ٽø���

select * from user_constraints
where table_name in ('EMP', 'CP_EMP');

insert into cp_emp(empno, ename, job, hiredate)
values(7934, '�����', '���', sysdate);

select * from cp_emp;

--����� ������� (not null) üũ
insert into cp_emp(empno, ename, job, hiredate)
values(7934, '', '���', sysdate);

insert into cp_emp(empno, job, hiredate)
values(7934, '���', sysdate);

-- ������̺� 10, 30�� �μ�������� �����ȣ, �����, �μ���ȣ,
-- �Ŵ�����ȣ, �Ի����� �˻��Ͽ� cp_Emp2���̺��� ����.

create table cp_emp2 as
(select	empno, ename, deptno, mgr, hiredate
from		emp
where		deptno in (10, 30));

select * from cp_emp2;

--������̺� �����ȣ, �����, ����, �Ŵ�����ȣ, �Ի���, ����, ���ʽ�
-- �μ���ȣ�� ������ (���ڵ� x) �����Ͽ� cp_emp3���̺��� ����

create table cp_emp3 as
(select	*
from		emp
where		1 = 0);

select * from cp_emp3;

create table cp_emp4 as (select * from emp);
