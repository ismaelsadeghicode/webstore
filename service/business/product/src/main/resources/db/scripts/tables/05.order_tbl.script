begin
    execute immediate ('drop table order_tbl');
    DBMS_OUTPUT.PUT('table order_tbl dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('order_tbl table is not exist');
end;
/
begin
    execute immediate ('drop sequence order_tbl_SEQUENCE ');
    DBMS_OUTPUT.PUT_LINE('sequence order_tbl_SEQUENCE dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('order_tbl_sequence is not exist');
end;
/
create TABLE order_tbl

(
    /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set--sequence is not set
    id number(19) not null ,
     cart_id number(19) not null ,
     constraint order_tbl_fk_cart_id foreign key (cart_id) references cart(id),
    constraint order_tbl_pk_id primary key (id)

);

create SEQUENCE order_tbl_SEQUENCE
    minvalue 1 maxvalue 9999999999999999999 cycle
    start with 1 increment by 1 cache 100;