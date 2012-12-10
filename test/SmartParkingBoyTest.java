import com.thoughtworks.parkinglots.Car;
import com.thoughtworks.parkinglots.IParkingLots;
import com.thoughtworks.parkinglots.ParkingBoy;
import com.thoughtworks.parkinglots.ParkingLots;
import com.thoughtworks.parkinglots.strategy.MaxAvailableSlotsParkingLotsSelection;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SmartParkingBoyTest {

    private IParkingLots firstIParkingLots;
    private IParkingLots secondIParkingLots;
    private IParkingLots parkingBoy;
    private static final int FIRST_PARKING_LOTS_CAPACITY = 5;
    private static final int SECOND_PARKING_LOTS_CAPACITY = 10;

    @Before
    public void setUp() throws Exception {
        firstIParkingLots = new ParkingLots(FIRST_PARKING_LOTS_CAPACITY);
        secondIParkingLots = new ParkingLots(SECOND_PARKING_LOTS_CAPACITY);
        List<IParkingLots> iParkingLotsList = Arrays.asList(firstIParkingLots, secondIParkingLots);
        parkingBoy = new ParkingBoy(iParkingLotsList, new MaxAvailableSlotsParkingLotsSelection());
    }

    @Test
    public void should_park_into_the_parkingLots_with_more_available_slots(){
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        assertEquals(FIRST_PARKING_LOTS_CAPACITY, firstIParkingLots.getAvailableSlots());
        assertEquals(SECOND_PARKING_LOTS_CAPACITY -2, secondIParkingLots.getAvailableSlots());
    }

}
