--논리연산자 : 여러개의 관계연산자를 붙여서 연산할 때.
--사원테이블에서 연봉이 1250이상 3000이하인 사원들의
-- 사원번호, 사원명, 직무, 연봉, 보너스, 부서번호를 검색.

select  empno, ename, job, sal, comm, deptno
from 		emp
where   sal >= 1250 and sal <= 3000;
--where   sal > 1249 and sal < 3001;

--between A and B

select  empno, ename, job, sal, comm, deptno
from 		emp
where   sal between 1250 and 3000;

--사원테이블에서 직무가 'SALESMAN'이면서 연봉이 1250을 초과하는 사원의
-- 사원명, 연봉, 보너스, 부서번호, 직무를 조회

-- 사원테이블에서 직무가 'SALESMAN','CLERK','ANALYST'인 사원들의
-- 사원번호, 사원명, 연봉, 보너스, 직무 조회
select	empno, ename, sal, comm, job
from 		emp
where 	job in ('SALESMAN','CLERK','ANALYST');
--where		job=  'SALESMAN' or job='CLERK' or job='ANALYST';

--사원테이블에서 보너스가 없는 사원들의 사원번호,사원명,연봉, 보너스 검색.
select	empno, ename , sal, comm
from		emp
where		comm is null;
--where		comm = null;

--사원테이블에서 보너스를 수령하는 사원들의 사원번호,사원명,연봉, 보너스 검색.
select	empno, ename , sal, comm
from		emp
where		comm is not null;
--where		comm != null;

-------문자열 연산자 ( like 연산자 )--------------------------------
-- like에 특수문자 (%,_)를 사용하지 않으면 관계연산자의 = 과같은 연산을 수행

select	empno, ename, job, mgr, sal
from		emp
where		ename like 'WARD';
--where		ename like '나경원';

select * from EMP;

create table test_like(
name varchar2(30),
addr varchar2(300)
);

insert into test_like(name, addr) values('임다민','서울시 강남구 역삼동');
insert into test_like(name, addr) values('임성우','서울시 강남구 서초동');
insert into test_like(name, addr) values('윤자빈','경기도 부천시 역곡동 ');
insert into test_like(name, addr) values('윤자아빈','제주시 일도 이동');
insert into test_like(name, addr) values('윤세자빈','서울시 중구 경회루');
insert into test_like(name, addr) values('이정우','서울시 동대문구 동대문동');
insert into test_like(name, addr) values('이준원','인천광역시 강남구 서초동');
insert into test_like(name, addr) values('나경원','서울시 동작구 사당동');
commit;

--test_like테이블에서 성이 '윤'씨인 회원의 이름과 주소를 검색
select	name,addr
from 		test_like
where  	name like '윤%';

--test_like테이블에서 '서울시'에 거주중인 회원의 이름과 주소를 검색
select	name,addr
from 		test_like
where  	addr like '서울시%';

--이름이 '우'로 끝나는 이름,주소을 검색
select	name,addr
from 		test_like
where  	name like '%우';

--주소가 '서초동'으로 끝나는 이름,주소을 검색
select	name,addr
from 		test_like
where  	addr like '%서초동';

--이름에 '자'가 들어있는이름,주소를 검색
select	name,addr
from 		test_like
where  	name like '%자%';

select * from TEST_LIKE




