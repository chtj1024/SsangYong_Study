--number ���ڸ� �����ϴ� ��������
create table test_number(
	num number,
	num2 number(4),   /*���� 0~9999���� ���� ����*/
	num3 number(7, 2) /*���� 5�ڸ� �Ǽ� 2�ڸ��� ���� �� ���� 0.0~99999.99*/
);

--���ڵ� �߰�
--�÷����� ���� (���̺� �÷�������� ���� �߰�)
insert into test_number values(1, 0, 12.12);

--�÷��� ��� (�����ڰ� ���ϴ� �÷��� ������� �� �߰�)
insert into test_number(num3, num2, num)
	values(12345.67, 1234, 9999999999999999999999);

--�÷����� ����ϸ� ���ϴ� �÷����� ���� �߰��� �� �ִ�.
insert into test_number(num2)
	values(0);
insert into test_number(num2) values(9999);
insert into test_number(num2) values(10000); -- error

insert into test_number(num2) values(8888);
commit;

insert into test_number(num3) values(8888888); --error

select * from TEST_NUMBER;
select * from USER_TAB_COLS; --DD(Data Dictionary)

--���ڿ��� ����
create table test_string(
	name varchar2(15),
	email varchar2(50),
	ssn char(14));

--���ڵ带 �߰�
insert into test_string(name, email, ssn)
	values('ź����', 'test@test.com', '950101-1234567');

insert into test_string(name, email, ssn)
	values('������', 'Test@test.com', '950101-1234567');

insert into test_string(name, email, ssn)
	values('�̳뽺��', 'Test@test.com', '950101');

commit;
select * from test_string;

select name, length(name), ssn, length(ssn)
from test_string;

select *
from test_string
where ssn = '950101         ';

create table test_date(
	hiredate date,
	hiredate2 timestamp
	);

insert into test_date(hiredate, hiredate2)
	values(sysdate, sysdate);
commit;

select * from test_date;

-- lob(Large Object) ����
create table test_lob(
	age long,
	contents clob);

insert into test_lob(age, contents)
	values(600, '600�� ���� �� ��Ƴ��ҽ��ϴ�.');
commit;

select * from test_lob;

create table exam0917(
	name varchar2(15),
	age number(4)
	);

--���̺� ����� �� ������ ���ڵ� �־��.

insert into exam0917(name, age)
	values('������', 28);

insert into exam0917(name, age)
	values('�Ѹ�', 2000);

insert into exam0917
	values('��浿', 57);

select * from exam0917;
