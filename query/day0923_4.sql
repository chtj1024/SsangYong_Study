select  1
from		emp;

--subquery exists : 검색된 레코드가 있을 때에만 외부 쿼리를 실행.
-- 사원테이블에서 7788사원이 존재하는 경우에만 가장 마지막에 입사한 사원부터
-- 5명의 사원 정보를 검색.
-- 검색 컬럼 : 1번부터 순차번호, 실제번호, 사원번호, 사원명, 입사일, 연봉
select rownum, rn, empno, ename, hiredate, sal
from	(select	rownum rn, empno, ename, hiredate, sal
			from		(select    empno, ename, hiredate, sal
							from			emp
							where			exists( select 1 from emp where empno = 7788)
							order by	hiredate desc))
where		rn between 2 and 5;
