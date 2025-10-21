
--바인드 변수 선언
var num_out number
var msg varchar2(100)

--실행
exec plus(10, 20, :num_out, :msg);

print num_out
print msg
