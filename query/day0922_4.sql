select	sysdate, sysdate + 1, sysdate - 1 , sysdate + 30 * 12
from		dual;

-- �������� ���� : add_months()
select	add_months(sysdate, 12)
from		dual;

-- �� ��¥ ���� ���� ��
select	months_between(sysdate, '2025-08-22'),
				months_between(sysdate, '2025-08-23'),
				months_between('2025-08-22', sysdate)
from		dual;

select * from car_country;
