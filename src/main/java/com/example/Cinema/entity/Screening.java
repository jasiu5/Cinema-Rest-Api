package com.example.Cinema.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Screening")
public class Screening {
    @Id
    @GeneratedValue
    @Column(name="screening_id")
    private int id;
    @Column(name="start_time")
    private Time startTime;
    @Column(name="end_time")
    private Time endTime;
    @Column(name="screening_date")
    private Date screeningDate;
//    @Column(name="movie_id")
//    private int movie_id;
    @OneToOne()
    @JoinColumn(name="movie_id")
    private Movie movie;
    @OneToOne()
    @JoinColumn(name="room_id")
    private Room room;

    public Screening(int id, Time startTime, Time endTime, Date screeningDate, Movie movie, Room room) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screeningDate = screeningDate;
        this.movie = movie;
        this.room = room;
    }

    public Screening() {

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStart_time() {
        return startTime;
    }

    public void setStart_time(Time start_time) {
        this.startTime = start_time;
    }

    public Time getEnd_time() {
        return endTime;
    }

    public void setEnd_time(Time end_time) {
        this.endTime = end_time;
    }

    public Date getScreening_date() {
        return screeningDate;
    }

    public void setScreening_date(Date screening_date) {
        this.screeningDate = screening_date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
