import com.thoughtworks.parkinglots.Car;
import com.thoughtworks.parkinglots.IParkingLots;
import com.thoughtworks.parkinglots.ParkingLots;
import com.thoughtworks.parkinglots.Ticket;
import com.thoughtworks.parkinglots.exception.ParkingLotsIsFullException;
import com.thoughtworks.parkinglots.exception.UnknownTicketException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ParkingLotTest {

    private IParkingLots parkingLots;

    @Test
    public void should_park_succeed_given_available_slots(){
        parkingLots = new ParkingLots(1);
        Ticket ticket = parkingLots.park(new Car());
        assertNotNull(ticket);
    }

    @Test(expected = ParkingLotsIsFullException.class)
    public void should_fail_given_no_available_slots(){
        parkingLots = new ParkingLots(1);
        parkingLots.park(new Car());
        parkingLots.park(new Car());
    }

    @Test
    public void should_get_correct_car_given_correct_ticket() {
       parkingLots = new ParkingLots(1);
        Car expectedCar = new Car();
        Ticket ticket = parkingLots.park(expectedCar);

       Car actualCar = parkingLots.unPark(ticket);

       assertSame(expectedCar, actualCar);
    }

    @Test(expected = UnknownTicketException.class)
    public void should_fail_given_invalid_ticket() {
        parkingLots = new ParkingLots(1);
        parkingLots.unPark(new Ticket());
    }
}
