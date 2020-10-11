begin
    execute immediate ('drop table cart_item');
    DBMS_OUTPUT.PUT('table cart_item dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('cart_item table is not exist');
end;
/
begin
    execute immediate ('drop sequence cart_item_SEQUENCE ');
    DBMS_OUTPUT.PUT_LINE('sequence cart_item_SEQUENCE dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('cart_item_sequence is not exist');
end;
/
create TABLE cart_item

(
    /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set--sequence is not set
    id number(19) not null ,
     product_id number(19) not null ,
     cart_id number(19) not null,
     constraint cart_item_fk_product_id foreign key (product_id) references product(id),
    constraint cart_item_fk_cart_id foreign key (cart_id) references cart(id),
    constraint cart_item_pk_id primary key (id)

);

create SEQUENCE cart_item_SEQUENCE
    minvalue 1 maxvalue 9999999999999999999 cycle
    start with 1 increment by 1 cache 100;