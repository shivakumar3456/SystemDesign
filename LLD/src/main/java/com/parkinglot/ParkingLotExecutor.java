package com.parkinglot;

import com.parkinglot.parkingspot.MotorCycleParkingSpot;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.vehicle.VehicleType;

@SuppressWarnings("ALL")
public class ParkingLotExecutor {
    public static void main(String[] args) {
        ParkingLot instance = ParkingLot.getInstance();
        ParkingFloor floor = new ParkingFloor("1");
        instance.addParkingFloor(floor);
        ParkingSpot spot = new MotorCycleParkingSpot(floor, "1.1", false, false);
        ParkingSpot spotDisabled = new MotorCycleParkingSpot(floor, "1.1", true, false);
        ParkingSpot spotElectric = new MotorCycleParkingSpot(floor, "1.1", false, true);
        instance.addParkingSpotToFloor(floor, spot);
        instance.addParkingSpotToFloor(floor, spotDisabled);
        instance.addParkingSpotToFloor(floor, spotElectric);
        Vehicle vehicle = new Vehicle("1234", VehicleType.MOTORCYCLE, false, false);
        Vehicle vehicle2 = new Vehicle("1235", VehicleType.MOTORCYCLE, true, false);
        Vehicle vehicle3 = new Vehicle("1236", VehicleType.MOTORCYCLE, false, true);
        Vehicle vehicle4 = new Vehicle("1237", VehicleType.MOTORCYCLE, false, false);

        Ticket ticket = instance.assignParkingSpotAndCreateTicket(vehicle);
        Ticket ticket1 = instance.assignParkingSpotAndCreateTicket(vehicle2);
        Ticket ticket2 = instance.assignParkingSpotAndCreateTicket(vehicle3);
        Ticket ticket3 = instance.assignParkingSpotAndCreateTicket(vehicle4);

        printTicket(ticket, instance);
        printTicket(ticket1, instance);
        printTicket(ticket2, instance);
        printTicket(ticket3, instance);

    }

    private static void printTicket(Ticket ticket, ParkingLot instance) {
        if (ticket != null) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ticket No: " + ticket.getSerialNo());
            System.out.println(instance.removeVehicleAndGetPrice(ticket));
        }
    }
}
