begin
    execute immediate 'drop table city';
    DBMS_OUTPUT.PUT_LINE('Table city dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table city did not exist');
end ;
begin
    execute immediate 'drop sequence city_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence city_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence city_seq did not exist');
end;

create table city
(
    id           number(19)   not null,
    province_id  number(19)   not null,
    name         varchar(100) not null,
    code         varchar(100) not null,
    remarks      varchar(100) not null,
    lock_version number(19)   not null,
    constraint pcity_pk_id primary key (id),
    constraint city_fk_province_id foreign key (province_id) references province (id)
);
create sequence city_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;