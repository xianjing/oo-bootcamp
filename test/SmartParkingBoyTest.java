import org.junit.Test;
import src.*;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void should_park_into_the_parkingLots_with_more_available_slots(){
        int firstParkingLotsCapacity = 5;
        int secondParkingLotsCapacity = 5;

        ParkingLots firstParkingLots = new ParkingLots(firstParkingLotsCapacity);
        ParkingLots secondParkingLots = new ParkingLots(secondParkingLotsCapacity);
        List<ParkingLots> parkingLotsList = Arrays.asList(firstParkingLots, secondParkingLots);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotsList, new SlotsBasedSelectionStrategy());

        parkingBoy.park(new Car());

        assertEquals(firstParkingLotsCapacity -1, firstParkingLots.getAvailableSlots());

        Car firstCar = new Car();
        Ticket firstTicket = parkingBoy.park(firstCar);

        assertEquals(firstParkingLotsCapacity -1, firstParkingLots.getAvailableSlots());
        assertEquals(secondParkingLotsCapacity - 1, secondParkingLots.getAvailableSlots());

        parkingBoy.unpark(firstTicket);
        parkingBoy.park(firstCar);
        assertEquals(firstParkingLotsCapacity -1, firstParkingLots.getAvailableSlots());
        assertEquals(secondParkingLotsCapacity - 1, secondParkingLots.getAvailableSlots());
    }
}
