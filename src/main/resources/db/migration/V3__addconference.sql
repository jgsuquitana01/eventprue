create table if not exists conference(
    id serial primary key,
    tittle varchar(50) not null,
    speaker varchar(50) not null,
    hours time not null,
    total_attendees int,
    event_id int not null,
    foreign key (event_id) references event(id)
);