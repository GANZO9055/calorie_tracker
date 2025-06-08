CREATE TABLE food_intake (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    dish_id INT REFERENCES dishs(id)
);