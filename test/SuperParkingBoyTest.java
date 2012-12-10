import com.thoughtworks.parkinglots.Car;
import com.thoughtworks.parkinglots.IParkingLots;
import com.thoughtworks.parkinglots.strategy.MostAvailableParkingLotsSelection;
import com.thoughtworks.parkinglots.ParkingLots;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SuperParkingBoyTest {

    @Test
    public void should_get_parkingLots_having_most_available_slots(){
        IParkingLots firstIParkingLots = new ParkingLots(5);
        firstIParkingLots.park(new Car());

        IParkingLots secondIParkingLots = new ParkingLots(5);
        secondIParkingLots.park(new Car());
        secondIParkingLots.park(new Car());

        List<IParkingLots> IParkingLotsList = Arrays.asList(firstIParkingLots, secondIParkingLots);
        MostAvailableParkingLotsSelection mostAvailableParkingLotsSelection = new MostAvailableParkingLotsSelection();

        IParkingLots IParkingLots = mostAvailableParkingLotsSelection.selectParkingLots(IParkingLotsList);

        Assert.assertSame(firstIParkingLots, IParkingLots);
    }
}
