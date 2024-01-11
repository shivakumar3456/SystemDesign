package com.parkinglot.vehicle;

import com.parkinglot.ticket.Ticket;

@SuppressWarnings("ALL")
public class Vehicle {

    private String vehicleNo;
    private Ticket ticket;
    private VehicleType vehicleType;
    private boolean isHandicapped;

    private boolean isElectric;

    public Vehicle(String vehicleNo, VehicleType vType, boolean isHandicapped, boolean isElectric){
        this.vehicleNo = vehicleNo;
        this.vehicleType = vType;
        this.isHandicapped = isHandicapped;
        this.isElectric = isElectric;
    }

    public void assignTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public boolean isElectric() {
        return isElectric;
    }
}
