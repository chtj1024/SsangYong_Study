create table student (
	student_id number(4) primary key,
	name varchar2(20),
	email varchar2(50),
	class varchar2(2),
	address varchar2(80),
	sex varchar2(5),
	java_score number(3),
	input_date date
);

alter table student
modify (sex varchar2(10));

insert into student values(1, '윤자빈', 'yoon@test.com', 'A', '서울시 강남구 역삼동', '남자', 90, sysdate);
insert into student values(2, '나경원', 'na@daum.net', 'A', '서울시 동작구 사당동', '여자', 100, sysdate - 1);
insert into student values(3, '이준원', 'leegun@google.com', 'B', '경기도 화성시 화성동', '남자', 75, sysdate - 1);
insert into student values(4, '박상현', 'parksang@daum.net', 'A', '경기도 화성시 화성2동', '여자', 85, sysdate);
insert into student values(5, '신승덕', 'shin@naver.com', 'B', '서울시 관악구 신림동', '남자', 91, sysdate);

select * from student;

select student_id, name, java_score, class, input_date
from student;

update student
set class = 'A'
where student_id in (3, 5);
commit;

update student
set name = '임다민',
		java_score = 90,
		input_date = sysdate + 1
where email = 'parksang@daum.net';
commit;

delete from student
where name like '%원';

rollback;

truncate table student;

select * from student;

drop table student;

purge table student;

select * from user_recyclebin;