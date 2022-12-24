create table if not exists member_event(
    id serial primary key,
    code int unique,
    registred_at date not null,
    register boolean not null,
    register_id int not null,
    conference_id int not null,
    foreign key (register_id) references register(id),
    foreign key (conference_id) references conference(id)
);