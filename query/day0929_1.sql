select * from user_sequences;

select	seq_empno.currval
from		dual;

select	seq_empno.nextval
from		dual;

select * from emp_view2;

select * from user_views;

select * from user_indexes
where		table_name = 'CP_ZIPCODE';

--�ε��� ������
alter index ind_zipcode rebuild;


--�ε��� ����
-- �÷��� ���� �����ؾ� �Ѵ�.

create unique index ind_cp_emp4 on cp_emp4(empno);

--�ߺ����� ���� �� �� �ε����� ����.
delete from cp_emp4 where empno;

select * from cp_emp4;
-- ����ũ �ε����� �����Ǿ� �ִٸ� �ߺ����� �Էµ��� �ʴ´�.
insert into cp_emp4(empno, ename) values(7521, '�׽�Ʈ');

select * from user_ind_columns;

--�ε��� ����
drop index ind_cp_emp4;
--desc �ε���
create unique index ind_cp_emp4 on cp_emp4(empno desc);

-- ���� �÷� non_unique �ε���
create index ind_cp_emp4_job on cp_emp4(job);

select * from user_ind_columns
where		table_name = 'CP_EMP4';

select * from user_indexes
where		table_name = 'CP_EMP4';

create table test_bitmap as
(select item_num, item_name from primary_multi);

--��Ʈ�� �ε��� : non-unique index �迭
create bitmap index ind_test_bitmap on test_bitmap(item_num);

select * from test_bitmap;
--�ߺ� ���� �����ϱ� ������ �÷��� ���� ��Ư�� ����.
insert into test_bitmap(item_num, item_name)
values('I_000009', '������2');

select * from user_indexes
where		table_name = 'TEST_BITMAP';

--composite index : ���� �÷��� �ϳ��� �ε����� ������ ��
create table test_composite as (select * from primary_multi);

select * from test_composite;

create unique index ind_test_composite
on test_composite(item_num, prd_id);

select * from user_indexes
where table_name = 'TEST_COMPOSITE';

select * from user_ind_columns
where table_name = 'TEST_COMPOSITE';

--index�� �����Ǹ� index ��å�� ����Ǵ� ���� �߰��� �� ����.
insert into test_composite(ITEM_NUM, PRD_ID, ITEM_NAME)
values('I_000022', '���̵�', '�����۸�');

select * from TEST_COMPOSITE;