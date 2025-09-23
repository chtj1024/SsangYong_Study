select	sysdate, sysdate + 1, sysdate - 1 , sysdate + 30 * 12
from		dual;

-- 월에대한 연산 : add_months()
select	add_months(sysdate, 12)
from		dual;

-- 두 날짜 간의 개월 차
select	months_between(sysdate, '2025-08-22'),
				months_between(sysdate, '2025-08-23'),
				months_between('2025-08-22', sysdate)
from		dual;

select * from car_country;
