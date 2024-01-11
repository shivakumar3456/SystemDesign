package com.parkinglot.ticket;

import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.vehicle.Vehicle;

@SuppressWarnings("ALL")
public class TicketBuilder {

    private ParkingSpot spot;
    private Vehicle vehicle;
    private String ticketNo;

    public TicketBuilder setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
        return this;
    }

    public static TicketBuilder getInstance(){
        return new TicketBuilder();
    }

    public TicketBuilder setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public TicketBuilder setParkingSpot(ParkingSpot spot) {
        this.spot = spot;
        return this;
    }

    public Ticket build(){
        return new Ticket(this);
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
