package com.parkinglot.ticket;

import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.vehicle.Vehicle;

@SuppressWarnings("ALL")
public class Ticket {

    private ParkingSpot spot;
    private long startTime;
    private Vehicle vehicle;
    private String serialNo;

    public Ticket(TicketBuilder ticketBuilder) {
        startTime = System.currentTimeMillis();
        vehicle = ticketBuilder.getVehicle();
        spot = ticketBuilder.getSpot();
        serialNo = ticketBuilder.getTicketNo();
    }

    public ParkingSpot getParkingSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public float getPrice(){
        long endTime = System.currentTimeMillis();
        float hours = (float) (endTime-startTime)/(1000*60*60);
        return spot.getHourlyCharges() * hours;
    }

    public String getSerialNo() {
        return serialNo;
    }
}
