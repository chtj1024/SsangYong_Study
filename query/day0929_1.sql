select * from user_sequences;

select	seq_empno.currval
from		dual;

select	seq_empno.nextval
from		dual;

select * from emp_view2;

select * from user_views;

select * from user_indexes
where		table_name = 'CP_ZIPCODE';

--인덱스 리빌드
alter index ind_zipcode rebuild;


--인덱스 생성
-- 컬럼의 값이 유일해야 한다.

create unique index ind_cp_emp4 on cp_emp4(empno);

--중복값을 삭제 한 후 인덱스를 생성.
delete from cp_emp4 where empno;

select * from cp_emp4;
-- 유니크 인덱스가 설정되어 있다면 중복값이 입력되지 않는다.
insert into cp_emp4(empno, ename) values(7521, '테스트');

select * from user_ind_columns;

--인덱스 삭제
drop index ind_cp_emp4;
--desc 인덱스
create unique index ind_cp_emp4 on cp_emp4(empno desc);

-- 직무 컬럼 non_unique 인덱스
create index ind_cp_emp4_job on cp_emp4(job);

select * from user_ind_columns
where		table_name = 'CP_EMP4';

select * from user_indexes
where		table_name = 'CP_EMP4';

create table test_bitmap as
(select item_num, item_name from primary_multi);

--비트맵 인덱스 : non-unique index 계열
create bitmap index ind_test_bitmap on test_bitmap(item_num);

select * from test_bitmap;
--중복 값이 존재하긴 하지만 컬럼의 값이 독특한 형태.
insert into test_bitmap(item_num, item_name)
values('I_000009', '아이템2');

select * from user_indexes
where		table_name = 'TEST_BITMAP';

--composite index : 여러 컬럼에 하나의 인덱스를 구성할 때
create table test_composite as (select * from primary_multi);

select * from test_composite;

create unique index ind_test_composite
on test_composite(item_num, prd_id);

select * from user_indexes
where table_name = 'TEST_COMPOSITE';

select * from user_ind_columns
where table_name = 'TEST_COMPOSITE';

--index가 설정되면 index 정책에 위배되는 값은 추가할 수 없다.
insert into test_composite(ITEM_NUM, PRD_ID, ITEM_NAME)
values('I_000022', '아이디', '아이템명');

select * from TEST_COMPOSITE;