CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    duration INT NOT NULL,
    genre VARCHAR(50)
);

CREATE TABLE halls (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE sessions (
    id SERIAL PRIMARY KEY,
    movie_id INT REFERENCES movies(id),
    hall_id INT REFERENCES halls(id)
);

CREATE TABLE tickets (
    id SERIAL PRIMARY KEY,
    session_id INT REFERENCES sessions(id),
    seat_number INT NOT NULL,
    customer_name VARCHAR(100),
    price NUMERIC(10,2),
    ticket_type VARCHAR(20) NOT NULL
);
