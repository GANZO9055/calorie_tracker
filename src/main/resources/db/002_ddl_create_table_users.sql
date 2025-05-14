create table users (
    id serial primary key,
    name char(255),
    email unique char(255),
    age int,
    weight decimal,
    height decimal,
    goal char(255),
    password char(255)
);