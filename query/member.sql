/*ȸ�� ������ ����*/
drop sequence seq_member;

/*ȸ�� ������ ����*/
create sequence seq_member
increment by 1
start with 1
maxvalue 99999999999;

/* ȸ�����̺� ���� */
DROP TABLE member
	CASCADE CONSTRAINTS;

/* ȸ�����̺� ���� */
CREATE TABLE member (
	num NUMBER(10) NOT NULL, /* ȸ����ȣ */
	name VARCHAR2(30) NOT NULL, /* ȸ���� */
	age NUMBER(3), /* ���� */
	gender CHAR(6) NOT NULL, /* ���� */
	tel VARCHAR2(13), /* ��ȭ��ȣ */
	input_date DATE DEFAULT sysdate /* ������ */
);

COMMENT ON TABLE member IS 'ȸ��';

COMMENT ON COLUMN member.num IS 'ȸ����ȣ';

COMMENT ON COLUMN member.name IS 'ȸ����';

COMMENT ON COLUMN member.age IS '����';

COMMENT ON COLUMN member.gender IS '����';

COMMENT ON COLUMN member.tel IS '��ȭ��ȣ';

COMMENT ON COLUMN member.input_date IS '������';

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

--ȸ�����̺� �������͸� �߰�
insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '������', 26, '����', '010-1234-5678');

insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '�輭��', 27, '����', '010-4321-8765');

insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '������', 25, '����', '010-7656-3456');

insert into member(num, name, age, gender, tel)
values(seq_member.nextval, '�Ӽ���', 28, '����', '010-4729-8972');
commit;

select * from member;