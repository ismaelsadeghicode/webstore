begin
    execute immediate 'drop table group_tbl';
    dbms_output.put_line('Table group_tbl dropped');
exception
    when others then dbms_output.put_line('Table group_tbl id not exist');
end;
/
begin
    execute immediate 'drop sequence group_tbl_seq';
    dbms_output.put_line('Sequence group_tbl_sql dropped');
        exception
    when others then dbms_output.put_line('Sequence group_tbl_sql id not exist');
end;
/
create table group_tbl(
                          id              number(19)      not null,
                          name          varchar(255),
                          description          varchar(255),
                          category_id  number(19) not null ,
                          constraint      group_tbl_pk_id     primary key (id),
                          constraint group_tbl_fk_category_id foreign key (category_id) references category(id)
);

create sequence group_tbl_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/