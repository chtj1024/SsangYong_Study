-- 제약사항을 확인할 수 있는 DD : user_constraints
select * from user_constraints;

-- DD는 개발자가 insert, update, delete를 직접할 수 없다.
update	user_constraints
set			CONSTRAINT_NAME = 'ENAME_NOTNULL'
where		TABLE_NAME = 'EMP' and CONSTRAINT_TYPE = 'C';

--create subquery
--dept 테이블의 모든컬럼명, 데이터형, 크기, 레코드를 복사하여
--CP_DEPT 테이블을 생성.

select * from user_constraints
where table_name = 'DEPT';

create table cp_dept as (select * from dept);

--제약사항이 설정된 원본테이블에 추가
insert into dept(deptno, dname, loc)
values(10, '개발부', '서울');

insert into cp_dept(deptno, dname, loc)
values(10, '개발부', '서울');

select * from cp_dept;

--dept 테이블의 부서번호 부서명의 컬럼명, 데이터형, 크기, 레코드를
-- 복사하여 cp_dept2 테이블을 생성.
create table	cp_dept2 as
(select	deptno, dname
from		dept);

select * from cp_dept2;

select * from user_constraints;

--emp테이블에서 사원번호, 사원명, 직무, 입사일의
--컬럼명, 데이터형, 크기를 복사하여 CP_EMP 테이블을 생성
create table cp_emp as
(select	empno, ename, job, hiredate
from		emp); -- 나는 이미 만들어져있어서 지우고 다시만듬

select * from user_constraints
where table_name in ('EMP', 'CP_EMP');

insert into cp_emp(empno, ename, job, hiredate)
values(7934, '나경원', '사원', sysdate);

select * from cp_emp;

--복사된 제약사항 (not null) 체크
insert into cp_emp(empno, ename, job, hiredate)
values(7934, '', '사원', sysdate);

insert into cp_emp(empno, job, hiredate)
values(7934, '사원', sysdate);

-- 사원테이블에 10, 30번 부서사원들의 사원번호, 사원명, 부서번호,
-- 매니저번호, 입사일을 검색하여 cp_Emp2테이블을 생성.

create table cp_emp2 as
(select	empno, ename, deptno, mgr, hiredate
from		emp
where		deptno in (10, 30));

select * from cp_emp2;

--사원테이블 사원번호, 사원명, 직무, 매니저번호, 입사일, 연봉, 보너스
-- 부서번호의 구조만 (레코드 x) 복사하여 cp_emp3테이블을 생성

create table cp_emp3 as
(select	*
from		emp
where		1 = 0);

select * from cp_emp3;

create table cp_emp4 as (select * from emp);
