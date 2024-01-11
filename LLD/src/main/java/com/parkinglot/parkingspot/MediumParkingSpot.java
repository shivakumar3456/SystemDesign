package com.parkinglot.parkingspot;

import com.parkinglot.ParkingFloor;
import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.vehicle.VehicleType;

@SuppressWarnings("ALL")
public class MediumParkingSpot extends ParkingSpot {

    public MediumParkingSpot(ParkingSpotType type, ParkingFloor floor, String name, boolean forDisabled, boolean isElectric) {
        super(type, floor, name, forDisabled, isElectric);
    }

    @Override
    public boolean checkVehicleEligibility(Vehicle vehicle) {
        return VehicleType.MEDIUM == vehicle.getVehicleType() && vehicle.isElectric() && isElectric();
    }

    @Override
    public int getHourlyCharges() {
        if (isElectric()){
            return 6;
        }else {
            return 3;
        }
    }
}
