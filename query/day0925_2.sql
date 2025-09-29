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
-- 사원이 존재하는 부서에 검색
-- 사원번호, 사원명, 입사일, 부서번호, 부서명, 위치
select  empno, ename, hiredate, d.deptno, dname, loc
from		emp e left join dept d on e.deptno = d.deptno;

--컬럼이 어떤 테이블에 존재하는지 명확하게 알 수 있도록
--조회하는 컬럼앞에는 테이블명을 명시한다

--쿼리문이 길어지는 것을 짧게 쓰기위해서 테이블명에 alias를 부여

-- oracle 문법
select	e.empno, e.ename, e.hiredate, e.deptno, d.dname, d.loc
from		emp e, dept d;

-- 테이블 3개 조인
-- 보유중인 차량의 제조국, 제조사, 모델명, 가격, 연식, 옵션, 입력일 조회
-- ANSI
select	country, cc.maker, cmo.model, price, car_year, car_option, input_date
from		car_country cc
right join 		car_maker cma on cc.maker = cma.maker
right join 		car_model cmo on cma.model = cmo.model;

alter table car_model
rename column hiredate to input_date;

-- 사원이 존재하는 부서에 사원번호, 사원명, 연봉, 부서번호, 부서명,
-- 우편번호, 시도, 구군을 조회 (사원번호, seq를 join 조건)

select	empno, ename, sal, e.deptno, dname, zipcode, sido, gugun
from		emp e
join		zipcode z on e.empno = z.seq
join		dept d on d.deptno = e.deptno;

---- outer join ----
-- 모든 부서의 부서번호, 부서명, 위치, 사원번호, 사원명, 보너스 검색
select	d.deptno, dname, loc, empno, ename, sal, comm
from		dept d
left join		emp e on e.deptno = d.deptno;

--Oracle
select  d.deptno, e.deptno, dname, loc, empno, ename, sal, comm
from		dept d, emp e
where   e.deptno = d.deptno(+);
