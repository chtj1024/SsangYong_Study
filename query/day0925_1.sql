create table test_alter(
	id		varchar2(20),
	neam	varchar2(30),
	addr	number
);

drop table test_alter;

-- 컬럼을 추가
alter table test_alter rename column neam to name;
--레코드가 존재하지 않으면 모든 제약사항을 추가할 수 있다.
-- 나이를 추가
alter table test_alter add age number(3) check (age between 1 and 120);

insert into test_alter(id, name, addr, age)
values('kim', '테스트', 1, 26);

--레코드가 존재하면 null을 허용하는 제약사항만 추가할 수 있다.

--이메일을 추가 : 이메일은 반듯 ㅣ입력해야함.
alter table test_alter add email varchar2(50) not null;
--이메일을 추가 : 이메일은 없을 수도 있고 있다면 유일하다.
alter table test_alter add email varchar2(50)
constraint ux_test_alter_email unique;

--test_alter 테이블에 deptno컬럼을 추가하면서 dept테이블에
--deptno컬럼의 값으로만 추가할 수 있도록 제약사항을 설정.

select * from dept;

alter table test_alter add deptno number(4)
references dept(deptno);

--age 컬럼을 삭제
alter table test_alter drop column age;

--addr 컬럼을 가변 길이형 문자열 100 byte로 변경
alter table test_alter modify addr varchar2(100);

--레코드가 존재하면 데이터형이 변경되지 않는다.
truncate table test_alter;

-- test_alter 테이블명을 test_alter2로 변경
alter table test_alter rename to test_alter2;

select * from user_constraints
where	table_name = 'test_alter2';

--test_alter2테이블에 id컬럼을 pk로 설정
alter table test_alter2 add
constraint pk_test_alter2 primary key(id);

select * from test_alter2;

--레코드 추가
insert into test_alter2(id) values('kim');
insert into test_alter2(id) values('kim2');
--같은 아이디가 추가되면 error
insert into test_alter2(id) values('kim');

alter table test_alter2 disable constraint pk_test_alter2;

-- 같은 아이디 추가되면 에러가 발생하지 않는다.
insert into test_alter2(id) values('kim');

select * from test_alter2;

alter table test_alter2 enable constraint pk_test_alter2;

--제약사항에 위배되지 않는 상태
delete from test_alter2 where id = 'kim';

alter table test_alter2 enable constraint pk_test_alter2;

--제약사항 삭제
alter table test_alter2 drop constraint pk_test_alter2;

insert into test_alter2(name) values('테스트');

select * from test_alter2;
