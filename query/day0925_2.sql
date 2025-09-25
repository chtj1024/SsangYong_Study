-- 테이블을 수직으로 결합하여 검색
select * from cp_emp;
-- 본사(emp)와 지사(cp_emp)의 모든 사원 정보를 검색
-- 사원번호, 사원명, 직무, 입사일 검색
-- union : 중복값이 출력되지 않는다.
select	empno, ename, job, hiredate
from		emp
union
select	empno, ename, job, hiredate
from		cp_emp;

-- union all - 중복값이 출력된다.
select	empno, ename, job, hiredate
from		emp
union		all
select	empno, ename, job, hiredate
from		cp_emp;

-- 컬럼명은 달라도 되고 데이터형, 개수는 반드시 같아야한다.
select	empno, ename, job, hiredate
from		emp
union		all
select	empno, job, ename, hiredate
from		cp_emp;

-- 컬럼의 개수가 다르면 error
select	empno, ename, job, hiredate
from		emp
union		all
select	empno, job, ename
from		cp_emp;

-- 컬럼의 데이터형이 다르면 error
select	empno, ename, job, hiredate
from		emp
union		all
select	job, empno, ename, hiredate
from		cp_emp;

-- join
select	empno, ename, e.deptno, dname
from		emp	e join dept d on e.deptno = d.deptno;

select	empno, ename, e.deptno, dname
from		emp	e join dept d on e.deptno = d.deptno;

select * from dept;
select * from emp;
