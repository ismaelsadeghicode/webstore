begin
    execute immediate 'drop table bank';
    DBMS_OUTPUT.PUT_LINE('Table bank dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table bank did not exist');
end ;
begin
    execute immediate 'drop sequence bank_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence bank_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence bank_seq did not exist');
end;

create table bank
(
    id           number(19) not null,
    user_id      number(19) not null,
    card_no      number(19) not null,
    lock_version number(19) not null,
    constraint bank_pk_id primary key (id)
);
create sequence bank_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;