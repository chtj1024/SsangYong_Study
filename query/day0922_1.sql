-- 문자열 자르기 substr(문자열, 시작인덱스, 자를글자수)
-- 자를 글자 수를 설정하지 않으면 끝까지 잘라준다.
select substr('ABCDEFG', 4, 3), substr('ABCDEFG', 2)
from dual;

insert into test_string(name, email) values ('테스트', 'aws@google.com');
insert into test_string(name, email) values ('테스트2', 'KT@google.com');
insert into test_string(name, email) values ('테스트3', 'lotte@google.com');
insert into test_string(name, email) values ('테스트4', 'lottegoogle.com');
commit;

select * from test_string;

--test_string테이블에서 이름, 메일주소, 도메인 주소를 조회
-- 메일 주소와 도메인 주소는 분리하여 조회 할 것.
select name, substr(email, 1, instr(email, '@') - 1) email_addr, substr(email, instr(email, '@') + 1) domain
from test_string;

-- 문자열의 앞, 뒤 공백만 제거 : trim()

select	'['|| trim('   A BC   ') || ']',
				'['|| ltrim('   A BC   ') || ']',
				'['|| rtrim('   A BC   ') || ']'
from		dual;

select	trim('a' from 'aaaaaOracleaaaaa')
from		dual;

--문자열 합치기 concat()
select	concat('ABC', 'DEF')
from		dual;

--사원테이블에서 사원명, 연봉을 검색
--단, 검색결과는 "사원명'님의연봉'xxxx"입니다.

select	concat(ename || '님의연봉', sal || '입니다.')
from		emp;

select	ename || '님의연봉' || sal || '입니다.'
from		emp;

--문자열에 앞에 특정문자 채우기

select	lpad('ABCDE', 10, '$'), lpad('ABCDE', 10, 0),
				lpad('ABCDE', 10, '#@'), lpad('ABCDE', 10, '가')
from		dual;

insert into test_number(num) values(123);
insert into test_number(num) values(2);
insert into test_number(num) values(348246);

-- test_number테이블에서 num컬럼에 값이 12자가 되지 않으면
-- 앞에 0을 채우고 SIST_를 붙여서 검색한다.
-- 출력예) SIST_00000000002

select num, 'SIST_' || lpad(num, 12, 0)
from		test_number;

select * from test_number;

select	replace('Oracle', 'a', 'AA'), replace('    A BC    ', ' ', '')
from		dual;

--decode : 조건함수
select decode('안녕', 'A', 100, 'B', 200, 'C', 300, 400)
from dual;

-- 부서테이블에서 부서번호, 부서명, 한글부서명 검색.
-- 단, 한글부서명은 부서번호에 따라 10번- SI개발 20번 - SM유지보수, 30번 - QA,
-- 그외는 관리부로 출력
select 	deptno, dname, decode(deptno, 10, 'SI개발', 20, 'SM유지보수', 30, 'QA', '관리부') hangul_name
from 		dept;

--사원 테이블에서 사원번호, 사원명, 연봉, 매니저번호, 매니저별 보너스
--를 조회하세요
-- 단, 매니저별 보너스는 7698 - 100원, 7839-150, 7566-200, 7788-300을
-- 책정하여 조회

select	empno, ename, sal, mgr, decode(mgr, 7698, 100, 7839, 150, 7566, 200, 7788, 300) mgr_bonus
from		emp;

select	empno, ename, sal, mgr,
				case mgr	when 7698 then sal
								  when 7839 then 150
								  when 7566 then 200
								  when 7788 then 300
								  else 400
				end mgr_comm
from emp;

-- 사원테이블에서 사원번호, 사원명, 연봉, 보너스, 부서별 특별보너스를 검색
-- 단, 특별보너스는 부서별로 차등지급.
-- 10-연봉과 보너스를 합산한 금액에 10%
-- 20-연봉과 보너스를 합산한 금액에 15%
-- 30-연봉과 보너스를 합산한 금액에 7%
-- 그외는 연봉 100%

select	empno, ename, sal, comm,
				case deptno	when 10 then (sal + nvl(comm, 0)) * 0.1
										when 20 then (sal + nvl(comm, 0)) * 0.15
										when 30 then (sal + nvl(comm, 0)) * 0.07
										else sal * 2
				end special_comm
from		emp;
