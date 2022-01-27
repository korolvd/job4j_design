package ru.job4j.ood.parking;

import ru.job4j.ood.parking.model.Vehicle;
import ru.job4j.ood.parking.storage.Parking;

public class ParkingManagement {

    private final Parking parking;

    public ParkingManagement(Parking parking) {
        this.parking = parking;
    }

    public boolean park(Vehicle vehicle) {
        return false;
    }

    public Vehicle unpark(Vehicle vehicle) {
        return null;
    }

    public int freeSpaces(Vehicle vehicle) {
        return -1;
    }
}
