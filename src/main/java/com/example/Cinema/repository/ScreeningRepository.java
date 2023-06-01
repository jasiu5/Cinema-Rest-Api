package com.example.Cinema.repository;

import com.example.Cinema.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    @Query(value = "SELECT s FROM Screening s WHERE s.screeningDate = :date and s.startTime > :time ORDER BY movie.title, s.startTime")
    List<Screening> getScreeningByDate(@Param("date") Date date, Time time);
    @Query(value = "SELECT s.startTime FROM Screening s WHERE s.id = :screeningId")
    LocalTime getScreeningTime(@Param("screeningId") int screeningId);

}
