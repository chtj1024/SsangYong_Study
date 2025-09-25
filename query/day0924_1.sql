select * from user_tab_cols;

-- primary key : 기본키, 주키
-- column level constraint
create table primary_column(
	id varchar2(20) primary key,
	name varchar2(30)
); -- 이 테이블도 이미 있네?

create table primary_column(
	id varchar2(20) constraint pk_pimary_column primary key,
	name varchar2(30)
);

select * from user_constraints
where table_name = 'PRIMARY_COLUMN';

insert into dept(deptno) values(10);
-- 컬럼에 null을 허용하지 않고, 유일한 값으로 저장해야 할 때
-- 성공
-- 최초입력하면
insert into primary_column(id, name) values('kim', '김서우');
-- 아이디가 다르면
insert into primary_column(id, name) values('kim2', '김서우');
insert into primary_column(id, name) values('lee', '');

select * from primary_column;

-- 실패
-- 아이디가 중복되면
insert into primary_column(id, name) values('kim2', '박우창');
-- 아이디에 null이 입력되면 error
-- 문자열 데이터형 (char, varchar2, clob) :
-- 컬럼명이 생략, ''가 입력
insert into primary_column(name) values('김서우');

insert into primary_column(id, name) values('', '김서우');

-- 숫자 데이터형, 날짜 데이터(number, long, date, timestamp)
-- 컬럼명이 생략

--테이블단위 제약사항
create table primary_table(
	id varchar2(20),
	name varchar2(30 byte),
	email varchar2(50),
	constraint pk_primary_table primary key(id)
);

select * from user_constraints
where table_name = 'PRIMARY_TABLE';

select * from user_indexes
where table_name in('PRIMARY_TABLE', 'PRIMARY_COLUMN');

--여러개의 컬럼이 하나의 pk를 구성하는 경우
-- 테이블 단위 제약사항만 가능.
create table primary_multi(
	item_num 	char(8),
	prd_id 		varchar2(14),
	item_name varchar2(60),
	constraint pk_primary_multi primary key(item_num, prd_id)
);

select * from user_constraints
where		table_name = 'PRIMARY_MULTI';

--정상 입력
--최초입력

--두개의 컬럼에 동일한 값이 추가되지 않으면
insert into primary_multi(item_num, prd_id, item_name)
	values('I_000001', 'kim', '키보드');

insert into primary_multi(item_num, prd_id, item_name)
	values('I_000001', 'kim2', '키보드');

insert into primary_multi(item_num, prd_id, item_name)
	values('I_000002', 'kim', '마우스');
--에러 발생
-- null이 입력되면 error
insert into primary_multi(item_num, prd_id, item_name)
	values('', 'kim', '마우스');

insert into primary_multi(item_num, prd_id, item_name)
	values('I_000002', '', '마우스');

insert into primary_multi( prd_id, item_name)
	values('park', '마우스');

--두개의 컬럼이 동시에 입력되면