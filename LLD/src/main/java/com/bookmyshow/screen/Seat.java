package com.bookmyshow.screen;

public class Seat {

    private final int price;
    int seatId;
    int row;
    private SeatCategory seatCategory;
    public Seat(SeatCategory seatCategory, int price){
        this.seatCategory = seatCategory;
        this.price = price;
    }
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPrice() {
        return price;
    }
}
