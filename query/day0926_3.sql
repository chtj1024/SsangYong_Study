--view ���� : ���� ���̺��� ����� ������ ���̺�
-- cp_emp5�� ����� �ܼ� view ����
create view emp_view as ( select * from cp_emp5);


-- ������ �������� view ������������ ���� �ο�.
grant create view to scott;

select * from dba_sys_privs
where grantee='SCOTT';

-- scott���� ����
create view emp_view as ( select * from cp_emp5);

-- user_view DD ���� Ȯ��
select * from user_views;

select * from user_objects;

-- ��ȸ
select * from emp_view;
--�ܼ� view DML����
insert into emp_view(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'����','����',1234,1400,70 );

select * from emp_view;

--
update  emp_view
set  		job='����'
where		empno=23;

--view ����
drop view emp_view;
select * from CP_EMP5;

--���պ�
create view emp_view as
( select empno, ename,job, hiredate, sal, sal*0.033 tax from cp_emp5);

select * from emp_view;

--error
insert into emp_view(EMPNO, ENAME, JOB, SAL, tax)
values( seq_empno.nextval,'���̽�','����',1400,70 );


--10���μ� 20���μ��� ����ϰ� �˻�
create view emp_view2 as ( select * from emp where deptno in (10,20));

select * from emp_view2;

--���պ�
--������ �����簡 �����롯,����ơ�, ��BMW��, ��AUDI�� �̰� �ɼǿ� ��ABS��,��TCS���� �ִ�
--������ ������, ������, �𵨸�,  ����, ����, �ɼ�, �̹���, ��ⷮ�� ��ȸ

--    ��, ����� ������������ �����ϰ�, ������ ���ٸ� ������ ������������ �����Ͽ� ���.
--     �̹����� �̹������ Ȯ���ڸ� �����Ͽ� ���.
--     ������� ù���ڸ� �빮�ڷ� ���.
create or replace view car_view as
(select 	cc.country, initcap(cc.maker) maker, cma.model, cmo.car_year, cmo.price,
				cmo.car_option,
				substr(cmo.car_img, 1 ,instr(cmo.car_img,'.')-1) img,
				substr(cmo.car_img,instr(cmo.car_img,'.')+1) ext,
				 cmo.cc
from 		car_country cc, car_maker cma, car_model cmo
where		( cma.maker=cc.maker and cmo.model=cma.model)
				and ( cma.maker in ('����','���','BMW','AUDI')
							and instr(cmo.car_option,'ABS') != 0
							and instr(cmo.car_option,'TCS') != 0 )
/*order by cmo.car_year desc, cmo.cc desc*/)with read only;

select * from car_view
order by car_year desc, cc desc;

select * from user_views;
-- create view ���� ȸ�� ��  view�� ������ �� �ִ�.
drop view car_view;

--scott�� create view ������ ȸ��

revoke create view from scott;
select * from dba_sys_privs
where grantee='SCOTT';


