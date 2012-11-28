package src;

import src.exception.ParkingLotsIsFullException;

import java.util.List;

public class PriorityBasedSelectionStrategy implements SelectionStrategy{
    @Override
    public ParkingLots selectParkingLots(List<ParkingLots> parkingLotsList1) {
        for (ParkingLots parkingLots : parkingLotsList1) {
            if (parkingLots.getAvailableSlots() != 0) {
                return parkingLots;
            }
        }
        throw new ParkingLotsIsFullException();
    }
}