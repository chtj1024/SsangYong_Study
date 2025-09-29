--계정 생성 ( 관리계정, 관리자 권한 을 부여받은 계정 )
--1.계정 존재
select * from dba_users;

--2. 권한 조회
--접속권한
 select * from dba_role_privs
 where grantee='SCOTT';

--쿼리문 생성 권한
 select * from dba_sys_privs
 where grantee='SCOTT';

 --이전버전의 계정형식으로 생성 ORACLE_SCRIPT를 사용하도록 변경
 alter session set "_ORACLE_SCRIPT"=true;


 --계정생성
 create user kws identified by 1234;

 select * from dba_users;

 select * from dba_role_privs
 where grantee='KWS';

 --권한 부여 ( DCL )
 grant connect, resource to kws;

 --권한 회수
revoke connect from kws;

--테이블 스페이스 사용권한
 alter user kws default tablespace users quota unlimited on users;

 select * from user_objects;

 --계정삭제
 drop user kws; --객체가 있는 계정은 삭제되지 않는다.

 drop user kws cascade;

 select * from dba_users;

 drop user c##scott;


 ---시노님( scott계정) -----------------------
 --  CP_EMP5테이블을 CE5로도 사용하고 싶음.
create synonym ce5 for cp_emp5;

--권한부여 ( 관리자계정만 가능 )
grant create synonym to scott;


select * from dba_role_privs
where grantee='SCOTT';

select * from dba_sys_privs
where grantee='SCOTT';

-- scott계정으로 접속
create synonym ce5 for cp_emp5;

select * from CP_EMP5;
--시노님명으로 검색
select * from CE5;

--시노님명으로 추가
insert into ce5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'프랑키','로봇',1234,400,60 );

--시노님 삭제
drop synonym ce5;

select * from user_synonyms;

--관리자 권한으로 접속 > scott에 부여된 시노님 생성권한을 회수.
revoke create synonym from scott;

select * from dba_sys_privs
where grantee='SCOTT';

