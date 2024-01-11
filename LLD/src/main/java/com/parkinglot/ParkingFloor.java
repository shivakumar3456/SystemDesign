package com.parkinglot;

import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public class ParkingFloor {

    private List<ParkingSpot> parkingSpots = new ArrayList<>();
    private String name;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
        spot.setParkingFloor(this);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot);
    }

    public boolean isFull() {
        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.isAvailable()).findFirst().isPresent();
    }

    private ParkingSpot getParkingSpotForVehicle(Vehicle vehicle){
        return getParkingSpot(vehicle).get();
    }

    public boolean checkParkingSpotExistForVehicle(Vehicle vehicle) {
        return getParkingSpot(vehicle).isPresent();
    }

    private Optional<ParkingSpot> getParkingSpot(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(parkingSpot -> (vehicle.isHandicapped() == parkingSpot.isForDisabled() && parkingSpot.isAvailable() && parkingSpot.checkVehicleEligibility(vehicle)))
                .findFirst();
    }

    public ParkingSpot assignVehicleToParkingSpot(Vehicle vehicle){
        Optional<ParkingSpot> parkingSpot = getParkingSpot(vehicle);
        if (parkingSpot.isEmpty()){
            System.out.println("Parking spot not present for the vehicle in the floor " + name);
            return null;
        }
        parkingSpot.get().assignVehicle(vehicle);
        return parkingSpot.get();
    }

    public void removeFromParking(Vehicle vehicle){
        vehicle.getTicket().getParkingSpot().remove();
    }
}