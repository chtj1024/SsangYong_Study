-- unique
-- 컬럼단위
create table unique_column(
	id 		varchar2(20),
	name	varchar2(30),
	email varchar2(50) constraint ux_unique_column unique
);

--인덱스가 자동 생성
select * from user_indexes
where		table_name = 'UNIQUE_COLUMN';

--추가성공
--최초 입력
insert into unique_column(id, name, email)
values('kim', '김서우', 'kim@test.com');
--컬럼의 값이 다르면
insert into unique_column(id, name, email)
values('kim', '김서우', 'kim2@test.com');
--컬럼의 값이 null이면 (null은 중복을체크하지 않는다.)
insert into unique_column(id, name, email)
values('kim', '김서우', '');

insert into unique_column(id, name)
values('kim', '김서우3');

select * from unique_column;

--추가실패
-- 중복된 이메일이 입력되면 error
insert into unique_column(id, name, email)
values('kim2', '신용권', 'kim2@google.com');

--테이블단위
create table unique_column(
	id 		varchar2(20),
	name	varchar2(30),
	email varchar2(50),
	constraint ux_unique_table_email unique(email)
);

select * from unique_column;

-- 체크조건, not null, default
-- 이름, 성별, 주소, 입력일 저장
-- 이름은 필수 입력, 성별-'남자', '여자', 주소 : 없을수도 있다.
-- 나이는 20대만 (20~29), 입력일은 생략되면 추가하는 시점의
-- 날짜정보가 입력.

create table other_constraints(
	name 		varchar2(30) not null,
	gender 	char(6) constraint c_other_cons_gender check (gender in ('남자', '여자')),
	age 		number(2) check (age between 20 and 29),
	addr		varchar2(300) null,
	input_date	date	default sysdate
);

select * from user_constraints
where		table_name = 'OTHER_CONSTRAINTS';

select	* from user_tab_cols
where table_name = 'OTHER_CONSTRAINTS';

--추가 성공
-- 이름이 반드시 입력되어야하고, 성별 - 남자, 여자, 나이 - 20대,
-- 입력일은 넣어도되고, 안넣어도 된다.
insert into other_constraints(name, gender, age, addr, input_date)
values('루피','남자', 20, '서울시 강남구 역삼동', sysdate);

insert into other_constraints(name, gender, age, input_date)
values('나미','여자', 29, sysdate);
--default : null이 입력되는 상황에 설정한 값이 들어간다.
insert into other_constraints(name, gender, age, addr)
values('상디','남자', 25, '서울시 강남구 역삼동');

select * from other_constraints;

--추가 실패
--not null : 이름에 null이 입력되는 경우
insert into other_constraints(name, gender, age, addr)
values('','남자', 25, '서울시 강남구 역삼동');

insert into other_constraints(gender, age, addr)
values('남자', 25, '서울시 강남구 역삼동');

--check 조건 : 성별이 남자나 여자가 아닌 경우
insert into other_constraints(name, gender, age, addr)
values('상디','자', 25, '서울시 강남구 역삼동');

--check 조건 : 나이가 20대가 아닌 경우
insert into other_constraints(name, gender, age, addr)
values('상디','님자', 30, '서울시 강남구 역삼동');


select * from user_constraints
where		table_name = 'TEMP2';

select * from zipcode;

-- 복원하기 전에 테이블 몇 개 삭제
