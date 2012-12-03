package src.strategy;

import src.IParkingLots;

import java.util.List;

public class MaxAvailableSlotsParkingLotsSelection implements ParkingLotsSelection {
    @Override
    public IParkingLots selectParkingLots(List<IParkingLots> IParkingLotsList) {
        int index = 0;
        for (int i = 0; i < IParkingLotsList.size() -1; i++) {
            if(IParkingLotsList.get(i).getAvailableSlots() < IParkingLotsList.get(i+1).getAvailableSlots()){
                index = i+1;
            }
        }
        IParkingLots IParkingLots = IParkingLotsList.get(index);
        if(IParkingLots.getAvailableSlots() > 0){
            return IParkingLots;
        }
        return null;
    }
}
