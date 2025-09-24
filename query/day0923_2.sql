-- insert 단수형 subquery
-- CP_EMP4테이블에 레코드를 추가
-- 사원번호 : 1234, 사원명 : 박상현, 직무 : 사원
-- 매니저번호 : 사원번호가 7788인 사원과 동일한 매니저로 설정
-- 입사일 : 오늘부터 일주일 후
-- 연봉 : 사원테이블에 사원명이 'clark'인 사원과 동일한 연봉으로 설정.
-- 보너스 : 0
-- 부서번호 : 10

insert into cp_emp4(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1234, '박상현', '사원', (select mgr from cp_emp4 where empno = 7788),
	sysdate + 7, (select sal from emp where ename = 'CLARK'), 0, 10);

update cp_emp4 set sal = 1000 where empno = 7782;

select * from cp_emp4;

--단수행 자리에 여러행이 검색되면 error 발생
insert into cp_emp4(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1234, '박상현', '사원', (select mgr from cp_emp4 where mgr = 7698),
	sysdate + 7, (select sal from emp where ename = 'CLARK'), 0, 10);

  -- CP_EMP4테이블에 레코드를 추가
-- 사원번호 : 1235, 사원명 : 나경원, 직무 : 대리
-- 매니저번호 : 7698,
-- 입사일 : 오늘
-- 연봉 : 사원테이블에서 사원번호가 7654사원의 연봉과 보너스를 합산한 금액으로 설정
-- 보너스 : 0
-- 부서번호 : 10

insert into cp_emp4(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1235, '나경원', '대리', 7698, sysdate,
	(select sal + nvl(comm, 0) from emp where empno = 7654), 0, 10);

select * from cp_emp4;

--insert 복수행 서브쿼리
--emp테이블에 10번부서 사원의 모든 정보를 CP_EMP3테이블에 추가.

--컬럼명과 조회 컬럼의 개수, 순서가 같다면 insert에 컬럼정의는 생략할 수 있다.
insert into cp_emp3 (select * from emp where deptno = 10);

--사원테이블에서 부서번호가 20번 부서의 사원번호, 사원명, 연봉, 입사일
-- 부서번호를 검색하여 cp_emp3테이블에 추가.

insert into cp_emp3(empno, ename, sal, hiredate, deptno)
(select	empno, ename, sal, hiredate, deptno
from		emp
where		deptno = 20);

--사원테이블에서 부서번호가 30번 부서의 사원번호, 사원명, 연봉, 보너스, 입사일
-- 부서번호를 검색하여 cp_emp3테이블에 추가.
-- 단, 보너스 50, 입사일은 오늘로 추가
insert into cp_emp3(empno, ename, sal, comm, hiredate, deptno)
(select	empno, ename, sal, 50, sysdate, deptno
from		emp
where		deptno = 30);

select * from cp_emp3;

create table temp(deptno number, cnt number);
alter table temp add input_date date;

select * from temp;

-- 현재까지의 부서별 사원수를 temp테이블에 추가
-- 추가 값 : 부서번호, 사원수, 추가하는 일자
insert into temp(deptno, cnt, input_date)
(select    deptno, count(*), sysdate
from			cp_emp3
group by	deptno);

select * from temp;

-- update subquery
-- cp_emp4 테이블에 사원번호가 1235사원의 연봉을 emp 테이블에 사원번호가
-- 7839사원과 동일하게 변경, 보너스 emp테이블에 사원번호가 7844인 사원과
-- 동일한 보너스로 변경

update	cp_emp4
set			sal = (select sal from emp where empno = 7839),
				comm = (select comm from emp where empno = 7844)
where		empno = 1235;

select * from cp_emp4;

--복수행 서브쿼리 : where절에서 in만 가능.
-- cp_emp 테이블에서 10번 부서의 사원 번호 같은 모든 사원을 cp_emp4에서
-- 찾고 보너스를 500으로 설정
update	cp_emp4
set			comm = 500
where		empno in (select empno from emp where deptno = 10);

select * from cp_emp4;

--delete subquery
-- cp_emp3테이블에서 emp테이블에 사원명이 scott인사원 같은 사원번호를
-- 사용하는 모든 사원레코드를 삭제.

delete from cp_emp3
where empno = (select	empno
								from		emp
								where		ename = 'SCOTT');

select * from cp_emp3;
