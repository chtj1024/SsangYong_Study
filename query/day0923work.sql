-- 문제 설명 onenote참고
select	empno, ename, job, mgr, to_char(sal, '9,999,999') sal,
				nvl(comm, 100) comm, to_char(round(sal+nvl(comm, 100), 1), '0,000,000') real_sal, to_char(hiredate, 'mm-dd-yyyy') hiredate
from		emp;

create table work0923 (
	name		varchar2(30),
	age			number(3),
	rg_num	varchar2(30)
);

select * from work0923;

select	name, age, to_char(sysdate, 'yyyy') - age birth_year, rg_num,
				case
					when substr(rg_num, INSTR(rg_num, '-') + 1, 1) in (1, 3) then '남자'
					when substr(rg_num, INSTR(rg_num, '-') + 1, 1) in (2, 4) then '여자'
					when substr(rg_num, INSTR(rg_num, '-') + 1, 1) in (5, 6) then '외국인'
					else '오류'
				end as sex
from		work0923;

select	empno || '(사원번호)번 ' || initcap(ename) || '사원의 입사일은 ' ||
				to_char(hiredate, 'yyyy-mm-dd day q') || '분기 입니다.' ||
				'연봉은 $' || to_char(sal, '9,999,999') || '입니다.' as info
from		emp
where		to_char(hiredate, 'q') in (3, 4);

select * from cp_emp4;

update	cp_emp4
set     comm = (select	sal * 0.07
				from		emp
				where		empno = 7839)
where		empno in (7566, 7698, 7788);
