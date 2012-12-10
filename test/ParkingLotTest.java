import com.thoughtworks.parkinglots.Car;
import com.thoughtworks.parkinglots.IParkingLots;
import com.thoughtworks.parkinglots.ParkingLots;
import com.thoughtworks.parkinglots.Ticket;
import org.junit.Test;
import com.thoughtworks.parkinglots.Car;
import com.thoughtworks.parkinglots.IParkingLots;
import com.thoughtworks.parkinglots.ParkingLots;
import com.thoughtworks.parkinglots.Ticket;
import com.thoughtworks.parkinglots.exception.ParkingLotsIsFullException;
import com.thoughtworks.parkinglots.exception.UnknownTicketException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ParkingLotTest {

    private IParkingLots IParkingLots;

    @Test
    public void should_park_succeed_given_available_slots(){
        IParkingLots = new ParkingLots(1);
        Ticket ticket = IParkingLots.park(new Car());
        assertNotNull(ticket);
    }

    @Test(expected = ParkingLotsIsFullException.class)
    public void should_fail_given_no_available_slots(){
        IParkingLots = new ParkingLots(1);
        IParkingLots.park(new Car());
        IParkingLots.park(new Car());
    }

    @Test
    public void should_get_correct_car_given_correct_ticket() {
       IParkingLots = new ParkingLots(1);
        Car expectedCar = new Car();
        Ticket ticket = IParkingLots.park(expectedCar);

       Car actualCar = IParkingLots.unPark(ticket);

       assertSame(expectedCar, actualCar);
    }

    @Test(expected = UnknownTicketException.class)
    public void should_fail_given_invalid_ticket() {
        IParkingLots = new ParkingLots(1);

        Ticket fakeTicket = new Ticket();
        IParkingLots.unPark(fakeTicket);
    }
}
