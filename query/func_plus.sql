-- �� ���� �Է¹޾Ƽ� �ջ��� ���� ��ȯ
-- procedure�� function�� ���� DD���� �����Ǳ� ������ �ٸ� ��ü������
-- ���� �̸����� ������ �� ����.

create or replace function func_plus(num number, num2 number)
return number
is
	result number;
begin
	result := num + num2;

	return result;
end;


select concat('K'||'_', lpad(seq_member.nextval,6,0));