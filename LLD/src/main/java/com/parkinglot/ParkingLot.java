package com.parkinglot;

import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.ticket.TicketBuilder;
import com.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class ParkingLot {

    private int count = 0;
    private List<ParkingFloor> floorList = new ArrayList<>();
    private static ParkingLot lot;

    private ParkingLot(){
    }

    public static ParkingLot getInstance(){
        if (lot == null){
            lot = new ParkingLot();
        }
        return lot;
    }

    public void addParkingFloor(ParkingFloor floor){
        floorList.add(floor);
    }

    public void addParkingSpotToFloor(ParkingFloor floor, ParkingSpot spot){
        floor.addParkingSpot(spot);
    }

    public Ticket assignParkingSpotAndCreateTicket(Vehicle vehicle){
        for (ParkingFloor floor : floorList) {
            ParkingSpot parkingSpot = floor.assignVehicleToParkingSpot(vehicle);
            if (parkingSpot != null){
                return TicketBuilder.getInstance()
                        .setTicketNo(getNextTicketNumber())
                        .setParkingSpot(parkingSpot)
                        .setVehicle(vehicle)
                        .build();
            }
        }
        System.out.println("Parking lot is full");
        return null;
    }

    public float removeVehicleAndGetPrice(Ticket ticket){
        ticket.getParkingSpot().remove();
        return ticket.getPrice();
    }

    private String getNextTicketNumber() {
        String ticketNo = "Ticket "+ count;
        count++;
        return ticketNo;
    }
}
