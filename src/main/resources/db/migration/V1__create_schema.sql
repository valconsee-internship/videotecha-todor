create table movie (
    id bigserial not null,
    description varchar(255) not null,
    director varchar(255) not null,
    genres varchar(255) array not null,
    is_deleted boolean default false not null,
    length integer not null,
    name varchar(255) not null,
    primary key (id)
);

create table theater (
    id bigserial not null,
    capacity integer not null,
    room_type varchar(255) not null,
    primary key (id)
);

create table projection (
    id bigserial not null,
    is_deleted boolean default false not null,
    start_time timestamp(6) not null,
    ticket_price float(53) not null,
    movie_id bigint,
    theater_id bigint,
    primary key (id)
);

create table "user" (
    id bigserial not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    role varchar(255) not null,
    username varchar(255) not null unique,
    primary key (id)
);

alter table if exists projection add constraint FKfq7qvxymc33m8307wc5qfpci1 foreign key (movie_id) references movie;
alter table if exists projection add constraint FKsjyk0b58vkutgmg9ddyscp5uy foreign key (theater_id) references theater;
