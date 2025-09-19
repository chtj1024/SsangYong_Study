--저장점을 사용한 rollback
select * from EMP;

insert into emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values(1111,'나경원','사원',7698,sysdate,3000,300,10);

commit;

insert into emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values(1112,'윤자빈','바지',7698,sysdate,4500,0,10);

update	emp
set			job='사원', sal=3000
where		empno=1112;

rollback;

---저장점 설정
savepoint insert_a;

insert into emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values(1112,'윤자빈','바지',7698,sysdate,4500,0,10);

savepoint update_b;
update	emp
set			job='사원', sal=3000
where		empno=1112;

savepoint delete_c;
delete from emp
where 	empno=1112;

--rollback to delete_c; --삭제 취소 : 윤자빈,사원, 3000
--rollback to update_b;  --변경취소 : 윤자빈,바지, 4500
rollback to insert_a;    --추가 취소 : 윤자빈 레코드가 없음
--rollback to delete_c;   --rollback되면 해당 저장점은  사라진다.

select * from EMP;

-----alias 사용-------------------------------------------------
select	empno as emp_num, ename as emp_name, job emp_job, hiredate input_date
from 		emp;

--alias 명은 바로 연결되어있는 where 절에서는 사용할 수 없다.

select	empno as emp_num, ename as emp_name, job emp_job, hiredate input_date
from 		emp
where		emp_num=1111;
;
-- where절에서 alias 는 사용불가하고, 원래 컬럼명을 사용하면된다.
select	empno as emp_num, ename as emp_name, job emp_job, hiredate input_date
from 		emp
where		empno=1111;

--alias를 사용한 대소문자 만들기
select	empno as "EmpNo", ename as "Ename", job "JOb",
				hiredate "HireDate"
from 		emp;


--사원테이블에서 모든사원의 사원번호,사원명,연봉을 검색.
-- 단, 아래와 같이 출력.
--  사원명(xxxx번) 사원님의 연봉은 $xxx 입니다.

select		ename ||' ('|| empno ||'번) 사원님의 연봉은 $'|| sal
					||'입니다' out_msg
from			emp;

SELECT EMPNO|| ENAME|| JOB|| MGR|| HIREDATE|| SAL|| COMM|| DEPTNO  output
FROM EMP;

--산술연산자
-- 사원테이블에서 사원번호,사원명, 연봉,보너스, 총수령액을 검색.
-- 단, 총 수령액은 연봉과 보너스를 합산한 금액으로 연산하여 검색.
-- null인 컬럼이 연산되면 결과가 null로 나온다.

select	empno, ename, sal, comm, sal+comm
from		emp;

--사원테이블에서 사원번호,사원명, 입사일, 연봉, 세금,실수령액 을 검색.
--단, 세금은 연봉에 3.3%로 연산하여 검색.
-- 실수령액은 연봉에서 세금을 제외한 금액 alias는 real_sal
select  empno, ename, sal, sal * 0.033 tax
from		emp;

-- 관계연산자 : 조회하는 컬럼에서는사용할 수 없다.
select   sal > 1000
from		emp;

--사원테이블에서 연봉이 3000미만인 사원들의 사원번호,사원명,연봉,입사일 검색.
select 	empno, ename, sal, hiredate
from 		emp
where  	sal < 3000;

-- 사원 테이블에서 직무가 'SALESMAN'인 사원들의 사원번호, 사원명,
--매니저번호, 연봉, 보너스, 실수령액 ,내년 연봉  검색
-- 내년 연봉은 올해연봉에 5%를 증가한 값 검색 ㄴ
select	empno, ename, mgr, sal, comm , sal+comm real_sal, sal*1.05 next_sal
from  	emp
where		job='SALESMAN';


select * from EMP




