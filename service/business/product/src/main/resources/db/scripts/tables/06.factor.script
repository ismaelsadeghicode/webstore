begin
    execute immediate 'drop table factor';
    dbms_output.put_line('Table factor dropped');
exception
    when others then dbms_output.put_line('Table factor id not exist');
end;
/
begin
    execute immediate 'drop sequence factor_seq';
    dbms_output.put_line('Sequence factor_sql dropped');
        exception
    when others then dbms_output.put_line('Sequence factor_sql id not exist');
end;
/
create table factor(
                       id              number(19)      not null,
                       total         number(20),

                       order_tbl_id      number(19),
                       constraint      factor_pk_id     primary key (id),
                       constraint factor_fk_order_id foreign key (order_tbl_id) references order_tbl(id)
);

create sequence factor_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/