-- unique
-- �÷�����
create table unique_column(
	id 		varchar2(20),
	name	varchar2(30),
	email varchar2(50) constraint ux_unique_column unique
);

--�ε����� �ڵ� ����
select * from user_indexes
where		table_name = 'UNIQUE_COLUMN';

--�߰�����
--���� �Է�
insert into unique_column(id, name, email)
values('kim', '�輭��', 'kim@test.com');
--�÷��� ���� �ٸ���
insert into unique_column(id, name, email)
values('kim', '�輭��', 'kim2@test.com');
--�÷��� ���� null�̸� (null�� �ߺ���üũ���� �ʴ´�.)
insert into unique_column(id, name, email)
values('kim', '�輭��', '');

insert into unique_column(id, name)
values('kim', '�輭��3');

select * from unique_column;

--�߰�����
-- �ߺ��� �̸����� �ԷµǸ� error
insert into unique_column(id, name, email)
values('kim2', '�ſ��', 'kim2@google.com');

--���̺����
create table unique_column(
	id 		varchar2(20),
	name	varchar2(30),
	email varchar2(50),
	constraint ux_unique_table_email unique(email)
);

select * from unique_column;

-- üũ����, not null, default
-- �̸�, ����, �ּ�, �Է��� ����
-- �̸��� �ʼ� �Է�, ����-'����', '����', �ּ� : �������� �ִ�.
-- ���̴� 20�븸 (20~29), �Է����� �����Ǹ� �߰��ϴ� ������
-- ��¥������ �Է�.

create table other_constraints(
	name 		varchar2(30) not null,
	gender 	char(6) constraint c_other_cons_gender check (gender in ('����', '����')),
	age 		number(2) check (age between 20 and 29),
	addr		varchar2(300) null,
	input_date	date	default sysdate
);

select * from user_constraints
where		table_name = 'OTHER_CONSTRAINTS';

select	* from user_tab_cols
where table_name = 'OTHER_CONSTRAINTS';

--�߰� ����
-- �̸��� �ݵ�� �ԷµǾ���ϰ�, ���� - ����, ����, ���� - 20��,
-- �Է����� �־�ǰ�, �ȳ־ �ȴ�.
insert into other_constraints(name, gender, age, addr, input_date)
values('����','����', 20, '����� ������ ���ﵿ', sysdate);

insert into other_constraints(name, gender, age, input_date)
values('����','����', 29, sysdate);
--default : null�� �ԷµǴ� ��Ȳ�� ������ ���� ����.
insert into other_constraints(name, gender, age, addr)
values('���','����', 25, '����� ������ ���ﵿ');

select * from other_constraints;

--�߰� ����
--not null : �̸��� null�� �ԷµǴ� ���
insert into other_constraints(name, gender, age, addr)
values('','����', 25, '����� ������ ���ﵿ');

insert into other_constraints(gender, age, addr)
values('����', 25, '����� ������ ���ﵿ');

--check ���� : ������ ���ڳ� ���ڰ� �ƴ� ���
insert into other_constraints(name, gender, age, addr)
values('���','��', 25, '����� ������ ���ﵿ');

--check ���� : ���̰� 20�밡 �ƴ� ���
insert into other_constraints(name, gender, age, addr)
values('���','����', 30, '����� ������ ���ﵿ');


select * from user_constraints
where		table_name = 'TEMP2';

select * from zipcode;

-- �����ϱ� ���� ���̺� �� �� ����
