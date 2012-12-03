package src;

import src.exception.ParkingLotsIsFullException;
import src.exception.UnknownTicketException;

import java.util.HashMap;

public class ParkingLots implements IParkingLots {
    private int capacity;
    private HashMap<Ticket, Car> ticketMap = new HashMap<Ticket, Car>();

    public ParkingLots(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Ticket park(Car car){
        if(getAvailableSlots() == 0){
            throw new ParkingLotsIsFullException();
        }
        Ticket ticket = new Ticket();
        ticketMap.put(ticket, car);
        return ticket;
    }

    @Override
    public int getAvailableSlots() {
        return capacity - ticketMap.size();
    }

    @Override
    public Car unPark(Ticket ticket) {
        if(!ticketMap.containsKey(ticket)){
            throw new UnknownTicketException();
        }
        return ticketMap.remove(ticket);
    }

    public double getVacancyRate() {
        return Math.round(((double) this.getAvailableSlots() / (double) capacity) * 100) * 0.01;
    }
    
    @Override
    public int getCapacity(){
        return capacity;
    }
}
