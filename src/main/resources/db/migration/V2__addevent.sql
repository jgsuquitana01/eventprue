create table if not exists event(
    id serial primary key,
    description varchar(50) not null,
    start_date date not null,
    end_date date not null,
    city varchar(20),
    total_attendees int
);