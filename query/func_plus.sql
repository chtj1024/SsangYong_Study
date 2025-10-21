-- 두 수를 입력받아서 합산한 값을 반환
-- procedure와 function은 같은 DD에서 관리되기 때문에 다른 객체이지만
-- 같은 이름으로 설정할 수 없다.

create or replace function func_plus(num number, num2 number)
return number
is
	result number;
begin
	result := num + num2;

	return result;
end;


select concat('K'||'_', lpad(seq_member.nextval,6,0));