import org.junit.Test;
import src.*;
import src.strategy.MaxAvailableSlotsParkingLotsSelection;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void should_park_into_the_parkingLots_with_more_available_slots(){
        int firstParkingLotsCapacity = 5;
        int secondParkingLotsCapacity = 5;

        IParkingLots firstIParkingLots = new ParkingLots(firstParkingLotsCapacity);
        IParkingLots secondIParkingLots = new ParkingLots(secondParkingLotsCapacity);
        List<IParkingLots> IParkingLotsList = Arrays.asList(firstIParkingLots, secondIParkingLots);
        IParkingLots parkingBoy = new ParkingBoy(IParkingLotsList, new MaxAvailableSlotsParkingLotsSelection());

        parkingBoy.park(new Car());

        assertEquals(firstParkingLotsCapacity -1, firstIParkingLots.getAvailableSlots());
        assertEquals(secondParkingLotsCapacity, secondIParkingLots.getAvailableSlots());

        Car firstCar = new Car();
        Ticket firstTicket = parkingBoy.park(firstCar);

        assertEquals(firstParkingLotsCapacity -1, firstIParkingLots.getAvailableSlots());
        assertEquals(secondParkingLotsCapacity - 1, secondIParkingLots.getAvailableSlots());

        parkingBoy.unPark(firstTicket);
        parkingBoy.park(firstCar);
        assertEquals(firstParkingLotsCapacity -1, firstIParkingLots.getAvailableSlots());
        assertEquals(secondParkingLotsCapacity - 1, secondIParkingLots.getAvailableSlots());
    }
}
