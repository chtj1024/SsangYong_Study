-- index_hint : ��ȸ �÷��� /* + */

create unique index ind_cp_emp4 on cp_emp4(empno);
drop index ind_cp_emp4;

-- ������ �ε��� ��ȸ
select * from user_indexes
where	table_name = 'CP_EMP4';
select * from user_ind_columns
where	table_name = 'CP_EMP4';

select	/*+ index (cp_emp4 ind_cp_emp4) */ empno, ename, job
from		cp_emp4
where		empno between 1234 and 7900;

select * from user_tab_cols;