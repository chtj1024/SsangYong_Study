select  1
from		emp;

--subquery exists : �˻��� ���ڵ尡 ���� ������ �ܺ� ������ ����.
-- ������̺��� 7788����� �����ϴ� ��쿡�� ���� �������� �Ի��� �������
-- 5���� ��� ������ �˻�.
-- �˻� �÷� : 1������ ������ȣ, ������ȣ, �����ȣ, �����, �Ի���, ����
select rownum, rn, empno, ename, hiredate, sal
from	(select	rownum rn, empno, ename, hiredate, sal
			from		(select    empno, ename, hiredate, sal
							from			emp
							where			exists( select 1 from emp where empno = 7788)
							order by	hiredate desc))
where		rn between 2 and 5;
