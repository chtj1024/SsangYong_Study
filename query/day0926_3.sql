--view 생성 : 실제 테이블에서 도출된 가상의 테이블
-- cp_emp5를 사용한 단순 view 생성
create view emp_view as ( select * from cp_emp5);


-- 관리자 계정으로 view 생성권한으로 권한 부여.
grant create view to scott;

select * from dba_sys_privs
where grantee='SCOTT';

-- scott으로 접속
create view emp_view as ( select * from cp_emp5);

-- user_view DD 에서 확인
select * from user_views;

select * from user_objects;

-- 조회
select * from emp_view;
--단순 view DML가능
insert into emp_view(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'쵸파','짐승',1234,1400,70 );

select * from emp_view;

--
update  emp_view
set  		job='괴수'
where		empno=23;

--view 삭제
drop view emp_view;
select * from CP_EMP5;

--복합뷰
create view emp_view as
( select empno, ename,job, hiredate, sal, sal*0.033 tax from cp_emp5);

select * from emp_view;

--error
insert into emp_view(EMPNO, ENAME, JOB, SAL, tax)
values( seq_empno.nextval,'에이스','해적',1400,70 );


--10번부서 20번부서가 빈번하게 검색
create view emp_view2 as ( select * from emp where deptno in (10,20));

select * from emp_view2;

--복합뷰
--차량의 제조사가 ‘현대’,’기아’, ‘BMW’, ‘AUDI’ 이고 옵션에 ‘ABS’,’TCS’가 있는
--차량의 제조국, 제조사, 모델명,  연식, 가격, 옵션, 이미지, 배기량을 조회

--    단, 년식의 내림차순으로 정렬하고, 연식이 같다면 가격의 내림차순으로 정렬하여 출력.
--     이미지는 이미지명과 확장자를 구분하여 출력.
--     제조사는 첫글자만 대문자로 출력.
create or replace view car_view as
(select 	cc.country, initcap(cc.maker) maker, cma.model, cmo.car_year, cmo.price,
				cmo.car_option,
				substr(cmo.car_img, 1 ,instr(cmo.car_img,'.')-1) img,
				substr(cmo.car_img,instr(cmo.car_img,'.')+1) ext,
				 cmo.cc
from 		car_country cc, car_maker cma, car_model cmo
where		( cma.maker=cc.maker and cmo.model=cma.model)
				and ( cma.maker in ('현대','기아','BMW','AUDI')
							and instr(cmo.car_option,'ABS') != 0
							and instr(cmo.car_option,'TCS') != 0 )
/*order by cmo.car_year desc, cmo.cc desc*/)with read only;

select * from car_view
order by car_year desc, cc desc;

select * from user_views;
-- create view 권한 회수 후  view를 삭제할 수 있다.
drop view car_view;

--scott에 create view 권한을 회수

revoke create view from scott;
select * from dba_sys_privs
where grantee='SCOTT';


