import com.thoughtworks.parkinglots.*;
import com.thoughtworks.parkinglots.exception.ParkingLotsIsFullException;
import com.thoughtworks.parkinglots.exception.UnknownTicketException;
import com.thoughtworks.parkinglots.strategy.FirstParkingLotsSelection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ParkingBoyTest {

    private IParkingLots parkingBoy;
    private static final int FIRST_PARKING_LOTS_CAPACITY = 1;
    private static final int SECOND_PARKING_LOTS_CAPACITY = 1;
    private int totalCapacity = 0;

    @Before
    public void setUp() throws Exception {
        new ArrayList<IParkingLots>();
        List<IParkingLots> parkingLotsList = new ArrayList<IParkingLots>();
        parkingLotsList.add(new ParkingLots(FIRST_PARKING_LOTS_CAPACITY));
        parkingLotsList.add(new ParkingLots(SECOND_PARKING_LOTS_CAPACITY));

        totalCapacity = FIRST_PARKING_LOTS_CAPACITY + SECOND_PARKING_LOTS_CAPACITY;
        parkingBoy = new ParkingBoy(parkingLotsList, new FirstParkingLotsSelection());
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
        Car actualCar = parkingBoy.unPark(ticket);
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
        parkingBoy.unPark(fakeTicket);
    }

}
