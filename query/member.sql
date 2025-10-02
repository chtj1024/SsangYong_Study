/*회원 시퀀스 삭제*/
drop sequence seq_member;

/*회원 시퀀스 생성*/
create sequence seq_member
increment by 1
start with 1
maxvalue 99999999999;

/* 회원테이블 삭제 */
DROP TABLE member
	CASCADE CONSTRAINTS;

/* 회원테이블 생성 */
CREATE TABLE member (
	num NUMBER(10) NOT NULL, /* 회원번호 */
	name VARCHAR2(30) NOT NULL, /* 회원명 */
	age NUMBER(3), /* 나이 */
	gender CHAR(6) NOT NULL, /* 성별 */
	tel VARCHAR2(13), /* 전화번호 */
	input_date DATE DEFAULT sysdate /* 가입일 */
);

COMMENT ON TABLE member IS '회원';

COMMENT ON COLUMN member.num IS '회원번호';

COMMENT ON COLUMN member.name IS '회원명';

COMMENT ON COLUMN member.age IS '나이';

COMMENT ON COLUMN member.gender IS '성별';

COMMENT ON COLUMN member.tel IS '전화번호';

COMMENT ON COLUMN member.input_date IS '가입일';

CREATE UNIQUE INDEX PK_member
	ON member (
		num ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			num
		);

--회원테이블에 가데이터를 추가
insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '남지우', 26, '남자', '010-1234-5678');

insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '김서우', 27, '남자', '010-4321-8765');

insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '조나영', 25, '여자', '010-7656-3456');

insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '임성우', 28, '남자', '010-4729-8972');
commit;

select * from member;