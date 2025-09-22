--order by 절
--정렬

--사원 정보를 검색 사원번호, 사원명, 연봉, 입사일 검색
--단, 연봉에 오름차순 정렬하여 검색. 동일연봉이 있다면 사원번호의 내림차순정렬
select	empno, ename, sal, hiredate
from		emp
order by sal, empno desc;

--사원 테이블에서 사원번호, 사원명, 입사일을 검색.
--단, 가장 최근에 입사한 사원부터 검색할 것.

select empno, ename, hiredate
from emp
order by hiredate desc;

-- 사원테이블에서 사원번호, 사원명을 검색.
-- 단, 사원명의 오름차순으로 정렬하여 검색.

select empno, ename
from emp
order by ename;

--문자열 컬럼이 숫자를 가지고 있으면 자릿수에 대한 정렬을 수행
select *
from test_orderby
order by num;

select * from dept;

select * from user_procedures;

select * from dual;

create table dual(name varchar2(10), age number(3));
drop table dual;
select '나경원' name, 20 age, sysdate from dual;

select abs(2025), abs(-2025)
from dual;

select * from test_number;

insert into test_number(num) values(-2025);
commit;

--select 조회컬럼
select	abs(num)
from	test_number;

--insert, update에 값
insert into test_number(num) values(abs(-2025));
commit;

--where절
select num
from test_number
where num = 2025;

--round : 반올림
--양의 정수 : 소수부의 인덱스
select round(555.555, 2), round(555.554, 2), round(555.555), round(555.555, 0),
	round(555.555, -1), round(555.554, -2)
from dual;

--올림
select ceil(10.1), ceil(10.01), ceil(10.0)
from dual;

--절사
select	trunc(555.555, 2), trunc(555.555, 1),
			  trunc(555.555), trunc(555.555, 0),
			  trunc(555.555, -1), trunc(555.555, -2)
from dual;

-- 사원테이블에서 사원번호, 사원명, 입사일, 연봉, 세금을 검색.
-- 단, 세금은 원단위 절사(일의 자리 0으로)하여 검색

select * from emp;
select empno, ename, hiredate, sal, trunc(sal * (3.3 / 100), -1) 세금
from emp;

--내림 : floor
select floor(10.9), floor(10.1)
from dual;

--나눈 나머지 : mod(값, 나눌값)

select mod(10, 2), mod(9, 2)
from dual;

select * from test_string;
insert into test_string(name, email) values('무잔', 'oni@oni.com');
commit;

-- ssn이 null이면 '주민번호 없음'을 검색.
select name, email, nvl(ssn, '주민번호 없음')
from test_string;

select name, email, nvl(ssn, 123)
from test_string;

select name, email, nvl(ssn, sysdate)
from test_string;

--사원테이블에서 사원번호, 사원명, 직무, 매니저번호, 연봉, 보너스 검색
--단, 매니저가 없는 사원에게는 1111을 넣어 검색하고, 보너스가 없는 사원은
--100을 넣어 검색.
select * from emp;

select empno, ename, job, nvl(mgr, 1111), sal, nvl(comm, 100)
from emp;

--사원테이블에서 사원번호, 사원명, 연봉, 보너스, 총 수령액을 검색
--단, 보너스가 없는 사원들은 연봉에 100%로 설정해서 연산

select empno, ename, sal, nvl(comm, sal) comm, sal + nvl(comm, sal) 총수령액
from emp;

--nvl2

--사원테이블에서 사원번호, 사원명, 연봉, 보너스, 특별보너스를 검색
--단, 특별보너스 보너스가 있는 사원은 100을 보너스가 없는 사원은 200으로
--설정하여 검색
select empno, ename, sal, comm, nvl2(comm, 100, 200) 특별보너스
from emp;

--문자열 함수
--길이 : length
select length('Abc'), length('오늘은')
from dual;

--사원테이블에서 사원명이 4글자, 5글자 사이인 사원을 검색
--사원번호, 사원명, 입사일, 직무

select empno, ename, hiredate, job
from emp
where length(ename) >= 4 and length(ename) <= 5;

--대문자, 소문자 변환
select upper('AbcdEfg'), lower('AbcdEfg')
from dual;

--사원테이블에서 사원명이 'scott'인 사원의 사원번호, 사원명, 직무를 검색
--단, 직무는 모두 소문자로 검색 (scott을 소문자로 검색)

select empno, ename, lower(job)
from emp
where lower(ename) = 'scott';

--첫글자를 대문자로, 공백 이후에 문자열에도 적용이된다.
select	initcap('abcdef'), initcap('ABCDEF'),
				initcap('java oracle JDBC HTML')
from 		dual;

select	initcap(ename), initcap(job)
from		emp;

select	instr('ABCDEF', 'D'), instr('ABCDEF', 'DEF'),
				instr('자바와 자바스크립트', '자'),
				instr('자바와 자바스크립트', '자',
							instr('자바와 자바스크립트', '자')+1),
				instr('ABCDE', 'a')
from		dual;

--사원 테이블에서 사원명에 'A'가 있는 사원만 사원명을 검색

select ename, instr(ename, 'A')
from emp
where instr(ename, 'A') != 0;
