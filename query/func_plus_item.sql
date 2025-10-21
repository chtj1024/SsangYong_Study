select * from temp;

insert into temp(deptno) values(func_plus(10, 21));

commit;

select * from test_bitmap;

truncate table test_bitmap;

--키보드 K로 시작, 마우스 M으로 시작
create or replace function func_plus(num number, num2 number)
return number
is
	temp_flag varchar2(1);
	create_num varchar2(8);
begin
	
	result := num + num2;

	return result;
end;

