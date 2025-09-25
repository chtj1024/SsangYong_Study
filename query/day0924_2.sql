--foreign key (�ܷ�Ű, ����Ű)
--�÷����� �������
--primary_column ���̺� id�� foreign key�� ����.
create table foreign_column(
	id varchar2(20) constraint fk_foreign_column_id references primary_column(id),
	addr varchar2(100)

);

--�߰� ����
--�θ����̺� �����ϴ� �����θ� �߰�
select * from PRIMARY_COLUMN;
insert into foreign_column(id, addr)
values('kim', '����� ������ ���ﵿ');

insert into foreign_column(id, addr)
values('kim2', '����� ������ ���ﵿ');

--null�� �߰�
insert into foreign_column(id, addr)
values('', '��⵵ ��õ�� ���赿');

insert into foreign_column(addr)
values('��⵵ ������ ���뱸 ���뵿');

insert into foreign_column(id, addr)
values('kim2', '������ ������');

select * from foreign_column;

--�߰� ����
--�θ����̺� �������� �ʴ� ������ �߰�
insert into foreign_column(id, addr)
values('park', '����� ���빮');

--�ڽķ��ڵ尡 �����ϸ� �θ����̺��� ���ڵ�»������� �ʴ´�.
delete from primary_column where id = 'kim';
rollback;

--on delete cascade ���.
create table foreign_column(
	id varchar2(20) constraint fk_foreign_column_id references primary_column(id),
	addr varchar2(100)

);

--�����ϴ� ��� �ڽķ��ڵ带 ������ ��
delete from foreign_column where id = 'kim';
--�θ����̺� ���ڵ带 ����
delete from primary_column where id = 'kim';

select * from PRIMARY_COLUMN;

--���̺���� �������
create table foreign_table(
	id 		varchar2(15),
	addr	varchar2(300),
	constraint fk_foreign_table_id foreign key(id)
		references primary_table(id)
);

select * from user_constraints;
