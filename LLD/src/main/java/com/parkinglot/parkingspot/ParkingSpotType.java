package com.parkinglot.parkingspot;

public enum ParkingSpotType{
    LARGE(4, 8),
    MEDIUM(3,6),
    MOTORCYCLE(1, 2);

    private final int nonElectricCharges;
    private final int electricCharges;

    ParkingSpotType(int nonElectric, int electric){
        nonElectricCharges = nonElectric;
        electricCharges = electric;
    }

    public int getHourlyCharges(boolean isElectric){
        if (isElectric){
            return electricCharges;
        }else{
            return nonElectricCharges;
        }
    }
}