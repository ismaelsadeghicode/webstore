begin
    execute immediate 'drop table wallet';
    DBMS_OUTPUT.PUT_LINE('Table wallet dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table wallet did not exist');
end ;
begin
    execute immediate 'drop sequence wallet_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence wallet_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence wallet_seq did not exist');
end;

create table wallet
(
    id           number(19)   not null,
    bank_id      number(19)   not null,
    name         varchar(100) not null,
    amount       number(19)   not null,
    inn          varchar(100) not null,
    remarks      varchar(100) not null,
    lock_version number(19)   not null,
    constraint wallet_pk_id primary key (id),
    constraint wallet_fk_bank_id foreign key (bank_id) references bank (id)
);
create sequence wallet_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;