-- select subquery
-- 사원테이블에서 평균 연봉을 조회하여,
-- CP_EMP4테이블에 평균연봉 이상 수령하는 사원들의 사원번호, 사원명
-- 연봉, 입사일, 부서번호를 검색

select	empno, ename, sal, hiredate, deptno
from		cp_emp4
where sal >= (select trunc(avg(sal)) from emp);
--2264
select * from cp_emp4;


-- scalar subquery
-- 사원테이블에서 사원번호, 사원명, 부서번호, 부서명 검색
select * from dept;
--사원번호, 사원명, 부서번호는 EMP테이블에 존재
-- 부서번호, 부서명은 DEPT테이블에 존재.
select	empno, ename, deptno, (select dname from dept where emp.deptno = dept.deptno) dname
from		emp;

select * from CAR_MODEL;
select * from CAR_MAKER;
-- CAR_MODEL 테이블에서 제조사, 모델명, 년식, 가격 검색

select	(select MAKER from CAR_MAKER where CAR_MAKER.MODEL = CAR_MODEL.MODEL) maker,
				MODEL, CAR_YEAR, PRICE
from		CAR_MODEL;

--inline view에 존재하지 않는 컬럼은 사용할 수 없다.
--select 복수행 subquery : 조회결과를 사용한 재 조회
select	empno, ename, sal, hi
from (select	empno, ename, sal, hiredate hi
			from		emp);

--rownum
select rownum empno, ename, hiredate
from	emp;

--order by 절과 rownum을 함께 사용하면 rownum이 생성된 후 정렬을 수행
--하기 때문에 번호가 섞인다.
select		rownum, empno, ename, job
from			emp
order by	ename;

-- ADAMS 부터 1번의 번호를 부여하고 싶다. -> select 복수행 subquery
select	rownum, r, empno, ename, job
from(select		rownum r, empno, ename, job
			from			emp
			order by	ename);

-- 사원테이블에서 가장 최근에 입사한 이전 사원부터 5명의 사원만 검색
-- 검색컬럼 : 번호, 사원번호, 사원명, 입사일
select	rownum,  rn, empno, ename, hiredate
from	(select rownum rn, empno, ename, hiredate
			from	(select		rownum, empno, ename, hiredate
						from		  emp
						order by	hiredate desc))
where rn between 2 and 6;

--row_number() over()
select	rownum, rnum, empno, ename, hiredate
from		(select	empno, ename, hiredate, row_number() over(order by hiredate desc) rnum
				from		emp)
where		rnum between 2 and 6;

-- car_model테이블에서 배기량(cc)이 1500~3000사이 차량 중 입력일(hiredate)
-- 가장 오래된 데이터부터 6건의 차량 정보를 조회
-- 조회 컬럼은 번호, 모델명, 배기량, 가격, 차량 이미지명, 입력일

-- rownum
select	rownum, MODEL, CC, PRICE, CAR_IMG, hiredate
from		(select		rownum, MODEL, CC, PRICE, CAR_IMG, hiredate
				from			car_model
				where			rownum <= 6
				order by 	hiredate desc);

-- row_number() over()
select rn, MODEL, CC, PRICE, CAR_IMG, hiredate
from	(select	row_number() over(order by hiredate desc) rn, MODEL, CC, PRICE, CAR_IMG, hiredate
			from		car_model)
where rn <= 6;
