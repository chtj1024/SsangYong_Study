--number 숫자를 저장하는 데이터형
create table test_number(
	num number,
	num2 number(4),   /*정수 0~9999까지 저장 가능*/
	num3 number(7, 2) /*정수 5자리 실수 2자리로 구성 된 숫자 0.0~99999.99*/
);

--레코드 추가
--컬럼명을 생략 (테이블에 컬럼순서대로 값을 추가)
insert into test_number values(1, 0, 12.12);

--컬럼명 명시 (개발자가 원하는 컬럼의 순서대로 값 추가)
insert into test_number(num3, num2, num)
	values(12345.67, 1234, 9999999999999999999999);

--컬럼명을 명시하면 원하는 컬럼에만 값을 추가할 수 있다.
insert into test_number(num2)
	values(0);
insert into test_number(num2) values(9999);
insert into test_number(num2) values(10000); -- error

insert into test_number(num2) values(8888);
commit;

insert into test_number(num3) values(8888888); --error

select * from TEST_NUMBER;
select * from USER_TAB_COLS; --DD(Data Dictionary)

--문자열을 저장
create table test_string(
	name varchar2(15),
	email varchar2(50),
	ssn char(14));

--레코드를 추가
insert into test_string(name, email, ssn)
	values('탄지로', 'test@test.com', '950101-1234567');

insert into test_string(name, email, ssn)
	values('젠이츠', 'Test@test.com', '950101-1234567');

insert into test_string(name, email, ssn)
	values('이노스케', 'Test@test.com', '950101');

commit;
select * from test_string;

select name, length(name), ssn, length(ssn)
from test_string;

select *
from test_string
where ssn = '950101         ';

create table test_date(
	hiredate date,
	hiredate2 timestamp
	);

insert into test_date(hiredate, hiredate2)
	values(sysdate, sysdate);
commit;

select * from test_date;

-- lob(Large Object) 저장
create table test_lob(
	age long,
	contents clob);

insert into test_lob(age, contents)
	values(600, '600년 동안 잘 살아남았습니다.');
commit;

select * from test_lob;

create table exam0917(
	name varchar2(15),
	age number(4)
	);

--테이블 만들고 두 개정도 레코드 넣어보기.

insert into exam0917(name, age)
	values('최태준', 28);

insert into exam0917(name, age)
	values('둘리', 2000);

insert into exam0917
	values('고길동', 57);

select * from exam0917;
