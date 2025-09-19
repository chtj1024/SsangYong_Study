-- transaction 연습
create table test_transaction(
name varchar2(15),
address varchar2(30)
);

create table test_transaction2(
name varchar2(15),
address varchar2(15)
);

--레코드 추가
-- 성공
insert into test_transaction(name,address)
values('테스트','서울시');

insert into test_transaction2(name,address)
values('테스트','서울시');

select * from test_transaction;
select * from test_transaction2;
commit; --transaction완료
 --실패  -> 정상종료 ( 하나의 테이블에만 레코드가 저장  =>일관성의 문제 )
insert into test_transaction(name,address)
values('테스트','서울시 강남구 역삼');

insert into test_transaction2(name,address)
values('테스트','서울시 강남구 역삼');


select * from test_transaction;
select * from test_transaction2;

insert into test_transaction(name,address)
values('테스트2','서울시 강남구 역삼');

insert into test_transaction2(name,address)
values('테스트2','서울시 강남구 역삼');

select * from test_transaction;
select * from test_transaction2;
-- test_transaction에 추가된 레코드도 취소
rollback; --성공된 테이블도 작업을 취소시켜 일관성을 보장.


------------select-----------------------------------
-- 사원테이블에서 모든사원에 사원번호,사원명, 연봉,보너스를 검색
select  empno, ename, sal, comm
from		emp;

-- 사원테이블에서 모든사원에 모든 컬럼을 검색
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
FROM EMP;

SELECT *
FROM EMP;

--부서테이블에서 모든 부서의 부서번호,위치 검색.
select	deptno, loc
from		dept;

--학생테이블 생성
create table student(
num number(2),
name varchar2(15byte),
tel varchar2(13),
address varchar2(100),
class char(1),
height number(4,1),
weight number(4,1),
input_date date
);

--레코드 추가
insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(1,'루피','010-1234-5678','서울시 강남구 역삼동','A',
	205.5, 75.2,sysdate);
commit;

insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(2,'샹디','test@a.com','서울시 동대문구 역삼동','A',
	5.5, 75.2,sysdate);
commit;

insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(3,'쵸파','010-1234-4321','test@test.com','Z',
	152.9, 49.2,'2025-09-17');
commit;

select * from STUDENT;


