create table student (
	id					varchar2(30)	primary key,
	name				varchar2(20)	not null,
	age					number(3)			check (age between 20 and 30),
	addr				varchar2(50),
	tel					varchar2(30)	Unique,
	email				varchar2(50),
	input_date	date 					default sysdate
);



create table subject (
	sub_id		varchar2(30)	primary key,
	sub_name	varchar2(30)	not null,
	teacher		varchar2(30)
);

create table test (
	test_id		varchar2(30)	primary key,
	id				varchar2(30),
	sub_id		varchar2(30),
	test_day	date					default sysdate,
	score			number(3)			check (score between 0 and 100),
	FOREIGN KEY(id) REFERENCES student(id),
	FOREIGN KEY(sub_id) REFERENCES subject(sub_id)
);

-- �л����̺� ����

insert into	student(id, name, age, addr, tel, email)
values('1', '������', 25, '��õ������ ����Ȧ��', '010-1234-1234',
	'test@test.com');

-- �л����̺� ����
insert into	student(id, name, age, addr, tel, email)
values('1', , 40, '�����', '010-1234-1234',
	'test@test.com');

select * from subject;

-- �������̺� ����
insert into subject(sub_id, sub_name, teacher)
values('1', '�ڹ�', '������');
-- �������̺� ����
insert into subject(sub_id, sub_name, teacher)
values('1', '', '������');

-- �������̺� ����
insert into test(test_id, id, sub_id,  score)
values('1', '1', '1', 95);

-- �������̺� ����
insert into test(test_id, id, sub_id,  score)
values('1', '2', '3', 200);
