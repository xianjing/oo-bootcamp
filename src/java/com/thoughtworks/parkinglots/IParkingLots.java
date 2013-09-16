package com.thoughtworks.parkinglots;

public interface IParkingLots {
    Ticket park(Car car);

    int getAvailableSlots();

    Car unPark(Ticket ticket);

    double getVacancyRate();

    int getCapacity();

    String print();
}
