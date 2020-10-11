begin
    execute immediate 'drop table product';
    dbms_output.put_line('Table product dropped');
exception
    when others then dbms_output.put_line('Table product id not exist');
end;
/
begin
    execute immediate 'drop sequence product_seq';
    dbms_output.put_line('Sequence product_sql dropped');
        exception
    when others then dbms_output.put_line('Sequence product_sql id not exist');
end;
/
create table product(
                        id              number(19)      not null,
                        name         varchar(255),
                        price         number(20),
                        avatar         varchar(255),
                        stock         number(20),
                        group_id      number(19),
                        constraint      product_pk_id     primary key (id),
                        constraint product_fk_group_id foreign key (group_id) references GROUP_TBL(id)
);

create sequence product_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/
begin
    execute immediate 'drop table product';
    dbms_output.put_line('Table product dropped');
exception
    when others then dbms_output.put_line('Table product id not exist');
end;
/
begin
    execute immediate 'drop sequence product_seq';
    dbms_output.put_line('Sequence product_sql dropped');
exception
    when others then dbms_output.put_line('Sequence product_sql id not exist');
end;
/
create table product(
                        id              number(19)      not null,
                        name         varchar(255),
                        price         number(20),
                        avatar         varchar(255),
                        stock         number(20),
                        group_id      number(19),
                        constraint      product_pk_id     primary key (id),
                        constraint product_fk_group_id foreign key (group_id) references GROUP_TBL(id)
);

create sequence product_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/