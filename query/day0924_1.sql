select * from user_tab_cols;

-- primary key : �⺻Ű, ��Ű
-- column level constraint
create table primary_column(
	id varchar2(20) primary key,
	name varchar2(30)
); -- �� ���̺� �̹� �ֳ�?

create table primary_column(
	id varchar2(20) constraint pk_pimary_column primary key,
	name varchar2(30)
);

select * from user_constraints
where table_name = 'PRIMARY_COLUMN';

insert into dept(deptno) values(10);
-- �÷��� null�� ������� �ʰ�, ������ ������ �����ؾ� �� ��
-- ����
-- �����Է��ϸ�
insert into primary_column(id, name) values('kim', '�輭��');
-- ���̵� �ٸ���
insert into primary_column(id, name) values('kim2', '�輭��');
insert into primary_column(id, name) values('lee', '');

select * from primary_column;

-- ����
-- ���̵� �ߺ��Ǹ�
insert into primary_column(id, name) values('kim2', '�ڿ�â');
-- ���̵� null�� �ԷµǸ� error
-- ���ڿ� �������� (char, varchar2, clob) :
-- �÷����� ����, ''�� �Է�
insert into primary_column(name) values('�輭��');

insert into primary_column(id, name) values('', '�輭��');

-- ���� ��������, ��¥ ������(number, long, date, timestamp)
-- �÷����� ����

--���̺���� �������
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

--�������� �÷��� �ϳ��� pk�� �����ϴ� ���
-- ���̺� ���� ������׸� ����.
create table primary_multi(
	item_num 	char(8),
	prd_id 		varchar2(14),
	item_name varchar2(60),
	constraint pk_primary_multi primary key(item_num, prd_id)
);

select * from user_constraints
where		table_name = 'PRIMARY_MULTI';

--���� �Է�
--�����Է�

--�ΰ��� �÷��� ������ ���� �߰����� ������
insert into primary_multi(item_num, prd_id, item_name)
	values('I_000001', 'kim', 'Ű����');

insert into primary_multi(item_num, prd_id, item_name)
	values('I_000001', 'kim2', 'Ű����');

insert into primary_multi(item_num, prd_id, item_name)
	values('I_000002', 'kim', '���콺');
--���� �߻�
-- null�� �ԷµǸ� error
insert into primary_multi(item_num, prd_id, item_name)
	values('', 'kim', '���콺');

insert into primary_multi(item_num, prd_id, item_name)
	values('I_000002', '', '���콺');

insert into primary_multi( prd_id, item_name)
	values('park', '���콺');

--�ΰ��� �÷��� ���ÿ� �ԷµǸ�