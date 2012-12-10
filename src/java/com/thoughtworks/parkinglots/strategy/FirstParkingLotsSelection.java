package com.thoughtworks.parkinglots.strategy;

import com.thoughtworks.parkinglots.IParkingLots;

import java.util.List;

public class FirstParkingLotsSelection implements ParkingLotsSelection{
    public IParkingLots selectParkingLots(List<IParkingLots> IParkingLotsList) {
        IParkingLots expectedIParkingLots = null;

        for (IParkingLots parkingLots : IParkingLotsList) {
            if (parkingLots.getAvailableSlots() != 0) {
                expectedIParkingLots = parkingLots;
            }
        }
        return expectedIParkingLots;
    }
}
