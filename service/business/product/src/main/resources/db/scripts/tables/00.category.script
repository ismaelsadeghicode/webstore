begin
    execute immediate 'drop table category';
    dbms_output.put_line('Table Category dropped');
exception
    when others then dbms_output.put_line('Table Category id not exist');
end;

begin
    execute immediate 'drop sequence category_seq';
    dbms_output.put_line('Sequence Category dropped');
        exception
    when others then dbms_output.put_line('Sequence Category id not exist');
end;

create table category(
                         id              number(19)      not null,
                         title          varchar(255),
                         discription     varchar(255),
                         constraint      category_pk_id     primary key (id)
);

create sequence category_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/