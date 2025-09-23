--��ȯ �Լ�
-- to_char, to_date, to_number

--���ں�ȯ
-- ���� -> ����
-- 0 : pattern

select	to_char(2025, '0,000,000'), to_char(2025.09, '0,000,000.0000')
from		dual;

-- 9 : pattern
select	trim(to_char(2025, '9,999,999')), to_char(2025.09, '9,999,999,99')
from		dual;

--�����Ͱ� ���Ϻ��� ũ�ٸ� ��� @���θ� ���´�.
select	to_char(123456, '9,999'), to_char(123456, '0,000')
from		dual;

select sysdate
from dual;

--��¥��ȯ
select	sysdate, to_char(sysdate, 'yyyy-"��"-mm-dd am hh(hh12, hh24):mi')
from		dual;

--��¥������ ��� error�߻�
select	to_char(sysdate, 'yyyy " ��" mm "��" dd " �� " q " �б� " ') ||
				to_char(sysdate, ' am hh24 " �� " mi " �� "')
from		dual;

--��� ���̺��� �����ȣ, �����, �Ի��� ��ȸ
-- ��, �Ի����� ��-��-�� �б� ������ �������� ��ȸ.

select	empno, ename, to_char(hiredate, 'mm-dd-yyyy q"�б�" day')
from		emp;

-- ��� ���̺��� 1987�⿡ �Ի��� ������� �����ȣ, �����, ����, �Ի��� ��ȸ
select	empno, ename, sal, hiredate
from		emp
where '1987' = to_char(hiredate, 'yyyy');

--��¥��ȯ
select	'2025-09-23', to_date('2025-09-23', 'yyyy-mm-dd')
from		dual;

insert into test_date(hiredate, hiredate2)
values('2025-09-23', '2025-09-23');

insert into test_date(hiredate, hiredate2)
values(to_date('2025-09-23', 'yyyy-mm-dd'), to_date('2025-09-23', 'yyyy-mm-dd'));

select	*
from		test_date;

-- where���� ��¥�� ���ϸ� Windows�� error�� �߻����� ������
-- linux�� �����ϸ� error�� �߻��Ѵ�.
-- (��¥�� ���ڿ��� ���� ��)

-- ������̺��� �Ի����� 1981��1�� ~ 9�� ���̿� �Ի��� �������
-- �����ȣ, �����, �Ի���, ���� �˻�
select	empno, ename, hiredate, sal
from		emp
--where		to_char(hiredate, 'yyyy') = '1981' and
--				to_char(hiredate, 'mm') between 1 and 9;
where		hiredate >= to_date('198101', 'yyyymm')
				and hiredate <= to_date('198109', 'yyyymm');

select	'2025', '9', '2025' + '9', to_number('2025')+to_number('9')
from		dual;

--�����Լ�
--count : Ư���÷��� ���ڵ��� ������ ���� ��. (null�� ���迡 ����x)
select	count(empno), count(mgr)
from		emp;

-- ������̺��� ���ʽ��� �����ϴ� �����, ���ʽ��� �������� �ʴ�
-- ��� �� �˻�.

select count(comm), count(decode(comm, null, 1))
from		emp;

select *
from		emp;

--������ : �÷� ���� ��
--������̺��� ������ ��
select	sum(sal), trunc(avg(sal), 2), max(sal), min(sal)
from		emp;
