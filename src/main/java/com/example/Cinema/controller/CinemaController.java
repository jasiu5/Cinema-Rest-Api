package com.example.Cinema.controller;

import com.example.Cinema.service.CinemaService;
import com.example.Cinema.entity.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/screenings")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService ss){
        this.cinemaService = ss;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getScreening(){
        return ResponseEntity.status(HttpStatus.OK).body(cinemaService.findAllScreening());
    }

    @GetMapping
    public ResponseEntity<?> getScreeningByDate(@RequestParam Date date, @RequestParam Time time){
        return ResponseEntity.status(HttpStatus.OK).body(cinemaService.findAllScreeningByDate(date, time));
    }

    @GetMapping("/seats")
    public ResponseEntity<?> getSeats(@RequestParam int screeningId){
        return ResponseEntity.status(HttpStatus.OK).body(cinemaService.getSeats(screeningId));
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> reserve(@RequestBody Reservation reservation){
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.reserve(reservation));
    }


}
