begin
    execute immediate ('drop table CART');
    DBMS_OUTPUT.PUT('table cart dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('CART table is not exist');
end;
/
begin
    execute immediate ('drop sequence CART_SEQUENCE ');
    DBMS_OUTPUT.PUT_LINE('sequence CART_SEQUENCE dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('CART_sequence is not exist');
end;
/
create TABLE CART

(
    /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set--sequence is not set
    id number(19) not null ,
     total number(20) not null ,
    constraint cart_pk_id primary key (id)

);

create SEQUENCE CART_SEQUENCE
    minvalue 1 maxvalue 9999999999999999999 cycle
    start with 1 increment by 1 cache 100;