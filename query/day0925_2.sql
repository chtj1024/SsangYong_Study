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
-- ����� �����ϴ� �μ��� �˻�
-- �����ȣ, �����, �Ի���, �μ���ȣ, �μ���, ��ġ
select  empno, ename, hiredate, d.deptno, dname, loc
from		emp e left join dept d on e.deptno = d.deptno;

--�÷��� � ���̺� �����ϴ��� ��Ȯ�ϰ� �� �� �ֵ���
--��ȸ�ϴ� �÷��տ��� ���̺���� ����Ѵ�

--�������� ������� ���� ª�� �������ؼ� ���̺�� alias�� �ο�

-- oracle ����
select	e.empno, e.ename, e.hiredate, e.deptno, d.dname, d.loc
from		emp e, dept d;

-- ���̺� 3�� ����
-- �������� ������ ������, ������, �𵨸�, ����, ����, �ɼ�, �Է��� ��ȸ
-- ANSI
select	country, cc.maker, cmo.model, price, car_year, car_option, input_date
from		car_country cc
right join 		car_maker cma on cc.maker = cma.maker
right join 		car_model cmo on cma.model = cmo.model;

alter table car_model
rename column hiredate to input_date;

-- ����� �����ϴ� �μ��� �����ȣ, �����, ����, �μ���ȣ, �μ���,
-- �����ȣ, �õ�, ������ ��ȸ (�����ȣ, seq�� join ����)

select	empno, ename, sal, e.deptno, dname, zipcode, sido, gugun
from		emp e
join		zipcode z on e.empno = z.seq
join		dept d on d.deptno = e.deptno;

---- outer join ----
-- ��� �μ��� �μ���ȣ, �μ���, ��ġ, �����ȣ, �����, ���ʽ� �˻�
select	d.deptno, dname, loc, empno, ename, sal, comm
from		dept d
left join		emp e on e.deptno = d.deptno;

--Oracle
select  d.deptno, e.deptno, dname, loc, empno, ename, sal, comm
from		dept d, emp e
where   e.deptno = d.deptno(+);
