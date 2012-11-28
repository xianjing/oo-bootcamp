package src;

import src.exception.ParkingLotsIsFullException;

import java.util.List;

public class SlotsBasedSelectionStrategy implements SelectionStrategy {
    public ParkingLots selectParkingLots(List<ParkingLots> parkingLotsList) {
        int index = 0;
        for (int i = 0; i < parkingLotsList.size() -1; i++) {
            int result = parkingLotsList.get(i).compareTo(parkingLotsList.get(i + 1));
            if(result < 0) {
                index = i+1;
            }
        }
        if(parkingLotsList.get(index).getAvailableSlots() > 0){
            return parkingLotsList.get(index);
        }
        throw new ParkingLotsIsFullException();
    }
}