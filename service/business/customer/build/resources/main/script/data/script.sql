begin
    drop table if exists customer CASCADE
    drop table if exists legal_customer CASCADE
    drop table if exists real_customer CASCADE
    drop sequence if exists hibernate_sequence
    create sequence hibernate_sequence start with 1 increment by 1
end;
begin
    create table customer (
       id bigint not null,
        code bigint,
        insert_local_time timestamp,
        lock_version bigint,
        national_code bigint,
        remark varchar(255),
        type varchar(255),
        legal_customer_id bigint,
        real_customer_id bigint,
        primary key (id)
    )
end;
begin
    create table legal_customer (
       id bigint not null,
        economic_code bigint,
        email_address varchar(255),
        name_en varchar(255),
        name_fa varchar(255),
        phone_number varchar(255),
        status varchar(255),
        website varchar(255),
        customer_id bigint,
        primary key (id)
    )
end;
begin
    create table real_customer (
       id bigint not null,
        birth_date timestamp,
        email_address varchar(255),
        firstname varchar(255),
        gender boolean,
        lastname varchar(255),
        phone_number varchar(255),
        status varchar(255),
        customer_id bigint,
        primary key (id)
    )
end;
begin
    alter table legal_customer
       add constraint FKm4r9hw6iv04f2ulkswq6nvfnt
       foreign key (customer_id)
       references customer
end;
begin
    alter table real_customer
       add constraint FKhjsfejj8hnfe0ryhln4xfxwk
       foreign key (customer_id)
       references customer
end;
begin
     alter table customer
       add constraint FKjv6xkraqx4cv6xked4qcgofvl
       foreign key (legal_customer_id)
       references legal_customer
end;
begin
    alter table customer
       add constraint FKq72wtxuhf0ibcr4jmblfu1vb1
       foreign key (real_customer_id)
       references real_customer
end;