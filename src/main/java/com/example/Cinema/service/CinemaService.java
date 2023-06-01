package com.example.Cinema.service;

import com.example.Cinema.exception.NameException;
import com.example.Cinema.entity.Reservation;
import com.example.Cinema.dto.ReservationDetails;
import com.example.Cinema.entity.Screening;
import com.example.Cinema.entity.Seat;
import com.example.Cinema.exception.SeatException;
import com.example.Cinema.exception.TimeException;
import com.example.Cinema.repository.ReservationRepository;
import com.example.Cinema.repository.ScreeningRepository;
import com.example.Cinema.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class CinemaService {

    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;

    public CinemaService(ScreeningRepository screeningRepository, SeatRepository seatRepository, ReservationRepository reservationRepository) {
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Screening> findAllScreening(){
        return screeningRepository.findAll();
    }

    public List<Seat> getSeats(int screening_id){
        return seatRepository.getSeats(screening_id);
    }

    public List<Screening> findAllScreeningByDate(Date date, Time time){
        return screeningRepository.getScreeningByDate(date, time);
    }

    public ReservationDetails reserve(Reservation reservation) throws NameException {
        if (seatRepository.ifReserved(reservation.getSeatId())){
            throw new SeatException("This seat is already reserved");
        }
        if (reservation.getName().length() < 3 || reservation.getSurname().length() < 3) {
            throw new NameException("Name and surname should be at least 3 letters");
        }
        LocalTime currentTime = LocalTime.now();
        LocalTime givenTime = screeningRepository.getScreeningTime(reservation.getScreeningId());
        long differenceInMinutes = ChronoUnit.MINUTES.between(currentTime, givenTime);

        if (differenceInMinutes < 16){
            throw new TimeException("Cannot reserve, it's too late.");
        }
        if (!canReserve(seatRepository.getSeatNumber(reservation.getSeatId()), reservation.getScreeningId())){
            throw new SeatException("There cannot be a single place left over in a row between two already reserved\n" +
                    "places.");
        }
        double amountToPay = 0;
        if (reservation.getTicketType().equalsIgnoreCase("adult")) amountToPay = 25;
        else if (reservation.getTicketType().equalsIgnoreCase("student")) {
            amountToPay = 18;
        }
        else if (reservation.getTicketType().equalsIgnoreCase("child")) amountToPay = 12.5;

        LocalDateTime expTime = LocalDateTime.now().plusMinutes(60);
        reservationRepository.save(reservation);
        seatRepository.reserveSeat(reservation.getSeatId());
        return new ReservationDetails(amountToPay, expTime);
    }

    public boolean canReserve(int seatNumber, int screeningId) {
        boolean ifTwoRightReserved, ifRightReserved, ifTwoLeftReserved, ifLeftReserved;
        try {
            ifTwoRightReserved = seatRepository.ifReserved(seatNumber + 2, screeningId);
            ifRightReserved = seatRepository.ifReserved(seatNumber + 1, screeningId);
            if ((ifTwoRightReserved && !ifRightReserved &&
                    seatRepository.getRowNumber(seatNumber + 2, screeningId) ==
                            seatRepository.getRowNumber(seatNumber, screeningId))){
                return false;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        try {
            ifTwoLeftReserved = seatRepository.ifReserved(seatNumber - 2, screeningId);
            ifLeftReserved = seatRepository.ifReserved(seatNumber - 1, screeningId);
            if ((ifTwoLeftReserved && !ifLeftReserved &&
                    seatRepository.getRowNumber(seatNumber - 2, screeningId) ==
                            seatRepository.getRowNumber(seatNumber, screeningId))) {
                return false;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return true;

    }
}
