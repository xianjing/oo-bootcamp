package src.strategy;

import src.IParkingLots;

import java.util.List;

public interface ParkingLotsSelection {
    IParkingLots selectParkingLots(List<IParkingLots> IParkingLotsList);
}
