select * from user_tables;

select * from employee;

-- 연봉, 급여, 보너스 모든 정보 조회
select e.emp_id, e.sal_code, sal, pay, pay_type, pay_id, name, dname, pname, pay_date
from    employee e
join    payroll p on e.emp_id = p.emp_id
join    salary  s on e.sal_code = s.sal_code
join    position po on e.pos_code = po.pos_code
join    department d on d.dept_code = e.dept_code
order by    e.emp_id;

-- 연봉 값 자체를 수정하기 위한
select e.emp_id, name, sal
from    employee e
join    salary  s on e.sal_code = s.sal_code;

-- 연봉코드가 있는 테이블만 조회
select  sal_code, sal
from    salary;

-- 해당사번의 사원의 연봉을 정보들을 select
select e.emp_id, name, e.sal_code, sal
from    employee e
join    salary  s on e.sal_code = s.sal_code;

-- 임시 업데이트
update employee
set    sal_code = 501
where  emp_id = 1001;

--해당 사번의 연봉코드를 변경
--update  employee e
--set     e.sal_code = ?
--where   e.emp_id = ?
--and     exists (
--    select  1
--    from    salary s
--    where   sal_code = ?
--);