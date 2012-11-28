import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;
import src.exception.ParkingLotsIsFullException;
import src.exception.UnknownTicketException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;
    private static final int FIRST_PARKING_LOTS_CAPACITY = 1;
    private static final int SECOND_PARKING_LOTS_CAPACITY = 1;
    private int totalCapacity = 0;

    @Before
    public void setUp() throws Exception {
        List<ParkingLots> parkingLotsList = Arrays.asList(
                new ParkingLots(FIRST_PARKING_LOTS_CAPACITY), 
                new ParkingLots(SECOND_PARKING_LOTS_CAPACITY));
        totalCapacity = FIRST_PARKING_LOTS_CAPACITY + SECOND_PARKING_LOTS_CAPACITY;
        parkingBoy = new ParkingBoy(parkingLotsList, new PriorityBasedSelectionStrategy());
    }

    @Test
    public void should_park_succeed_given_have_available_slots(){
        for(int i =0; i < totalCapacity; i++){
            Ticket ticket = parkingBoy.park(new Car());
            Assert.assertNotNull(ticket);
        }
    }

    @Test
    public void should_unpark_succeed(){
        Car expectedCar = new Car();
        Ticket ticket = parkingBoy.park(expectedCar);
        Car actualCar = parkingBoy.unpark(ticket);
        assertSame(expectedCar, actualCar);
    }
    
    @Test(expected = ParkingLotsIsFullException.class)
    public void should_fail_given_all_parking_lots_are_full(){
        for(int i =0; i < totalCapacity + 1; i++){
            parkingBoy.park(new Car());
        }
    }

    @Test(expected = UnknownTicketException.class)
    public void should_fail_given_unpark_with_invalid_ticket(){
        Ticket fakeTicket = new Ticket();
        parkingBoy.unpark(fakeTicket);
    }

}
