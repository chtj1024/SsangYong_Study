select * from user_procedures;

/* �ΰ��� ���� �Է¹޾Ƽ� �ջ��� ����� ��ȯ�ϴ� procedure */

create or replace procedure plus(
	num 	in number,
	num2 	in number,
	num_out out number,
	msg out varchar2)
is
	-- ���� ����, cursor����, recode ����, table ����
	temp_msg varchar2(100);
begin
  -- �ڵ� �ۼ�
  num_out := num + num2;

  temp_msg := '�ȳ�? ������ ' || to_char(sysdate, 'yyyy-mm-dd') || '�Դϴ�.';

  msg := temp_msg;
end;
