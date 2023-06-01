-- Inserting sample data into cinema_rooms table
INSERT INTO room (room_id, room_name, capacity)
VALUES (1, 'Room A', 100),
       (2, 'Room B', 100),
       (3, 'Room C', 100);

INSERT INTO movie (title)
VALUES ('Pulp Fiction'),
        ('Forrest Gump'),
        ('Parasite');


INSERT INTO screening (movie_id, room_id, start_time, end_time, screening_date)
VALUES (1, 1, '12:45', '14:45', '2023-06-10'),
(1, 1, '19:45', '20:45', '2023-06-10'),
(2, 2, '13:30', '16:00', '2023-06-10'),
(2, 2, '20:00', '22:30', '2023-06-10'),
(3, 3, '17:15', '19:00', '2023-06-10'),
(3, 3, '10:00', '12:15', '2023-06-10');


DO '
    DECLARE
        room_id INTEGER := 1; -- Adjust the room_id for each room
        screening_id INTEGER := 1;
        total_rows INTEGER := 5;
        seats_per_row INTEGER := 10;
        start_seat INTEGER := 1;
    BEGIN
        FOR row_number IN 1..total_rows LOOP
                FOR seat_number IN start_seat..start_seat + seats_per_row - 1 LOOP
                        INSERT INTO seat (room_id, screening_id, row_number, seat_number)
                        VALUES (room_id, screening_id, row_number, seat_number);
                    END LOOP;
                start_seat := start_seat + seats_per_row;
            END LOOP;
    END ;';

DO '
DECLARE
    room_id INTEGER := 1; -- Adjust the room_id for each room
    screening_id INTEGER := 2;
    total_rows INTEGER := 5;
    seats_per_row INTEGER := 10;
    start_seat INTEGER := 1;
BEGIN
    FOR row_number IN 1..total_rows LOOP
            FOR seat_number IN start_seat..start_seat + seats_per_row - 1 LOOP
                    INSERT INTO seat (room_id, screening_id, row_number, seat_number)
                    VALUES (room_id, screening_id, row_number, seat_number);
                END LOOP;
            start_seat := start_seat + seats_per_row;
        END LOOP;
END ;';


DO '
DECLARE
    room_id INTEGER := 2; -- Adjust the room_id for each room
    screening_id INTEGER := 3;
    total_rows INTEGER := 5;
    seats_per_row INTEGER := 10;
    start_seat INTEGER := 1;
BEGIN
    FOR row_number IN 1..total_rows LOOP
            FOR seat_number IN start_seat..start_seat + seats_per_row - 1 LOOP
                    INSERT INTO seat (room_id, screening_id, row_number, seat_number)
                    VALUES (room_id, screening_id, row_number, seat_number);
                END LOOP;
            start_seat := start_seat + seats_per_row;
        END LOOP;
END ;';


DO '
DECLARE
    room_id INTEGER := 2; -- Adjust the room_id for each room
    screening_id INTEGER := 4;
    total_rows INTEGER := 5;
    seats_per_row INTEGER := 10;
    start_seat INTEGER := 1;
BEGIN
    FOR row_number IN 1..total_rows LOOP
            FOR seat_number IN start_seat..start_seat + seats_per_row - 1 LOOP
                    INSERT INTO seat (room_id, screening_id, row_number, seat_number)
                    VALUES (room_id, screening_id, row_number, seat_number);
                END LOOP;
            start_seat := start_seat + seats_per_row;
        END LOOP;
END ;';


DO '
DECLARE
    room_id INTEGER := 3; -- Adjust the room_id for each room
    screening_id INTEGER := 5;
    total_rows INTEGER := 5;
    seats_per_row INTEGER := 10;
    start_seat INTEGER := 1;
BEGIN
    FOR row_number IN 1..total_rows LOOP
            FOR seat_number IN start_seat..start_seat + seats_per_row - 1 LOOP
                    INSERT INTO seat (room_id, screening_id, row_number, seat_number)
                    VALUES (room_id, screening_id, row_number, seat_number);
                END LOOP;
            start_seat := start_seat + seats_per_row;
        END LOOP;
END ;';


DO '
DECLARE
    room_id INTEGER := 3; -- Adjust the room_id for each room
    screening_id INTEGER := 6;
    total_rows INTEGER := 5;
    seats_per_row INTEGER := 10;
    start_seat INTEGER := 1;
BEGIN
    FOR row_number IN 1..total_rows LOOP
            FOR seat_number IN start_seat..start_seat + seats_per_row - 1 LOOP
                    INSERT INTO seat (room_id, screening_id, row_number, seat_number)
                    VALUES (room_id, screening_id, row_number, seat_number);
                END LOOP;
            start_seat := start_seat + seats_per_row;
        END LOOP;
END ;';

