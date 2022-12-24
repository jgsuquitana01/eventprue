create table if not exists register(
    id serial primary key,
    nombres varchar(50) not null,
    email varchar(50) unique,
    institucion varchar(50),
    cargo varchar(20)
);
