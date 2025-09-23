-- 문제설명은 onenote 참고
select	empno, ename, hiredate, to_char(sal, '00,000,000') || '$'
from		emp
order by sal desc, empno desc;

select	empno, initcap(ename) ename, job, to_char(hiredate, 'mm-dd-yy day') hiredate, sal, comm,
				nvl2(comm, sal+comm, round(sal+(sal/2) - ((sal+(sal/2)) * 0.033))) real_sal
from		emp
where		job in ('SALESMAN', 'CLERK', 'MANAGER');

select	lower(model), price, car_year, substr(car_option, 1, instr(car_option, ',', 1, 2)) car_option, car_img
from		car_model
where		model in ('K5', '아반테', 'A4', 'SM7') and car_option like '%ABS%'
order by price desc, car_year;

select	empno, ename, to_char(hiredate, 'yyyy-mm-dd q') || '분기' hiredate, round(months_between(sysdate, hiredate)) working_months
from		emp
where		to_char(hiredate, 'q') in (1, 2);
