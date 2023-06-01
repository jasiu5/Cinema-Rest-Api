CREATE TABLE IF NOT EXISTS Room(
    room_id SERIAL PRIMARY KEY,
    room_name VARCHAR NOT NULL,
    capacity INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Movie(
    movie_id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Screening(
    screening_id SERIAL PRIMARY KEY,
    movie_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    screening_date DATE NOT NULL,
    FOREIGN KEY (movie_id)
    REFERENCES movie(movie_id),
    FOREIGN KEY (room_id)
    REFERENCES room(room_id)
);

CREATE TABLE IF NOT EXISTS Seat(
    seat_id SERIAL PRIMARY KEY,
    room_id INTEGER NOT NULL,
    screening_id INTEGER,
    seat_number INTEGER NOT NULL,
    row_number INTEGER NOT NULL,
    reserved BOOLEAN NOT NULL DEFAULT false,
    FOREIGN KEY (room_id)
    REFERENCES room(room_id),
    FOREIGN KEY (screening_id)
    REFERENCES screening(screening_id)
    );

CREATE TABLE IF NOT EXISTS Reservation(
    reservation_id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    ticket_type VARCHAR NOT NULL,
    paid BOOLEAN NOT NULL DEFAULT false,
    screening_id INTEGER NOT NULL,
    seat_id INTEGER NOT NULL,
    FOREIGN KEY (screening_id)
    REFERENCES screening(screening_id),
    FOREIGN KEY (seat_id)
    REFERENCES seat(seat_id)
);