begin
    execute immediate 'drop table history_transaction';
    DBMS_OUTPUT.PUT_LINE('Table history_transaction dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table history_transaction did not exist');
end ;
begin
    execute immediate 'drop sequence history_transaction_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence history_transaction_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence history_transaction_seq did not exist');
end;

create table history_transaction
(
    id          number(19) not null,
    bank_id     number(19) not null,
    wallet_id   number(19) not null,
    create_time timestamp  not null,
    is_done     varchar(1) not null,
    constraint history_transaction_pk_id primary key (id),
    constraint history_transaction_fk_bank_id foreign key (bank_id) references bank (id),
    constraint history_t_fk_wallet_id foreign key (wallet_id) references wallet (id),
    constraint history_t_ch_a check (is_done in ('e', 'd'))
);
create sequence history_transaction_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;