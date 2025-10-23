create or replace procedure proc_select(i_empno number,
 ename out varchar2, hiredate out date, errm out varchar2)
 is
 	s_name cp_emp2.ename%type;
 	s_hiredate emp.hiredate%type;
 begin
		select 	ename, hiredate
		into		s_ename, s_hiredate
		from
		where
end;
/