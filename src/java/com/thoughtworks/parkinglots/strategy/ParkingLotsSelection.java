package com.thoughtworks.parkinglots.strategy;

import com.thoughtworks.parkinglots.IParkingLots;

import java.util.List;

public interface ParkingLotsSelection {
    IParkingLots selectParkingLots(List<IParkingLots> IParkingLotsList);
}
