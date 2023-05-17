create table reservation(
    id bigserial not null,
    user_id bigint,
    projection_id bigint,
    isCanceled boolean default false not null,
    primary key (id)
);

alter table if exists reservation add constraint FKxythcvh43xg65dtdycuctfhy5 foreign key (projection_id) references projection;
alter table if exists reservation add constraint FKiyfyfiuyiuyfydf563dh6dyhg foreign key (user_id) references "user";
