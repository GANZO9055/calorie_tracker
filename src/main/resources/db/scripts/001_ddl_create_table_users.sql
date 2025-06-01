create table users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT NOT NULL,
    weight DECIMAL NOT NULL,
    height DECIMAL NOT NULL,
    goal VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);