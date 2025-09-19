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

insert into student values(1, '���ں�', 'yoon@test.com', 'A', '����� ������ ���ﵿ', '����', 90, sysdate);
insert into student values(2, '�����', 'na@daum.net', 'A', '����� ���۱� ��絿', '����', 100, sysdate - 1);
insert into student values(3, '���ؿ�', 'leegun@google.com', 'B', '��⵵ ȭ���� ȭ����', '����', 75, sysdate - 1);
insert into student values(4, '�ڻ���', 'parksang@daum.net', 'A', '��⵵ ȭ���� ȭ��2��', '����', 85, sysdate);
insert into student values(5, '�Ž´�', 'shin@naver.com', 'B', '����� ���Ǳ� �Ÿ���', '����', 91, sysdate);

select * from student;

select student_id, name, java_score, class, input_date
from student;

update student
set class = 'A'
where student_id in (3, 5);
commit;

update student
set name = '�Ӵٹ�',
		java_score = 90,
		input_date = sysdate + 1
where email = 'parksang@daum.net';
commit;

delete from student
where name like '%��';

rollback;

truncate table student;

select * from student;

drop table student;

purge table student;

select * from user_recyclebin;