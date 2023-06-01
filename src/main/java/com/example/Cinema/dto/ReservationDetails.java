package com.example.Cinema.dto;

import java.time.LocalDateTime;

public class ReservationDetails {
    private double amountToPay;
    private LocalDateTime expirationTime;

    public ReservationDetails(double amountToPay, LocalDateTime expirationTime) {
        this.amountToPay = amountToPay;
        this.expirationTime = expirationTime;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
