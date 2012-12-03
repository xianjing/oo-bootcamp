package src;

import src.exception.ParkingLotsIsFullException;
import src.exception.UnknownTicketException;
import src.strategy.ParkingLotsSelection;

import java.util.HashMap;
import java.util.List;

public class ParkingBoy implements  IParkingLots{
    protected List<IParkingLots> parkingLotsList;
    protected HashMap<Ticket, IParkingLots> ticketMap = new HashMap<Ticket, IParkingLots>();
    private final ParkingLotsSelection parkingLotsSelection;

    public ParkingBoy(List<IParkingLots> parkingLotsList, ParkingLotsSelection parkingLotsSelection1) {
        this.parkingLotsList = parkingLotsList;
        parkingLotsSelection = parkingLotsSelection1;
    }

    public Ticket park(Car car) {
        IParkingLots expectedIParkingLots = parkingLotsSelection.selectParkingLots(parkingLotsList);

        if(expectedIParkingLots != null){
            Ticket ticket = expectedIParkingLots.park(car);
            ticketMap.put(ticket, expectedIParkingLots);
            return ticket;
        }
        throw new ParkingLotsIsFullException();

    }

    public Car unPark(Ticket ticket) {
        if(ticketMap.containsKey(ticket)){
            IParkingLots IParkingLots = ticketMap.get(ticket);
            return IParkingLots.unPark(ticket);
        }
        throw new UnknownTicketException();
    }

    @Override
    public double getVacancyRate() {
        return Math.round(((double)this.getAvailableSlots()/(double)this.getCapacity())*100)*0.01;
    }

    @Override
    public int getCapacity() {
        int totalCapacity = 0;
        for(IParkingLots parkingLots : parkingLotsList){
            totalCapacity += parkingLots.getCapacity();
        }
        return totalCapacity;
    }

    public int getAvailableSlots(){
        int availableSlots = 0;
        for(IParkingLots parkingLots : parkingLotsList){
            availableSlots += parkingLots.getAvailableSlots();
        }
        return availableSlots;
    }

}
