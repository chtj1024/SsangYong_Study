--�������� ����� rollback
select * from EMP;

insert into emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values(1111,'�����','���',7698,sysdate,3000,300,10);

commit;

insert into emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values(1112,'���ں�','����',7698,sysdate,4500,0,10);

update	emp
set			job='���', sal=3000
where		empno=1112;

rollback;

---������ ����
savepoint insert_a;

insert into emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values(1112,'���ں�','����',7698,sysdate,4500,0,10);

savepoint update_b;
update	emp
set			job='���', sal=3000
where		empno=1112;

savepoint delete_c;
delete from emp
where 	empno=1112;

--rollback to delete_c; --���� ��� : ���ں�,���, 3000
--rollback to update_b;  --������� : ���ں�,����, 4500
rollback to insert_a;    --�߰� ��� : ���ں� ���ڵ尡 ����
--rollback to delete_c;   --rollback�Ǹ� �ش� ��������  �������.

select * from EMP;

-----alias ���-------------------------------------------------
select	empno as emp_num, ename as emp_name, job emp_job, hiredate input_date
from 		emp;

--alias ���� �ٷ� ����Ǿ��ִ� where �������� ����� �� ����.

select	empno as emp_num, ename as emp_name, job emp_job, hiredate input_date
from 		emp
where		emp_num=1111;
;
-- where������ alias �� ���Ұ��ϰ�, ���� �÷����� ����ϸ�ȴ�.
select	empno as emp_num, ename as emp_name, job emp_job, hiredate input_date
from 		emp
where		empno=1111;

--alias�� ����� ��ҹ��� �����
select	empno as "EmpNo", ename as "Ename", job "JOb",
				hiredate "HireDate"
from 		emp;


--������̺��� ������� �����ȣ,�����,������ �˻�.
-- ��, �Ʒ��� ���� ���.
--  �����(xxxx��) ������� ������ $xxx �Դϴ�.

select		ename ||' ('|| empno ||'��) ������� ������ $'|| sal
					||'�Դϴ�' out_msg
from			emp;

SELECT EMPNO|| ENAME|| JOB|| MGR|| HIREDATE|| SAL|| COMM|| DEPTNO  output
FROM EMP;

--���������
-- ������̺��� �����ȣ,�����, ����,���ʽ�, �Ѽ��ɾ��� �˻�.
-- ��, �� ���ɾ��� ������ ���ʽ��� �ջ��� �ݾ����� �����Ͽ� �˻�.
-- null�� �÷��� ����Ǹ� ����� null�� ���´�.

select	empno, ename, sal, comm, sal+comm
from		emp;

--������̺��� �����ȣ,�����, �Ի���, ����, ����,�Ǽ��ɾ� �� �˻�.
--��, ������ ������ 3.3%�� �����Ͽ� �˻�.
-- �Ǽ��ɾ��� �������� ������ ������ �ݾ� alias�� real_sal
select  empno, ename, sal, sal * 0.033 tax
from		emp;

-- ���迬���� : ��ȸ�ϴ� �÷������»���� �� ����.
select   sal > 1000
from		emp;

--������̺��� ������ 3000�̸��� ������� �����ȣ,�����,����,�Ի��� �˻�.
select 	empno, ename, sal, hiredate
from 		emp
where  	sal < 3000;

-- ��� ���̺��� ������ 'SALESMAN'�� ������� �����ȣ, �����,
--�Ŵ�����ȣ, ����, ���ʽ�, �Ǽ��ɾ� ,���� ����  �˻�
-- ���� ������ ���ؿ����� 5%�� ������ �� �˻� ��
select	empno, ename, mgr, sal, comm , sal+comm real_sal, sal*1.05 next_sal
from  	emp
where		job='SALESMAN';


select * from EMP




