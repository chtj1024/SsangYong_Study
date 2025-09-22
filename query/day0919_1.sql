select name, addr
from test_like
where name like '____';

select name, addr
from test_like
where name like '임__';


select * from emp;
-- 사원 테이블에서 사원명이 'M' 또는 'K'로 시작하는 모든 사원의
-- 사원명, 사원번호, 매니저번호를 검색.

select ename, empno, mgr
from emp
where ename like 'M%' or ename like 'K%';

-- 사원 테이블에서 'R'이 두개가 들어 있는 사원의 사원명, 사원번호 검색
select ename, empno
from emp
where ename like '%R%R%';

select * from emp;

--외부데이터 추가하기
--데이터를 추가할 테이블을 생성

create table zipcode(
	zipcode char(6),
	sido char(6),
	gugun varchar2(25),
	dong varchar2(200),
	bunji varchar2(25),
	seq number(5)
);

select count(*) from zipcode;

truncate table zipcode;

select * from zipcode;
select	sido, gugun, dong
from	zipcode
where	sido = '인천' and gugun like '%남구%';

--group by
-- 사원테이블에서 직무 검색
select job, count(*)
from emp
group by job;

-- 중복값은 출력하지 않는다.

--주의 : group by 식에 나오지 않은 컬럼 (empno)이 함께 조회되면 error발생
select job, empno
from emp
group by job;

--사원테이블에서 10, 20번 부서의 직무, 부서번호를 검색
--단 부서별, 중복직무는 출력하지 않는다.
select job, deptno
from emp
--where deptno in (10, 20)
group by job, deptno
having	deptno in (10, 20);

--사원테이블에서 부서에 사원수가 4명을 초과하는 부서의 부서번호를 검색.
select count(deptno), deptno
from emp
group by deptno
having count(deptno) > 4;

--사원테이블에서 직무를 조회
--단, 중복직무는 조회하지 않는다.
select	distinct	job, empno
from	emp;

--distinct 여러컬럼에 사용하면 뒤에 컬럼을 기준으로 정렬하여 레코드를 보여준다.
select distinct job, mgr
from emp;

select * from user_indexes;
