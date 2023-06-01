package com.example.Cinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name="movie_id")
    private int movieId;

    @Column(name="title")
    private String title;

    public Movie(int id, String title) {
        this.movieId = id;
        this.title = title;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.movieId = id;
    }

    public int getId() {
        return movieId;
    }
}
