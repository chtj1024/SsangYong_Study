--foreign key (외래키, 참조키)
--컬럼단위 제약사항
--primary_column 테이블에 id를 foreign key로 참조.
create table foreign_column(
	id varchar2(20) constraint fk_foreign_column_id references primary_column(id),
	addr varchar2(100)

);

--추가 성공
--부모테이블에 존재하는 값으로만 추가
select * from PRIMARY_COLUMN;
insert into foreign_column(id, addr)
values('kim', '서울시 강남구 역삼동');

insert into foreign_column(id, addr)
values('kim2', '서울시 강남구 역삼동');

--null로 추가
insert into foreign_column(id, addr)
values('', '경기도 부천시 마계동');

insert into foreign_column(addr)
values('경기도 수원시 영통구 영통동');

insert into foreign_column(id, addr)
values('kim2', '강원도 강릉시');

select * from foreign_column;

--추가 실패
--부모테이블에 존재하지 않는 값으로 추가
insert into foreign_column(id, addr)
values('park', '서울시 동대문');

--자식레코드가 존재하면 부모테이블의 레코드는삭제되지 않는다.
delete from primary_column where id = 'kim';
rollback;

--on delete cascade 사용.
create table foreign_column(
	id varchar2(20) constraint fk_foreign_column_id references primary_column(id),
	addr varchar2(100)

);

--참조하는 모든 자식레코드를 삭제한 후
delete from foreign_column where id = 'kim';
--부모테이블에 레코드를 삭제
delete from primary_column where id = 'kim';

select * from PRIMARY_COLUMN;

--테이블단위 제약사항
create table foreign_table(
	id 		varchar2(15),
	addr	varchar2(300),
	constraint fk_foreign_table_id foreign key(id)
		references primary_table(id)
);

select * from user_constraints;
