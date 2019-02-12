create sequence hibernate_sequence start 1 increment 1;

create table company (
    id int8 not null,
    building varchar(255) not null,
    city varchar(255) not null,
    inn varchar(10) not null,
    name varchar(255) not null,
    ogrn varchar(13) not null,
    street varchar(255) not null,
    primary key (id)
    );
