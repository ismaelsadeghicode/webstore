begin
    execute immediate ('drop table user');
    DBMS_OUTPUT.PUT('table user dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('user table is not exist');
end;
/
begin
    execute immediate ('drop sequence user_SEQUENCE ');
    DBMS_OUTPUT.PUT_LINE('sequence user_SEQUENCE dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('user_sequence is not exist');
end;
/
create TABLE user

(
    /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set--sequence is not set
    id number(19) not null ,
    total number(20) not null ,
    constraint user_pk_id primary key (id)

);

create SEQUENCE user_SEQUENCE
    minvalue 1 maxvalue 9999999999999999999 cycle
    start with 1 increment by 1 cache 100;
