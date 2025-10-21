-- member ���̺� ȸ�� ������ �߰��ϴ� procedure

create or replace procedure insert_member(
	name varchar2,
	age 		number,
	gender	varchar2,
	tel			varchar2,
	row_cnt	out number,
	errmsg	out varchar2)
is
	temp_gender varchar2(6) := gender;
	temp_age		number := age;

begin
	if temp_gender not in ('����', '����') then
		temp_gender := '����';
	end if;

	if temp_age not between 1 and 100 then
		temp_age := 1;
	end if;

	insert into member(num, name, age, gender, tel)
	values(seq_member.nextval,name,temp_age,temp_gender,tel);

	row_cnt := sql%rowcount;

	if row_cnt = 1 then
		commit;
	end if;

	exception
	when OTHERS then
		err_msg := sqlerrm || '�� ������ �߻�';
		rollback;
end;
/
