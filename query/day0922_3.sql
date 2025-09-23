-- �׷캰 ���� ���
-- �μ��� ��� �� ���
select	deptno, count(*) || '��', sum(sal + nvl(comm, 0)),
				avg(sal), max(sal), min(sal)
from		emp
group by deptno
order by deptno;

--������̺��� �Ŵ�����, �Ŵ��� ��ȣ, �������, ����� ���� ���� �˻�
--��, �Ŵ����� �����ϴ� ����� �˻��� ��

select		mgr, count(*), sum(sal)
from			emp
where 		mgr is not null
group by	mgr;

--������̺��� ���� ���� ������ �޴� ������� ��ȸ.
select	ename, sal
from		emp
where		sal = (select max(sal) from emp);

-- ������̺��� �μ��� �ο���, ������ ��
select		deptno, count(*), sum(sal)
from			emp
group by	rollup(deptno);

select		deptno, count(*), sum(sal)
from			emp
group by	cube(deptno);

--������̺��� ������, ����, �����, ��������� �˻�
--�� ��ü�հ�(�Ұ��� ��)�� ���� ��� �� ������ �Ұ踦 ���
select	job, count(*), round(avg(sal), 0)
FROM		EMP
GROUP by cube(job);

--������̺��� �μ���, �Ŵ����� �����ϴ� ������� ������, ����� �˻�
--�μ��� �߰��հ�(�Ұ迡 ���� �հ�), ���� �������� �Ѱ踦 �˻�
--��, �Ŵ����� �����ϴ� ��ȸ

select		deptno, mgr, sum(sal), count(empno)
from			emp
where 		mgr is not null
group by rollup(deptno, mgr)
order by deptno;

--������̺��� �μ���, �Ŵ����� �����ϴ� ������� ������, ����� �˻�
--��, �Ѱ�� �μ��� �հ踦 ���� ��� �� ��, �μ��� �հ�, �Ұ踦 ���
--�Ŵ����� �����ϴ� ����� ���ؼ��� �˻�

select		deptno, mgr, sum(sal)
from			emp
where			mgr is not null
group by	cube(deptno, mgr);

-- ���� �Լ�
-- ������̺��� �����ȣ, �����, ����, ������ ����
-- ��, ������ ���� �������� ���� ��ȣ�� �ο��ϸ�
-- ���Ͽ����� �ߺ������� �ο��Ѵ�.
select	empno, ename, sal, rank() over(order by sal)
from		emp;

-- ���Ͽ����� �ߺ������� �ο����� �ʴ´�.
select	empno, ename, sal, row_number() over(order by sal)
from		emp;


-- ������̺��� �����ȣ, �����, �μ���ȣ, �μ���, ������ ���� �˻�.
-- ��, ������ ���� �������� ���� ��ȣ�� �ο��ϸ�
-- ���Ͽ����� �ߺ������� �ο����� �ʴ´�. (partition by�� ���)
select	empno, ename, deptno, sal, row_number() over(partition by deptno order by sal desc) sal_rank
from		emp;

--������̺��� �����ȣ, �����, �μ���ȣ, ����, ������, ������ ���� �˻�
--��, ������ ���� �������� ���� ��ȣ�� �ο��ϸ�,
-- ���Ͽ����� �ߺ������� �ο����� �ʴ´�.

select	empno, ename, deptno, job, sal, row_number() over(partition by job order by sal desc) sal_rank
from		emp;
