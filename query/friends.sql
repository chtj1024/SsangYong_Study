/*테이블 삭제*/
drop table friends_mgr;

/* 테이블 생성 */
create table friends_mgr(
	num		number(4),
	name	varchar2(30),
	email	varchar2(80),
	tel		varchar2(13),
	intro	clob,
	img		blob,
	ext varchar2(10),
	input_date date default sysdate,
	constraint pk_friends_mgr primary key(num)
);

/* 시퀀스 삭제 */
drop sequence seq_friends;

/* 시퀀스 삭제 */
create sequence seq_friends
increment by 1
start with 1
maxvalue 99999
nocycle;
