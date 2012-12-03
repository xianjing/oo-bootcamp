package src.strategy;

import src.IParkingLots;

import java.util.List;

public class MostAvailableParkingLotsSelection implements ParkingLotsSelection{
    @Override
    public IParkingLots selectParkingLots(List<IParkingLots> parkingLotsList) {
        int index = 0;
        for (int i = 0; i < parkingLotsList.size() -1; i++) {
            if(parkingLotsList.get(i).getVacancyRate() < parkingLotsList.get(i+1).getVacancyRate()){
                index = i+1;
            }
        }
        IParkingLots parkingLots = parkingLotsList.get(index);
        if(parkingLots.getVacancyRate() > 0){
            return parkingLots;
        }
        return null;
    }
}
