-- 문제 onenote 확인
select empno, ename, hiredate, deptno, sal
from emp
where deptno != 10 and sal between 1000 and 3000;

select empno, ename, sal, comm, sal+nvl(comm, 0) - ((sal+nvl(comm, 0)) * 0.033) real_sal, round(sal/12, 2)
from emp;

select empno, ename, sal, ename || '(' || empno || ')' || '님 현재 연봉은' || sal || '입니다.' as output_message
from emp
where deptno in (10, 30)
order by sal;

create table test_like(
	student_id number(4),
	name varchar2(10),
	addr varchar2(50),
	school varchar2(5)
);

insert into test_like values(1, '나경원', '서울시 동작구 사당동', '오지고');
insert into test_like values(2, '윤자빈', '서울시 관악구 신림동', '오지고');
insert into test_like values(3, '윤자아빈', '서울시 중구 경회루', '지리고');
insert into test_like values(4, '임성우', '서울시 강남구 대포동', '썸타고');
insert into test_like values(5, '민병조', '서울시 수원구 수원동', '지리고');
insert into test_like values(5, '민병조오', '수원시 영통구 영통동', '오지고');

select * from test_like;

select '번호:'|| student_id || ', 이름:' || name || ', 출신고:' || school || ', 주소:' || addr as output
from test_like
where addr like '서울시%';

select empno, ename, sal, comm, hiredate, job
from emp
where length(ename) = 4 or sal >= 3000
order by hiredate desc, ename;

select empno, ename, hiredate, sal, sal + (sal*0.07) + nvl2(comm, 200, 300) as next_year_sal
from emp;

select empno, sal, job, mgr, hiredate
from emp
where ename like 'A%' and sal >= 1600
order by hiredate;
