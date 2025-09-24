-- insert �ܼ��� subquery
-- CP_EMP4���̺� ���ڵ带 �߰�
-- �����ȣ : 1234, ����� : �ڻ���, ���� : ���
-- �Ŵ�����ȣ : �����ȣ�� 7788�� ����� ������ �Ŵ����� ����
-- �Ի��� : ���ú��� ������ ��
-- ���� : ������̺� ������� 'clark'�� ����� ������ �������� ����.
-- ���ʽ� : 0
-- �μ���ȣ : 10

insert into cp_emp4(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1234, '�ڻ���', '���', (select mgr from cp_emp4 where empno = 7788),
	sysdate + 7, (select sal from emp where ename = 'CLARK'), 0, 10);

update cp_emp4 set sal = 1000 where empno = 7782;

select * from cp_emp4;

--�ܼ��� �ڸ��� �������� �˻��Ǹ� error �߻�
insert into cp_emp4(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1234, '�ڻ���', '���', (select mgr from cp_emp4 where mgr = 7698),
	sysdate + 7, (select sal from emp where ename = 'CLARK'), 0, 10);

  -- CP_EMP4���̺� ���ڵ带 �߰�
-- �����ȣ : 1235, ����� : �����, ���� : �븮
-- �Ŵ�����ȣ : 7698,
-- �Ի��� : ����
-- ���� : ������̺��� �����ȣ�� 7654����� ������ ���ʽ��� �ջ��� �ݾ����� ����
-- ���ʽ� : 0
-- �μ���ȣ : 10

insert into cp_emp4(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1235, '�����', '�븮', 7698, sysdate,
	(select sal + nvl(comm, 0) from emp where empno = 7654), 0, 10);

select * from cp_emp4;

--insert ������ ��������
--emp���̺� 10���μ� ����� ��� ������ CP_EMP3���̺� �߰�.

--�÷���� ��ȸ �÷��� ����, ������ ���ٸ� insert�� �÷����Ǵ� ������ �� �ִ�.
insert into cp_emp3 (select * from emp where deptno = 10);

--������̺��� �μ���ȣ�� 20�� �μ��� �����ȣ, �����, ����, �Ի���
-- �μ���ȣ�� �˻��Ͽ� cp_emp3���̺� �߰�.

insert into cp_emp3(empno, ename, sal, hiredate, deptno)
(select	empno, ename, sal, hiredate, deptno
from		emp
where		deptno = 20);

--������̺��� �μ���ȣ�� 30�� �μ��� �����ȣ, �����, ����, ���ʽ�, �Ի���
-- �μ���ȣ�� �˻��Ͽ� cp_emp3���̺� �߰�.
-- ��, ���ʽ� 50, �Ի����� ���÷� �߰�
insert into cp_emp3(empno, ename, sal, comm, hiredate, deptno)
(select	empno, ename, sal, 50, sysdate, deptno
from		emp
where		deptno = 30);

select * from cp_emp3;

create table temp(deptno number, cnt number);
alter table temp add input_date date;

select * from temp;

-- ��������� �μ��� ������� temp���̺� �߰�
-- �߰� �� : �μ���ȣ, �����, �߰��ϴ� ����
insert into temp(deptno, cnt, input_date)
(select    deptno, count(*), sysdate
from			cp_emp3
group by	deptno);

select * from temp;

-- update subquery
-- cp_emp4 ���̺� �����ȣ�� 1235����� ������ emp ���̺� �����ȣ��
-- 7839����� �����ϰ� ����, ���ʽ� emp���̺� �����ȣ�� 7844�� �����
-- ������ ���ʽ��� ����

update	cp_emp4
set			sal = (select sal from emp where empno = 7839),
				comm = (select comm from emp where empno = 7844)
where		empno = 1235;

select * from cp_emp4;

--������ �������� : where������ in�� ����.
-- cp_emp ���̺��� 10�� �μ��� ��� ��ȣ ���� ��� ����� cp_emp4����
-- ã�� ���ʽ��� 500���� ����
update	cp_emp4
set			comm = 500
where		empno in (select empno from emp where deptno = 10);

select * from cp_emp4;

--delete subquery
-- cp_emp3���̺��� emp���̺� ������� scott�λ�� ���� �����ȣ��
-- ����ϴ� ��� ������ڵ带 ����.

delete from cp_emp3
where empno = (select	empno
								from		emp
								where		ename = 'SCOTT');

select * from cp_emp3;
