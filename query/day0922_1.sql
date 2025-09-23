-- ���ڿ� �ڸ��� substr(���ڿ�, �����ε���, �ڸ����ڼ�)
-- �ڸ� ���� ���� �������� ������ ������ �߶��ش�.
select substr('ABCDEFG', 4, 3), substr('ABCDEFG', 2)
from dual;

insert into test_string(name, email) values ('�׽�Ʈ', 'aws@google.com');
insert into test_string(name, email) values ('�׽�Ʈ2', 'KT@google.com');
insert into test_string(name, email) values ('�׽�Ʈ3', 'lotte@google.com');
insert into test_string(name, email) values ('�׽�Ʈ4', 'lottegoogle.com');
commit;

select * from test_string;

--test_string���̺��� �̸�, �����ּ�, ������ �ּҸ� ��ȸ
-- ���� �ּҿ� ������ �ּҴ� �и��Ͽ� ��ȸ �� ��.
select name, substr(email, 1, instr(email, '@') - 1) email_addr, substr(email, instr(email, '@') + 1) domain
from test_string;

-- ���ڿ��� ��, �� ���鸸 ���� : trim()

select	'['|| trim('   A BC   ') || ']',
				'['|| ltrim('   A BC   ') || ']',
				'['|| rtrim('   A BC   ') || ']'
from		dual;

select	trim('a' from 'aaaaaOracleaaaaa')
from		dual;

--���ڿ� ��ġ�� concat()
select	concat('ABC', 'DEF')
from		dual;

--������̺��� �����, ������ �˻�
--��, �˻������ "�����'���ǿ���'xxxx"�Դϴ�.

select	concat(ename || '���ǿ���', sal || '�Դϴ�.')
from		emp;

select	ename || '���ǿ���' || sal || '�Դϴ�.'
from		emp;

--���ڿ��� �տ� Ư������ ä���

select	lpad('ABCDE', 10, '$'), lpad('ABCDE', 10, 0),
				lpad('ABCDE', 10, '#@'), lpad('ABCDE', 10, '��')
from		dual;

insert into test_number(num) values(123);
insert into test_number(num) values(2);
insert into test_number(num) values(348246);

-- test_number���̺��� num�÷��� ���� 12�ڰ� ���� ������
-- �տ� 0�� ä��� SIST_�� �ٿ��� �˻��Ѵ�.
-- ��¿�) SIST_00000000002

select num, 'SIST_' || lpad(num, 12, 0)
from		test_number;

select * from test_number;

select	replace('Oracle', 'a', 'AA'), replace('    A BC    ', ' ', '')
from		dual;

--decode : �����Լ�
select decode('�ȳ�', 'A', 100, 'B', 200, 'C', 300, 400)
from dual;

-- �μ����̺��� �μ���ȣ, �μ���, �ѱۺμ��� �˻�.
-- ��, �ѱۺμ����� �μ���ȣ�� ���� 10��- SI���� 20�� - SM��������, 30�� - QA,
-- �׿ܴ� �����η� ���
select 	deptno, dname, decode(deptno, 10, 'SI����', 20, 'SM��������', 30, 'QA', '������') hangul_name
from 		dept;

--��� ���̺��� �����ȣ, �����, ����, �Ŵ�����ȣ, �Ŵ����� ���ʽ�
--�� ��ȸ�ϼ���
-- ��, �Ŵ����� ���ʽ��� 7698 - 100��, 7839-150, 7566-200, 7788-300��
-- å���Ͽ� ��ȸ

select	empno, ename, sal, mgr, decode(mgr, 7698, 100, 7839, 150, 7566, 200, 7788, 300) mgr_bonus
from		emp;

select	empno, ename, sal, mgr,
				case mgr	when 7698 then sal
								  when 7839 then 150
								  when 7566 then 200
								  when 7788 then 300
								  else 400
				end mgr_comm
from emp;

-- ������̺��� �����ȣ, �����, ����, ���ʽ�, �μ��� Ư�����ʽ��� �˻�
-- ��, Ư�����ʽ��� �μ����� ��������.
-- 10-������ ���ʽ��� �ջ��� �ݾ׿� 10%
-- 20-������ ���ʽ��� �ջ��� �ݾ׿� 15%
-- 30-������ ���ʽ��� �ջ��� �ݾ׿� 7%
-- �׿ܴ� ���� 100%

select	empno, ename, sal, comm,
				case deptno	when 10 then (sal + nvl(comm, 0)) * 0.1
										when 20 then (sal + nvl(comm, 0)) * 0.15
										when 30 then (sal + nvl(comm, 0)) * 0.07
										else sal * 2
				end special_comm
from		emp;
