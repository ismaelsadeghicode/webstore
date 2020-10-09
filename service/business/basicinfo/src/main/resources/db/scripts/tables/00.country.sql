begin
    execute immediate 'drop table country';
    DBMS_OUTPUT.PUT_LINE('Table country dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table country did not exist');
end ;
begin
    execute immediate 'drop sequence country_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence country_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence country_seq did not exist');
end;

create table country
(
    id             number(19)   not null,
    name           varchar(100) not null,
    numeric_code   varchar(100) not null,
    alphabet2_code varchar(100) not null,
    alphabet3_code varchar(100) not null,
    remarks        varchar(100) not null,
    lock_version   number(19)   not null,
    constraint country_pk_id primary key (id)
);
create sequence country_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;