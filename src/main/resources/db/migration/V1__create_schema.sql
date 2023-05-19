create table movie (
    id bigserial,
    description varchar(255) not null,
    director varchar(255) not null,
    genres varchar(255) array not null,
    is_deleted boolean default false not null,
    length integer not null,
    name varchar(255) not null,
    primary key (id)
);

create table theater (
    id bigserial,
    capacity integer not null,
    room_type varchar(255) not null,
    primary key (id)
);

create table projection (
    id bigserial,
    is_deleted boolean default false,
    start_time timestamp(6) not null,
    ticket_price float(53) not null,
    movie_id bigint references movie,
    theater_id bigint references theater,
    available_seats integer,
    primary key (id)
);

create table "user" (
    id bigserial,
    email varchar(255) not null unique,
    password varchar(255) not null,
    role varchar(255) not null,
    username varchar(255) not null unique,
    primary key (id)
);
