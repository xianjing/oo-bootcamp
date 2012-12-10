import com.thoughtworks.parkinglots.*;
import com.thoughtworks.parkinglots.exception.ParkingLotsIsFullException;
import com.thoughtworks.parkinglots.exception.UnknownTicketException;
import com.thoughtworks.parkinglots.strategy.FirstParkingLotsSelection;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

public class ParkingManagerTest {

    private ParkingBoy parkManager;

    @Before
    public void setup(){
        List<IParkingLots> parkingLotsList = new ArrayList<IParkingLots>();
        parkingLotsList.add(new ParkingLots(1));

        IParkingLots parkingBoy = new ParkingBoy(parkingLotsList, new FirstParkingLotsSelection());

        List<IParkingLots> iParkingLotsList = Arrays.asList(parkingBoy, new ParkingLots(1));

        parkManager = new ParkingBoy(iParkingLotsList, new FirstParkingLotsSelection());

    }
    @Test
    public void should_park_succeed(){
        Ticket ticket = parkManager.park(new Car());
        assertNotNull(ticket);
    }

    @Test(expected = ParkingLotsIsFullException.class)
    public void should_park_fail(){
        parkManager.park(new Car());
        parkManager.park(new Car());
        parkManager.park(new Car());
    }

    @Test
    public void should_unpark_succeed(){
        Car expectedCar = new Car();
        Ticket ticket = parkManager.park(expectedCar);
        Car actualCar = parkManager.unPark(ticket);
        assertSame(expectedCar, actualCar);
    }

    @Test(expected = UnknownTicketException.class)
    public void should_unpark_fail(){
        parkManager.unPark(new Ticket());
    }
}
