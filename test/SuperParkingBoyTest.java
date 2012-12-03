import org.junit.Assert;
import org.junit.Test;
import src.Car;
import src.IParkingLots;
import src.ParkingLots;
import src.strategy.MostAvailableParkingLotsSelection;

import java.util.Arrays;
import java.util.List;

public class SuperParkingBoyTest {

    @Test
    public void should_get_parkingLots_having_most_available_slots(){
        IParkingLots firstIParkingLots = new ParkingLots(5);
        firstIParkingLots.park(new Car());
        //80%

        IParkingLots secondIParkingLots = new ParkingLots(5);
        secondIParkingLots.park(new Car());
        secondIParkingLots.park(new Car());
        //60%

        List<IParkingLots> IParkingLotsList = Arrays.asList(firstIParkingLots, secondIParkingLots);
        MostAvailableParkingLotsSelection mostAvailableParkingLotsSelection = new MostAvailableParkingLotsSelection();
        IParkingLots IParkingLots = mostAvailableParkingLotsSelection.selectParkingLots(IParkingLotsList);
        Assert.assertSame(firstIParkingLots, IParkingLots);
    }
}
