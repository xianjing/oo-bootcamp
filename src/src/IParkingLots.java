package src;

public interface IParkingLots {
    Ticket park(Car car);

    int getAvailableSlots();

    Car unPark(Ticket ticket);

    double getVacancyRate();

    int getCapacity();
}
