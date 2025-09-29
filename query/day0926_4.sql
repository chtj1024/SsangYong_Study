-- index
--모든 레코드를 레코드를 식별하기위한 주소 (rowid)를 가진다.
select rowid, empno
from emp;

select	rowid, deptno ,dname,loc
from		dept;

select  rowid, zipcode,sido,gugun
from 		zipcode;

-- 생성된 index를 확인할 수 있는 DD
select  *
from		user_indexes;

select *
from user_ind_columns;


create table cp_zipcode as ( select * from zipcode );

create unique index ind_zipcode on cp_zipcode ( seq );

select * from user_indexes
where table_name in('ZIPCODE', 'CP_ZIPCODE');

--zipcode 테이블에서 seq가 45000~45100사이의 우편번호 검색.
--index 를 사용하지 않은 테이블
select	zipcode,sido, gugun, dong, bunji, seq
from		zipcode
where		seq between 45000 and 45100;
--index를 사용한 테이블

select	zipcode,sido, gugun, dong, bunji, seq
from		cp_zipcode
where		seq between 45000 and 45100;




