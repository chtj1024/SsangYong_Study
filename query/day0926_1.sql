-- 사원테이블에서 사원명이 'BLAKE'인 사원보다 연봉을 많이 받는 사원에
-- 사원번호,사원명, 연봉, 입사일을 조회.
select	empno, ename, sal, hiredate
from 		emp
where		sal > ( select sal from emp where ename='BLAKE' );

--self 조인 : 조회용 테이블과 조건용 테이블을 식별.
select	search_emp.empno,search_emp.ename, search_emp.sal,
				 search_emp.hiredate /*, condition_emp.ename , condition_emp.empno*/
from 		emp search_emp, emp condition_emp
where   (search_emp.sal > condition_emp.sal) and condition_emp.ename='BLAKE';



select * from CP_EMP4;

--CP_EMP4테이블에 아래의 값 추가
-- 사원번호 : 가장 마지막사원보다 1큰번호
-- 사원명 :  이준원, 직무 : 사원, 매니저 : 7698, 입사일 : 내일,
-- 연봉 3100, 보너스 : 0, 부서번호 :30 번


insert into cp_emp4(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values( (select max( empno)+1 from cp_emp4), '이준원','사원', 7698,
				sysdate+1, 3100, 0, 30 );
 commit;
select * from CP_EMP4;

select * from user_sequences;

---시퀀스 사용-----------------------
--생성 : 1에서 부터 9999999까지 1씩 증가하는 시퀀스 생성
create sequence seq_test
increment by 1
start with 1
maxvalue 9999999;

select * from user_sequences;

-- 접속자세션에 로딩된 시퀀스의 현재 번호를 얻기
select seq_test.currval from dual;

-- 시퀀스의 다음 번호 얻기
select seq_test.nextval from dual;

--10~ 9999999999 까지 10씩 증가하는 시퀀스 객체 생성
-- 끝 번호까지 가면 다시 반복되도록 설정
create sequence seq_test2
increment by 10
start with 10
maxvalue 9999999999
cycle;


select * from user_sequences;

select seq_test2.nextval from dual;
-- currval은 nextval 이후에 사용되어야한다.ㄴ
select seq_test2.currval from dual;

--시퀀스 삭제
drop sequence seq_test2;

-- emp테이블의 구조만 복사하여 cp_emp5테이블 생성
create table cp_emp5 as ( select * from emp where 1=0 );
select * from CP_EMP5;

--cp_emp5테이블에 사원번호를 PK 설정.
alter table cp_emp5 add constraint pk_cp_emp5 primary key ( empno );
--사원의 입사일은 생략되면 현재 년도로 추가되도록 설정
--사원의 보너스는 생략되면 0 추가되도록 설정
alter table cp_emp5 modify hiredate date default sysdate;
alter table cp_emp5 modify comm number(7,2) default 0;

-- 사원정보가 추가 될때마다 사원번호는 1씩 증가하도록 만들고 싶다.
-- => 시퀀스생성.
create sequence seq_empno
increment by 1
start with 1
maxvalue 99999999999999999
cache  30
nocycle;

select * from user_sequences;

--사원정보 추가
insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'루피','해적왕',1234,3000,10 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'조로','칼잡이',1234,3400,20 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'나미','소매치',1234,4400,30 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'샹디','셰프',1234,2400,40 );

-- 시퀀스를 가지고 있는 쿼리문이 실패하면 해당 번째 번호를 사라진다.
insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'궁디','바지사장',1234,2400,40 );

insert into cp_emp5(EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
values( seq_empno.nextval,'우솝','구라질',1234,5400,50 );

select * from cp_emp5;

select * from PRIMARY_MULTI;
--item_num의 형식이  I_000001 의 형식이면서 추가할 때마다 1씩 증가하는
--형태

insert into primary_multi(ITEM_NUM, PRD_ID, ITEM_NAME  )
values( concat('I_',lpad(seq_empno.nextval,6,0)),'아이디','아이템명' );

select * from PRIMARY_MULTI;
