-- index
--��� ���ڵ带 ���ڵ带 �ĺ��ϱ����� �ּ� (rowid)�� ������.
select rowid, empno
from emp;

select	rowid, deptno ,dname,loc
from		dept;

select  rowid, zipcode,sido,gugun
from 		zipcode;

-- ������ index�� Ȯ���� �� �ִ� DD
select  *
from		user_indexes;

select *
from user_ind_columns;


create table cp_zipcode as ( select * from zipcode );

create unique index ind_zipcode on cp_zipcode ( seq );

select * from user_indexes
where table_name in('ZIPCODE', 'CP_ZIPCODE');

--zipcode ���̺��� seq�� 45000~45100������ �����ȣ �˻�.
--index �� ������� ���� ���̺�
select	zipcode,sido, gugun, dong, bunji, seq
from		zipcode
where		seq between 45000 and 45100;
--index�� ����� ���̺�

select	zipcode,sido, gugun, dong, bunji, seq
from		cp_zipcode
where		seq between 45000 and 45100;




