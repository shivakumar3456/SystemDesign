package com.parkinglot.parkingspot;

import com.parkinglot.ParkingFloor;
import com.parkinglot.vehicle.Vehicle;

@SuppressWarnings("ALL")
public abstract class ParkingSpot {

    private boolean isAvailable = true;
    private ParkingSpotType parkingSpotType;
    private ParkingFloor parkingFloor;
    private boolean forDisabled;
    private Vehicle vehicle;
    private String name;

    private boolean isElectric;

    public ParkingSpot(ParkingSpotType type, ParkingFloor floor, String name,
                       boolean forDisabled, boolean isElectric) {
        this.parkingSpotType = type;
        parkingFloor = floor;
        this.name = name;
        this.forDisabled = forDisabled;
        this.isElectric = isElectric;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void remove() {
        isAvailable = true;
        vehicle = null;
    }

    public void assignVehicle(Vehicle vehicle) {
        isAvailable = false;
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isForDisabled() {
        return forDisabled;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public abstract boolean checkVehicleEligibility(Vehicle vehicle);

    public abstract int getHourlyCharges();
}
