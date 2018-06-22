create user smile02 identified by 11111111;
--drop user smile02 

grant dba to smile02;

--diary
create table diary(
    id number primary key,
    u_id varchar2(15),
    title varchar2(50),
    content clob not null,
    regdate date not null
);

create sequence seq_diary_id;



insert into diary
    values (seq_diary_id.nextval, 'bestuser', 'ù��° �ϱ�','���� ���� ����', sysdate);
insert into diary
    values (seq_diary_id.nextval, 'hyeon', '�ι�° �ϱ�','������Ʈ ����', sysdate);
insert into diary
    values (seq_diary_id.nextval, 'hyeon', '����° �ϱ�','������Ʈ ���� ��', sysdate);
    
--commit;

select * from diary;

--delete diary;

--member

create table member(
    id varchar2(10) primary key,
    password varchar2(10) not null,
    name varchar2(30) not null,
    email varchar2(30) not null unique,
    gender char(1) check(gender in('m','f'))    
);

insert into member
    values ('hyeon','qwer1234','������','smile@naver.com','m');
    
select * from member;
--delete from member;
--commit;

alter table diary add constraint fk_diary_u_id foreign key(u_id) references member(id);
-------------------------------------------------------------------------------
