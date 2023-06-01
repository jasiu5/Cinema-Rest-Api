package com.example.Cinema.entity;


import jakarta.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private int reservationId;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="ticket_type")
    private String ticketType;
    @Column(name="paid")
    private boolean paid;
    @Column(name="seat_id")
    private int seatId;
    @Column(name="screening_id")
    private int screeningId;

    public Reservation(int reservationId, String name, String surname, String ticketType, boolean paid, int seatId, int screeningId) {
        this.reservationId = reservationId;
        this.setName(name);
        this.setSurname(surname);
        this.ticketType = ticketType;
        this.paid = paid;
        this.seatId = seatId;
        this.screeningId = screeningId;
    }

    public Reservation() {
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null){
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null){
            surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        }
        this.surname = surname;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }
}
