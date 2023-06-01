package com.example.Cinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seat")
public class Seat {
    @Id
    @GeneratedValue
    @Column(name="seat_id")
    private int seatId;
    @Column(name="seat_number")
    private int seatNumber;
    @Column(name="row_number")
    private int rowNumber;
    @Column(name="reserved")
    private boolean reserved;
    @Column(name = "screening_id")
    private int screeningId;
    @OneToOne()
    @JoinColumn(name="room_id")
    private Room room;
//    @OneToOne()
//    @JoinColumn(name="screening_id")
//    private Screening screening;

//    public Screening getScreening() {
//        return screening;
//    }
//
//    public void setScreening(Screening screening) {
//        this.screening = screening;
//    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public Seat(int seatId, int seatNumber, int rowNumber, boolean reserved, Room room, int screeningId) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.reserved = reserved;
        this.room = room;
        this.screeningId = screeningId;
    }

    public Seat() {

    }

    public int getId() {
        return seatId;
    }

    public void setId(int id) {
        this.seatId = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
