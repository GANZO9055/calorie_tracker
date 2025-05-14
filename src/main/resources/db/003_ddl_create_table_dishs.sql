create table dishs (
    id serial primary key,
    name unique char(255)
    calories int,
    protein int,
    fat int,
    carbs int,
    user_id int references users(id)
);