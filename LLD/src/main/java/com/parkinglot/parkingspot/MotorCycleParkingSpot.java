package com.parkinglot.parkingspot;

import com.parkinglot.ParkingFloor;
import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.vehicle.VehicleType;

@SuppressWarnings("ALL")
public class MotorCycleParkingSpot extends ParkingSpot{

    public MotorCycleParkingSpot(ParkingFloor floor, String name, boolean forDisabled, boolean isElectric) {
        super(ParkingSpotType.MOTORCYCLE, floor, name, forDisabled, isElectric);
    }

    @Override
    public boolean checkVehicleEligibility(Vehicle vehicle) {
        return VehicleType.MOTORCYCLE == vehicle.getVehicleType() && vehicle.isElectric() == isElectric();
    }

    @Override
    public int getHourlyCharges() {
        if (isElectric()){
            return 2;
        }else {
            return 1;
        }
    }
}
