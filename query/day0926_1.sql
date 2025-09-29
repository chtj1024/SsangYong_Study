-- ������̺��� ������� 'BLAKE'�� ������� ������ ���� �޴� �����
-- �����ȣ,�����, ����, �Ի����� ��ȸ.
select	empno, ename, sal, hiredate
from 		emp
where		sal > ( select sal from emp where ename='BLAKE' );

--self ���� : ��ȸ�� ���̺�� ���ǿ� ���̺��� �ĺ�.
select	search_emp.empno,search_emp.ename, search_emp.sal,
				 search_emp.hiredate /*, condition_emp.ename , condition_emp.empno*/
from 		emp search_emp, emp condition_emp
where   (search_emp.sal > condition_emp.sal) and condition_emp.ename='BLAKE';



select * from CP_EMP4;

--CP_EMP4���̺� �Ʒ��� �� �߰�
-- �����ȣ : ���� ������������� 1ū��ȣ
-- ����� :  ���ؿ�, ���� : ���, �Ŵ��� : 7698, �Ի��� : ����,
-- ���� 3100, ���ʽ� : 0, �μ���ȣ :30 ��


insert into cp_emp4(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values( (select max( empno)+1 from cp_emp4), '���ؿ�','���', 7698,
				sysdate+1, 3100, 0, 30 );
 commit;
select * from CP_EMP4;

select * from user_sequences;

---������ ���-----------------------
--���� : 1���� ���� 9999999���� 1�� �����ϴ� ������ ����
create sequence seq_test
increment by 1
start with 1
maxvalue 9999999;

select * from user_sequences;

-- �����ڼ��ǿ� �ε��� �������� ���� ��ȣ�� ���
select seq_test.currval from dual;

-- �������� ���� ��ȣ ���
select seq_test.nextval from dual;

--10~ 9999999999 ���� 10�� �����ϴ� ������ ��ü ����
-- �� ��ȣ���� ���� �ٽ� �ݺ��ǵ��� ����
create sequence seq_test2
increment by 10
start with 10
maxvalue 9999999999
cycle;


select * from user_sequences;

select seq_test2.nextval from dual;
-- currval�� nextval ���Ŀ� ���Ǿ���Ѵ�.��
select seq_test2.currval from dual;

--������ ����
drop sequence seq_test2;

-- emp���̺��� ������ �����Ͽ� cp_emp5���̺� ����
create table cp_emp5 as ( select * from emp where 1=0 );
select * from CP_EMP5;

--cp_emp5���̺� �����ȣ�� PK ����.
alter table cp_emp5 add constraint pk_cp_emp5 primary key ( empno );
--����� �Ի����� �����Ǹ� ���� �⵵�� �߰��ǵ��� ����
--����� ���ʽ��� �����Ǹ� 0 �߰��ǵ��� ����
alter table cp_emp5 modify hiredate date default sysdate;
alter table cp_emp5 modify comm number(7,2) default 0;

-- ��������� �߰� �ɶ����� �����ȣ�� 1�� �����ϵ��� ����� �ʹ�.
-- => ����������.
create sequence seq_empno
increment by 1
start with 1
maxvalue 99999999999999999
cache  30
nocycle;

select * from user_sequences;

--������� �߰�
insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'����','������',1234,3000,10 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'����','Į����',1234,3400,20 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'����','�Ҹ�ġ',1234,4400,30 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'����','����',1234,2400,40 );

-- �������� ������ �ִ� �������� �����ϸ� �ش� ��° ��ȣ�� �������.
insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'�õ�','��������',1234,2400,40 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'���','������',1234,5400,50 );

select * from cp_emp5;

select * from PRIMARY_MULTI;
--item_num�� ������  I_000001 �� �����̸鼭 �߰��� ������ 1�� �����ϴ�
--����

insert into primary_multi(ITEM_NUM, PRD_ID, ITEM_NAME  )
values( concat('I_',lpad(seq_empno.nextval,6,0)),'���̵�','�����۸�' );

select * from PRIMARY_MULTI;
