--변환 함수
-- to_char, to_date, to_number

--문자변환
-- 숫자 -> 문자
-- 0 : pattern

select	to_char(2025, '0,000,000'), to_char(2025.09, '0,000,000.0000')
from		dual;

-- 9 : pattern
select	trim(to_char(2025, '9,999,999')), to_char(2025.09, '9,999,999,99')
from		dual;

--데이터가 패턴보다 크다면 결과 @으로만 나온다.
select	to_char(123456, '9,999'), to_char(123456, '0,000')
from		dual;

select sysdate
from dual;

--날짜변환
select	sysdate, to_char(sysdate, 'yyyy-"년"-mm-dd am hh(hh12, hh24):mi')
from		dual;

--날짜패턴이 길면 error발생
select	to_char(sysdate, 'yyyy " 년" mm "월" dd " 일 " q " 분기 " ') ||
				to_char(sysdate, ' am hh24 " 시 " mi " 분 "')
from		dual;

--사원 테이블에서 사원번호, 사원명, 입사일 조회
-- 단, 입사일은 월-일-년 분기 요일의 형식으로 조회.

select	empno, ename, to_char(hiredate, 'mm-dd-yyyy q"분기" day')
from		emp;

-- 사원 테이블에서 1987년에 입사한 사원들의 사원번호, 사원명, 연봉, 입사일 조회
select	empno, ename, sal, hiredate
from		emp
where '1987' = to_char(hiredate, 'yyyy');

--날짜변환
select	'2025-09-23', to_date('2025-09-23', 'yyyy-mm-dd')
from		dual;

insert into test_date(hiredate, hiredate2)
values('2025-09-23', '2025-09-23');

insert into test_date(hiredate, hiredate2)
values(to_date('2025-09-23', 'yyyy-mm-dd'), to_date('2025-09-23', 'yyyy-mm-dd'));

select	*
from		test_date;

-- where절에 날짜를 비교하면 Windows는 error가 발생하지 않지만
-- linux로 배포하면 error가 발생한다.
-- (날짜와 문자열을 비교할 때)

-- 사원테이블에서 입사일이 1981년1월 ~ 9월 사이에 입사한 사원들의
-- 사원번호, 사원명, 입사일, 연봉 검색
select	empno, ename, hiredate, sal
from		emp
--where		to_char(hiredate, 'yyyy') = '1981' and
--				to_char(hiredate, 'mm') between 1 and 9;
where		hiredate >= to_date('198101', 'yyyymm')
				and hiredate <= to_date('198109', 'yyyymm');

select	'2025', '9', '2025' + '9', to_number('2025')+to_number('9')
from		dual;

--집계함수
--count : 특정컬럼에 레코드의 개수를 얻을 때. (null은 집계에 포함x)
select	count(empno), count(mgr)
from		emp;

-- 사원테이블에서 보너스를 수령하는 사원수, 보너스를 수령하지 않는
-- 사원 수 검색.

select count(comm), count(decode(comm, null, 1))
from		emp;

select *
from		emp;

--누적합 : 컬럼 값의 합
--사원테이블에서 연봉의 합
select	sum(sal), trunc(avg(sal), 2), max(sal), min(sal)
from		emp;
