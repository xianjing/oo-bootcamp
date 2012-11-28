package src;

import src.exception.UnknownTicketException;

import java.util.HashMap;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLots> parkingLotsList;
    private HashMap<Ticket, ParkingLots> ticketMap = new HashMap<Ticket, ParkingLots>();
    private final SelectionStrategy strategy;

    public ParkingBoy(List<ParkingLots> parkingLotsList, SelectionStrategy strategy) {
        this.parkingLotsList = parkingLotsList;
        this.strategy = strategy;
    }

    public Ticket park(Car car) {
        ParkingLots expectedParkingLots = strategy.selectParkingLots(parkingLotsList);
        Ticket ticket = expectedParkingLots.park(car);
        ticketMap.put(ticket, expectedParkingLots);
        return ticket;
    }

    public Car unpark(Ticket ticket) {
        if(ticketMap.containsKey(ticket)){
            ParkingLots parkingLots = ticketMap.get(ticket);
            return parkingLots.unPark(ticket);
        }
        throw new UnknownTicketException();
    }

}
