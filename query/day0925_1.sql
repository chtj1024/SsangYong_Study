create table test_alter(
	id		varchar2(20),
	neam	varchar2(30),
	addr	number
);

drop table test_alter;

-- �÷��� �߰�
alter table test_alter rename column neam to name;
--���ڵ尡 �������� ������ ��� ��������� �߰��� �� �ִ�.
-- ���̸� �߰�
alter table test_alter add age number(3) check (age between 1 and 120);

insert into test_alter(id, name, addr, age)
values('kim', '�׽�Ʈ', 1, 26);

--���ڵ尡 �����ϸ� null�� ����ϴ� ������׸� �߰��� �� �ִ�.

--�̸����� �߰� : �̸����� �ݵ� ���Է��ؾ���.
alter table test_alter add email varchar2(50) not null;
--�̸����� �߰� : �̸����� ���� ���� �ְ� �ִٸ� �����ϴ�.
alter table test_alter add email varchar2(50)
constraint ux_test_alter_email unique;

--test_alter ���̺� deptno�÷��� �߰��ϸ鼭 dept���̺�
--deptno�÷��� �����θ� �߰��� �� �ֵ��� ��������� ����.

select * from dept;

alter table test_alter add deptno number(4)
references dept(deptno);

--age �÷��� ����
alter table test_alter drop column age;

--addr �÷��� ���� ������ ���ڿ� 100 byte�� ����
alter table test_alter modify addr varchar2(100);

--���ڵ尡 �����ϸ� ���������� ������� �ʴ´�.
truncate table test_alter;

-- test_alter ���̺���� test_alter2�� ����
alter table test_alter rename to test_alter2;

select * from user_constraints
where	table_name = 'test_alter2';

--test_alter2���̺� id�÷��� pk�� ����
alter table test_alter2 add
constraint pk_test_alter2 primary key(id);

select * from test_alter2;

--���ڵ� �߰�
insert into test_alter2(id) values('kim');
insert into test_alter2(id) values('kim2');
--���� ���̵� �߰��Ǹ� error
insert into test_alter2(id) values('kim');

alter table test_alter2 disable constraint pk_test_alter2;

-- ���� ���̵� �߰��Ǹ� ������ �߻����� �ʴ´�.
insert into test_alter2(id) values('kim');

select * from test_alter2;

alter table test_alter2 enable constraint pk_test_alter2;

--������׿� ������� �ʴ� ����
delete from test_alter2 where id = 'kim';

alter table test_alter2 enable constraint pk_test_alter2;

--������� ����
alter table test_alter2 drop constraint pk_test_alter2;

insert into test_alter2(name) values('�׽�Ʈ');

select * from test_alter2;
