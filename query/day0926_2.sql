--���� ���� ( ��������, ������ ���� �� �ο����� ���� )
--1.���� ����
select * from dba_users;

--2. ���� ��ȸ
--���ӱ���
 select * from dba_role_privs
 where grantee='SCOTT';

--������ ���� ����
 select * from dba_sys_privs
 where grantee='SCOTT';

 --���������� ������������ ���� ORACLE_SCRIPT�� ����ϵ��� ����
 alter session set "_ORACLE_SCRIPT"=true;


 --��������
 create user kws identified by 1234;

 select * from dba_users;

 select * from dba_role_privs
 where grantee='KWS';

 --���� �ο� ( DCL )
 grant connect, resource to kws;

 --���� ȸ��
revoke connect from kws;

--���̺� �����̽� ������
 alter user kws default tablespace users quota unlimited on users;

 select * from user_objects;

 --��������
 drop user kws; --��ü�� �ִ� ������ �������� �ʴ´�.

 drop user kws cascade;

 select * from dba_users;

 drop user c##scott;


 ---�ó��( scott����) -----------------------
 --  CP_EMP5���̺��� CE5�ε� ����ϰ� ����.
create synonym ce5 for cp_emp5;

--���Ѻο� ( �����ڰ����� ���� )
grant create synonym to scott;


select * from dba_role_privs
where grantee='SCOTT';

select * from dba_sys_privs
where grantee='SCOTT';

-- scott�������� ����
create synonym ce5 for cp_emp5;

select * from CP_EMP5;
--�ó�Ը����� �˻�
select * from CE5;

--�ó�Ը����� �߰�
insert into ce5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'����Ű','�κ�',1234,400,60 );

--�ó�� ����
drop synonym ce5;

select * from user_synonyms;

--������ �������� ���� > scott�� �ο��� �ó�� ���������� ȸ��.
revoke create synonym from scott;

select * from dba_sys_privs
where grantee='SCOTT';

