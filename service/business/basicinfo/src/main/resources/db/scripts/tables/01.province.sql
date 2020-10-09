begin
    execute immediate 'drop table province';
    DBMS_OUTPUT.PUT_LINE('Table province dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table province did not exist');
end ;
begin
    execute immediate 'drop sequence province_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence province_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence province_seq did not exist');
end;

create table province
(
    id             number(19)   not null,
    country_id     number(19)   not null,
    name           varchar(100) not null,
    code           varchar(100) not null,
    alphabet2_code varchar(100) not null,
    alphabet3_code varchar(100) not null,
    remarks        varchar(100) not null,
    lock_version   number(19)   not null,
    constraint province_pk_id primary key (id),
    constraint province_fk_country_id foreign key (country_id) references country (id)
);
create sequence province_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;