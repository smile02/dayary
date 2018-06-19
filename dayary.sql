create user smile02 identified by 11111111;
--drop user smile02 

grant dba to smile02;

create table diary(
    id number primary key,
    u_id varchar2(15),
    title varchar2(50),
    content clob not null,
    regdate date not null
);

create sequence seq_diary_id;

insert into diary
    values (seq_diary_id.nextval, 'hyeon', '첫번째 일기','점심 점심 점심', sysdate);
insert into diary
    values (seq_diary_id.nextval, 'hyeon', '두번째 일기','프로젝트 시작', sysdate);
insert into diary
    values (seq_diary_id.nextval, 'hyeon', '세번째 일기','프로젝트 진행 중', sysdate);
    
--commit;

select * from diary;

delete diary;