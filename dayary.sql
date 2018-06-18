create user smile02 identified by 11111111;

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
    values (seq_diary_id.nextval, 'hyeon', 'ù��° �ϱ�','���� ���� ����', sysdate);
insert into diary
    values (seq_diary_id.nextval, 'hyeon', '�ι�° �ϱ�','������Ʈ ����', sysdate);
    
--commit;