-- 문제 onenote 참고

--1
select		country, cma.maker, cmo.model, to_char(car_year, '9,999') car_year, to_char(price, '9,999') price,
					to_char(input_date, 'mm-dd-yyyy') input_date, cc, substr(car_option, 1, instr(car_option, ',') - 1) car_option
from			car_model cmo
join			car_maker cma on cmo.model = cma.model
join			car_country cc on cc.maker = cma.maker
where			cc between 1500 and 3000
order by	cc desc
offset 2 rows fetch next 4 rows only; -- 2행 건너 뛰고 그 다음 4행

--2
select 	e.empno, e.ename, e.hiredate, e.sal, rank() over (order by sal desc) rank_sal,
				dname, d.deptno, loc, substr(zipcode, instr(zipcode, '-') + 1) zipcode, sido, dong, nvl(bunji, '번지없음')
--from		(select		empno, ename, to_char(hiredate, 'q yyyy-mm-dd HH24') hiredate, sal, deptno,
--									row_number() over (order by sal desc) sal_rank
--					from		emp
--) e
from		emp e
join		dept d on e.deptno = d.deptno
join		zipcode z on e.empno = z.seq
where		d.deptno in (10, 20, 40)
order by	e.empno
offset 1 rows fetch next 4 rows only;

--3
select	cc.country, initcap(cma.maker), cmo.model, car_year, price, car_option,
				substr(car_img, 1, instr(car_img, '.') - 1) img_name,
				substr(car_img, instr(car_img, '.') + 1) img_extension,
				cc
from		car_model cmo
join		car_maker cma on cmo.model = cma.model
join		car_country cc on cc.maker = cma.maker
where		cma.maker in ('현대', '기아', 'BMW', 'AUDI') and
				car_option like '%ABS%' and car_option like '%TCS%'
order by car_year desc, price desc;


--4
select	row_number() over (order by cmo.price) || '번 ' || cmo.model || ' 차량의 년식은 ' || car_year || '이고, 제조국은 ' ||
				cc.country || ', 제조사는 ' || cma.maker || '입니다.' as info_str
from		car_model cmo
join		car_maker cma on cmo.model = cma.model
join		car_country cc on cc.maker = cma.maker
where		cmo.model in ('K5', '아반테', '소렌토', 'A8', 'SM3')
offset 1 rows fetch next 6 rows only;

--5
select  car_year, cmo.model, sum(price)
from		car_model cmo
join		car_maker cma on cmo.model = cma.model
join		car_country cc on cc.maker = cma.maker
where		cma.maker = '현대'
group by	car_year, cmo.model
order by car_year, cmo.model;

--6
select * from zipcode;
select * from dept;

select	empno, lower(ename) ename, hiredate, sal, (sal*0.033) duty,
				sal + trunc((sal / 12)) + nvl(comm, 0) -	(sal * 0.033) as real_sal,
				to_char(case 	e.deptno
									when 10 then sal * 0.07
									when 20 then sal * 0.04
									when 30	then (sal+nvl(comm, 0)) * 0.1
									else sal * 0.03
								end, '9,999') sal_increase,
				e.deptno, lower(dname) dname, lower(loc) loc, zipcode,
				sido, gugun, dong, bunji
from		emp e
join		dept d on e.deptno = d.deptno
join		zipcode z on z.seq = e.empno
where		ename like '%S' and
				length(ename) = 5 and
				ename like '__A%';
