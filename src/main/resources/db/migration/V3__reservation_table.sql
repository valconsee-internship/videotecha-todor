create table reservation(
    id bigserial,
    user_id bigint references "user",
    projection_id bigint references projection,
    number_of_tickets integer,
    is_canceled boolean default false,
    primary key (id)
);
