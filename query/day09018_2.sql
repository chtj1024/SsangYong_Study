--����
select * from student;

--�л����̺��� ��� �л��� ���� 'B'������ ����
update  student
set			class='B';

rollback;

--�л����̺��� 1���л��� Ű�� 174.3����, �ּҸ� ��⵵ ������ ���������� ����.
update  student
set			height=174.3, address='��⵵ ������ ����������'
where   num=1;
commit;

select * from student;


insert into student
(NUM, NAME, TEL, ADDRESS, CLASS, HEIGHT, WEIGHT, INPUT_DATE)
values(4,'���','010-xxxx-xxxx','����� ���빮�� ���빮��','Z',
	182.9, 67.2,'2025-09-18');
commit;

update student
set       class='D'
where num=4;
commit;


 select * from student;


 --�л����̺��� �л��� ��ȣ�� 2�� �̸鼭 �̸��� '����'�� �л���
 --��ȭ��ȣ�� 010-9876-5432��, ���� 'E', Ű�� 186.3����, �̸��� '���'�� ����

 --����
 --�л� ���̺� ��� ���ڵ带 ����.
delete from student;
rollback;

-- �л��� ��ȣ�� 4���� �л��� ���ڵ带 ����.
delete from student
where 	num=4;
commit;
select * from student;

--�л����̺��� ��ȣ�� 3���̸鼭 Ű�� 152.9�� �л��Ƿ��ڵ带 ����. (���)


--���̺� ����
--�л����̺��� ��� ���ڵ带 ����
truncate table student;

rollback;
select * from student;

----drop----------------------
--�л����̺� ����
drop table student;

select * from tab;

select * from BIN$R7xXAa2lRYSMFWV14ZJK+g==$0;

--�����뿡 ���뺸��
show recyclebin;

--������ ����
purge recyclebin;


select * from tab;

drop table emp;


flashback table emp to before drop;







