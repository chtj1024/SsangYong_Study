select * from user_procedures;

/* 두개의 수를 입력받아서 합산한 결과를 반환하는 procedure */

create or replace procedure plus(
	num 	in number,
	num2 	in number,
	num_out out number,
	msg out varchar2)
is
	-- 변수 선언, cursor선언, recode 선언, table 선언
	temp_msg varchar2(100);
begin
  -- 코드 작성
  num_out := num + num2;

  temp_msg := '안녕? 오늘은 ' || to_char(sysdate, 'yyyy-mm-dd') || '입니다.';

  msg := temp_msg;
end;
