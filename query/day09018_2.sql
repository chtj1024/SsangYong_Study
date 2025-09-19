--변경
select * from student;

--학생테이블에서 모든 학생의 반을 'B'반으로 변경
update  student
set			class='B';

rollback;

--학생테이블에서 1번학생의 키를 174.3으로, 주소를 경기도 수원시 망포동포동 변경.
update  student
set			height=174.3, address='경기도 수원시 망포동포동'
where   num=1;
commit;

select * from student;


insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(4,'우솝','010-xxxx-xxxx','서울시 동대문구 동대문동','Z',
	182.9, 67.2,'2025-09-18');
commit;

update student
set       class='D'
where num=4;
commit;


 select * from student;


 --학생테이블에서 학생의 번호가 2번 이면서 이름이 '샹디'인 학생의
 --전화번호를 010-9876-5432로, 반을 'E', 키를 186.3으로, 이름을 '상디'로 변경

 --삭제
 --학생 테이블에 모든 레코드를 삭제.
delete from student;
rollback;

-- 학생의 번호가 4번인 학생의 레코드를 삭제.
delete from student
where 	num=4;
commit;
select * from student;

--학생테이블에서 번호가 3번이면서 키가 152.9인 학생의레코드를 삭제. (취소)


--테이블 절삭
--학생테이블의 모든 레코드를 절삭
truncate table student;

rollback;
select * from student;

----drop----------------------
--학생테이블 삭제
drop table student;

select * from tab;

select * from BIN$R7xXAa2lRYSMFWV14ZJK+g==$0;

--휴지통에 내용보기
show recyclebin;

--휴지통 비우기
purge recyclebin;


select * from tab;

drop table emp;


flashback table emp to before drop;







