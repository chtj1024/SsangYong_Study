-- 그룹별 집계 얻기
-- 부서별 사원 수 얻기
select	deptno, count(*) || '명', sum(sal + nvl(comm, 0)),
				avg(sal), max(sal), min(sal)
from		emp
group by deptno
order by deptno;

--사원테이블에서 매니저별, 매니저 번호, 담당사원수, 사원의 연봉 합을 검색
--단, 매니저가 존재하는 사원만 검색할 것

select		mgr, count(*), sum(sal)
from			emp
where 		mgr is not null
group by	mgr;

--사원테이블에서 가장 많은 연봉을 받는 사원명을 조회.
select	ename, sal
from		emp
where		sal = (select max(sal) from emp);

-- 사원테이블에서 부서별 인원수, 연봉의 합
select		deptno, count(*), sum(sal)
from			emp
group by	rollup(deptno);

select		deptno, count(*), sum(sal)
from			emp
group by	cube(deptno);

--사원테이블에서 직무별, 직무, 사원수, 연봉평균을 검색
--단 전체합계(소계의 합)를 먼저 출력 후 직무별 소계를 출력
select	job, count(*), round(avg(sal), 0)
FROM		EMP
GROUP by cube(job);

--사원테이블에서 부서별, 매니저가 관리하는 사원들의 연봉합, 사원수 검색
--부서별 중간합계(소계에 대한 합계), 가장 마지막에 총계를 검색
--단, 매니저가 존재하는 조회

select		deptno, mgr, sum(sal), count(empno)
from			emp
where 		mgr is not null
group by rollup(deptno, mgr)
order by deptno;

--사원테이블에서 부서별, 매니저가 관리하는 사원들의 연봉합, 사원수 검색
--단, 총계와 부서별 합계를 먼저 출력 한 후, 부서별 합계, 소계를 출력
--매니저가 존재하는 사원에 대해서만 검색

select		deptno, mgr, sum(sal)
from			emp
where			mgr is not null
group by	cube(deptno, mgr);

-- 순위 함수
-- 사원테이블에서 사원번호, 사원명, 연봉, 연봉의 순위
-- 단, 연봉은 낮은 순위부터 작은 번호를 부여하며
-- 동일연봉은 중복순위를 부여한다.
select	empno, ename, sal, rank() over(order by sal)
from		emp;

-- 동일연봉은 중복순위를 부여하지 않는다.
select	empno, ename, sal, row_number() over(order by sal)
from		emp;


-- 사원테이블에서 사원번호, 사원명, 부서번호, 부서별, 연봉의 순위 검색.
-- 단, 연봉은 높은 순위부터 작은 번호를 부여하며
-- 동일연봉은 중복순위를 부여하지 않는다. (partition by를 사용)
select	empno, ename, deptno, sal, row_number() over(partition by deptno order by sal desc) sal_rank
from		emp;

--사원테이블에서 사원번호, 사원명, 부서번호, 연봉, 직무별, 연봉의 순위 검색
--단, 연봉의 높은 순위부터 작은 번호를 부여하며,
-- 동일연봉은 중복순위를 부여하지 않는다.

select	empno, ename, deptno, job, sal, row_number() over(partition by job order by sal desc) sal_rank
from		emp;
