package com.example.Cinema.repository;

import com.example.Cinema.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Modifying
    @Query(value= "UPDATE Seat s SET s.reserved = true WHERE s.seatId = :seatId")
    void reserveSeat(@Param("seatId") int seatId);
    @Query(value = "SELECT s FROM Seat s WHERE s.screeningId = :screeningId")
    List<Seat> getSeats(@Param("screeningId") int screeningId);

    @Query(value = "SELECT s.reserved FROM Seat s WHERE s.seatNumber = :seatNumber and s.screeningId = :screeningId")
    boolean ifReserved(@Param("seatNumber") int seatNumber, @Param("screeningId") int screeningId);

    @Query(value = "SELECT s.reserved FROM Seat s WHERE s.seatId = :seatId")
    boolean ifReserved(@Param("seatId") int seatId);

    @Query(value = "SELECT s.rowNumber FROM Seat s WHERE s.seatNumber = :seatNumber and s.screeningId = :screeningId")
    int getRowNumber(@Param("seatNumber") int seatNumber, @Param("screeningId") int screeningId);

    @Query(value = "SELECT s.seatNumber FROM Seat s WHERE s.id = :seatId")
    int getSeatNumber(@Param("seatId") int seatId);
}
