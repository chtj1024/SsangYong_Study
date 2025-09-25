-- ���̺��� �������� �����Ͽ� �˻�
select * from cp_emp;
-- ����(emp)�� ����(cp_emp)�� ��� ��� ������ �˻�
-- �����ȣ, �����, ����, �Ի��� �˻�
-- union : �ߺ����� ��µ��� �ʴ´�.
select	empno, ename, job, hiredate
from		emp
union
select	empno, ename, job, hiredate
from		cp_emp;

-- union all - �ߺ����� ��µȴ�.
select	empno, ename, job, hiredate
from		emp
union		all
select	empno, ename, job, hiredate
from		cp_emp;

-- �÷����� �޶� �ǰ� ��������, ������ �ݵ�� ���ƾ��Ѵ�.
select	empno, ename, job, hiredate
from		emp
union		all
select	empno, job, ename, hiredate
from		cp_emp;

-- �÷��� ������ �ٸ��� error
select	empno, ename, job, hiredate
from		emp
union		all
select	empno, job, ename
from		cp_emp;

-- �÷��� ���������� �ٸ��� error
select	empno, ename, job, hiredate
from		emp
union		all
select	job, empno, ename, hiredate
from		cp_emp;

-- join
select	empno, ename, e.deptno, dname
from		emp	e join dept d on e.deptno = d.deptno;

select	empno, ename, e.deptno, dname
from		emp	e join dept d on e.deptno = d.deptno;

select * from dept;
select * from emp;
