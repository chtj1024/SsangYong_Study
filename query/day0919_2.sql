--order by ��
--����

--��� ������ �˻� �����ȣ, �����, ����, �Ի��� �˻�
--��, ������ �������� �����Ͽ� �˻�. ���Ͽ����� �ִٸ� �����ȣ�� ������������
select	empno, ename, sal, hiredate
from		emp
order by sal, empno desc;

--��� ���̺��� �����ȣ, �����, �Ի����� �˻�.
--��, ���� �ֱٿ� �Ի��� ������� �˻��� ��.

select empno, ename, hiredate
from emp
order by hiredate desc;

-- ������̺��� �����ȣ, ������� �˻�.
-- ��, ������� ������������ �����Ͽ� �˻�.

select empno, ename
from emp
order by ename;

--���ڿ� �÷��� ���ڸ� ������ ������ �ڸ����� ���� ������ ����
select *
from test_orderby
order by num;

select * from dept;

select * from user_procedures;

select * from dual;

create table dual(name varchar2(10), age number(3));
drop table dual;
select '�����' name, 20 age, sysdate from dual;

select abs(2025), abs(-2025)
from dual;

select * from test_number;

insert into test_number(num) values(-2025);
commit;

--select ��ȸ�÷�
select	abs(num)
from	test_number;

--insert, update�� ��
insert into test_number(num) values(abs(-2025));
commit;

--where��
select num
from test_number
where num = 2025;

--round : �ݿø�
--���� ���� : �Ҽ����� �ε���
select round(555.555, 2), round(555.554, 2), round(555.555), round(555.555, 0),
	round(555.555, -1), round(555.554, -2)
from dual;

--�ø�
select ceil(10.1), ceil(10.01), ceil(10.0)
from dual;

--����
select	trunc(555.555, 2), trunc(555.555, 1),
			  trunc(555.555), trunc(555.555, 0),
			  trunc(555.555, -1), trunc(555.555, -2)
from dual;

-- ������̺��� �����ȣ, �����, �Ի���, ����, ������ �˻�.
-- ��, ������ ������ ����(���� �ڸ� 0����)�Ͽ� �˻�

select * from emp;
select empno, ename, hiredate, sal, trunc(sal * (3.3 / 100), -1) ����
from emp;

--���� : floor
select floor(10.9), floor(10.1)
from dual;

--���� ������ : mod(��, ������)

select mod(10, 2), mod(9, 2)
from dual;

select * from test_string;
insert into test_string(name, email) values('����', 'oni@oni.com');
commit;

-- ssn�� null�̸� '�ֹι�ȣ ����'�� �˻�.
select name, email, nvl(ssn, '�ֹι�ȣ ����')
from test_string;

select name, email, nvl(ssn, 123)
from test_string;

select name, email, nvl(ssn, sysdate)
from test_string;

--������̺��� �����ȣ, �����, ����, �Ŵ�����ȣ, ����, ���ʽ� �˻�
--��, �Ŵ����� ���� ������Դ� 1111�� �־� �˻��ϰ�, ���ʽ��� ���� �����
--100�� �־� �˻�.
select * from emp;

select empno, ename, job, nvl(mgr, 1111), sal, nvl(comm, 100)
from emp;

--������̺��� �����ȣ, �����, ����, ���ʽ�, �� ���ɾ��� �˻�
--��, ���ʽ��� ���� ������� ������ 100%�� �����ؼ� ����

select empno, ename, sal, nvl(comm, sal) comm, sal + nvl(comm, sal) �Ѽ��ɾ�
from emp;

--nvl2

--������̺��� �����ȣ, �����, ����, ���ʽ�, Ư�����ʽ��� �˻�
--��, Ư�����ʽ� ���ʽ��� �ִ� ����� 100�� ���ʽ��� ���� ����� 200����
--�����Ͽ� �˻�
select empno, ename, sal, comm, nvl2(comm, 100, 200) Ư�����ʽ�
from emp;

--���ڿ� �Լ�
--���� : length
select length('Abc'), length('������')
from dual;

--������̺��� ������� 4����, 5���� ������ ����� �˻�
--�����ȣ, �����, �Ի���, ����

select empno, ename, hiredate, job
from emp
where length(ename) >= 4 and length(ename) <= 5;

--�빮��, �ҹ��� ��ȯ
select upper('AbcdEfg'), lower('AbcdEfg')
from dual;

--������̺��� ������� 'scott'�� ����� �����ȣ, �����, ������ �˻�
--��, ������ ��� �ҹ��ڷ� �˻� (scott�� �ҹ��ڷ� �˻�)

select empno, ename, lower(job)
from emp
where lower(ename) = 'scott';

--ù���ڸ� �빮�ڷ�, ���� ���Ŀ� ���ڿ����� �����̵ȴ�.
select	initcap('abcdef'), initcap('ABCDEF'),
				initcap('java oracle JDBC HTML')
from 		dual;

select	initcap(ename), initcap(job)
from		emp;

select	instr('ABCDEF', 'D'), instr('ABCDEF', 'DEF'),
				instr('�ڹٿ� �ڹٽ�ũ��Ʈ', '��'),
				instr('�ڹٿ� �ڹٽ�ũ��Ʈ', '��',
							instr('�ڹٿ� �ڹٽ�ũ��Ʈ', '��')+1),
				instr('ABCDE', 'a')
from		dual;

--��� ���̺��� ����� 'A'�� �ִ� ����� ������� �˻�

select ename, instr(ename, 'A')
from emp
where instr(ename, 'A') != 0;
