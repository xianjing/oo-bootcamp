package src;

import src.exception.ParkingLotsIsFullException;
import src.exception.UnknownTicketException;

import java.util.HashMap;

public class ParkingLots implements Comparable{
    private int capacity;
    private HashMap<Ticket, Car> ticketMap = new HashMap<Ticket, Car>();

    public ParkingLots(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if(getAvailableSlots() == 0){
            throw new ParkingLotsIsFullException();
        }
        Ticket ticket = new Ticket();
        ticketMap.put(ticket, car);
        return ticket;
    }

    public int getAvailableSlots() {
        return capacity - ticketMap.size();
    }

    public Car unPark(Ticket ticket) {
        if(!ticketMap.containsKey(ticket)){
            throw new UnknownTicketException();
        }
        return ticketMap.remove(ticket);
    }

    @Override
    public int compareTo(Object o) {
        ParkingLots that = (ParkingLots) o;
        return this.getAvailableSlots() - that.getAvailableSlots();
    }
}
