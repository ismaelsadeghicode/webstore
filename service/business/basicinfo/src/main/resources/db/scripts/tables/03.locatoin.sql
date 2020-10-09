begin
    execute immediate 'drop table location';
    DBMS_OUTPUT.PUT_LINE('Table location dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table location did not exist');
end ;
begin
    execute immediate 'drop sequence location_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence location_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence location_seq did not exist');
end;

create table location
(
    id           number(19)   not null,
    city_id      number(19)   not null,
    title        varchar(100) not null,
    address      varchar(100) not null,
    latitude     varchar(100) not null,
    longitude    varchar(100) not null,
    remarks      varchar(100) not null,
    lock_version number(19)   not null,
    constraint location_pk_id primary key (id),
    constraint location_fk_account_id foreign key (city_id) references city (id)
);
create sequence location_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;