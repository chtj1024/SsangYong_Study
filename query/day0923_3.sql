-- select subquery
-- ������̺��� ��� ������ ��ȸ�Ͽ�,
-- CP_EMP4���̺� ��տ��� �̻� �����ϴ� ������� �����ȣ, �����
-- ����, �Ի���, �μ���ȣ�� �˻�

select	empno, ename, sal, hiredate, deptno
from		cp_emp4
where sal >= (select trunc(avg(sal)) from emp);
--2264
select * from cp_emp4;


-- scalar subquery
-- ������̺��� �����ȣ, �����, �μ���ȣ, �μ��� �˻�
select * from dept;
--�����ȣ, �����, �μ���ȣ�� EMP���̺� ����
-- �μ���ȣ, �μ����� DEPT���̺� ����.
select	empno, ename, deptno, (select dname from dept where emp.deptno = dept.deptno) dname
from		emp;

select * from CAR_MODEL;
select * from CAR_MAKER;
-- CAR_MODEL ���̺��� ������, �𵨸�, ���, ���� �˻�

select	(select MAKER from CAR_MAKER where CAR_MAKER.MODEL = CAR_MODEL.MODEL) maker,
				MODEL, CAR_YEAR, PRICE
from		CAR_MODEL;

--inline view�� �������� �ʴ� �÷��� ����� �� ����.
--select ������ subquery : ��ȸ����� ����� �� ��ȸ
select	empno, ename, sal, hi
from (select	empno, ename, sal, hiredate hi
			from		emp);

--rownum
select rownum empno, ename, hiredate
from	emp;

--order by ���� rownum�� �Բ� ����ϸ� rownum�� ������ �� ������ ����
--�ϱ� ������ ��ȣ�� ���δ�.
select		rownum, empno, ename, job
from			emp
order by	ename;

-- ADAMS ���� 1���� ��ȣ�� �ο��ϰ� �ʹ�. -> select ������ subquery
select	rownum, r, empno, ename, job
from(select		rownum r, empno, ename, job
			from			emp
			order by	ename);

-- ������̺��� ���� �ֱٿ� �Ի��� ���� ������� 5���� ����� �˻�
-- �˻��÷� : ��ȣ, �����ȣ, �����, �Ի���
select	rownum,  rn, empno, ename, hiredate
from	(select rownum rn, empno, ename, hiredate
			from	(select		rownum, empno, ename, hiredate
						from		  emp
						order by	hiredate desc))
where rn between 2 and 6;

--row_number() over()
select	rownum, rnum, empno, ename, hiredate
from		(select	empno, ename, hiredate, row_number() over(order by hiredate desc) rnum
				from		emp)
where		rnum between 2 and 6;

-- car_model���̺��� ��ⷮ(cc)�� 1500~3000���� ���� �� �Է���(hiredate)
-- ���� ������ �����ͺ��� 6���� ���� ������ ��ȸ
-- ��ȸ �÷��� ��ȣ, �𵨸�, ��ⷮ, ����, ���� �̹�����, �Է���

-- rownum
select	rownum, MODEL, CC, PRICE, CAR_IMG, hiredate
from		(select		rownum, MODEL, CC, PRICE, CAR_IMG, hiredate
				from			car_model
				where			rownum <= 6
				order by 	hiredate desc);

-- row_number() over()
select rn, MODEL, CC, PRICE, CAR_IMG, hiredate
from	(select	row_number() over(order by hiredate desc) rn, MODEL, CC, PRICE, CAR_IMG, hiredate
			from		car_model)
where rn <= 6;
