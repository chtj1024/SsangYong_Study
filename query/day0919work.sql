-- ���� onenote Ȯ��
select empno, ename, hiredate, deptno, sal
from emp
where deptno != 10 and sal between 1000 and 3000;

select empno, ename, sal, comm, sal+nvl(comm, 0) - ((sal+nvl(comm, 0)) * 0.033) real_sal, round(sal/12, 2)
from emp;

select empno, ename, sal, ename || '(' || empno || ')' || '�� ���� ������' || sal || '�Դϴ�.' as output_message
from emp
where deptno in (10, 30)
order by sal;

create table test_like(
	student_id number(4),
	name varchar2(10),
	addr varchar2(50),
	school varchar2(5)
);

insert into test_like values(1, '�����', '����� ���۱� ��絿', '������');
insert into test_like values(2, '���ں�', '����� ���Ǳ� �Ÿ���', '������');
insert into test_like values(3, '���ھƺ�', '����� �߱� ��ȸ��', '������');
insert into test_like values(4, '�Ӽ���', '����� ������ ������', '��Ÿ��');
insert into test_like values(5, '�κ���', '����� ������ ������', '������');
insert into test_like values(5, '�κ�����', '������ ���뱸 ���뵿', '������');

select * from test_like;

select '��ȣ:'|| student_id || ', �̸�:' || name || ', ��Ű�:' || school || ', �ּ�:' || addr as output
from test_like
where addr like '�����%';

select empno, ename, sal, comm, hiredate, job
from emp
where length(ename) = 4 or sal >= 3000
order by hiredate desc, ename;

select empno, ename, hiredate, sal, sal + (sal*0.07) + nvl2(comm, 200, 300) as next_year_sal
from emp;

select empno, sal, job, mgr, hiredate
from emp
where ename like 'A%' and sal >= 1600
order by hiredate;
