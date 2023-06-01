package com.example.Cinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue
    @Column(name="room_id")
    private int roomId;
    @Column(name="room_name")
    private String roomName;
    @Column(name="capacity")
    private int capacity;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getId() {
        return roomId;
    }

    public void setId(int id) {
        this.roomId = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room(int roomId, int capacity, String roomName) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.roomName = roomName;
    }
    public Room() {

    }
}
