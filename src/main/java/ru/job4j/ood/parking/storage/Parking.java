package ru.job4j.ood.parking.storage;

import ru.job4j.ood.parking.model.Vehicle;

import java.util.List;

public interface Parking {

    boolean add(Vehicle vehicle);

    Vehicle remove(Vehicle vehicle);

    Vehicle getVehicle(String serialNumber);

    List<Vehicle> getVehiclesList();

    int getMaxTruckSpaces();

    int getCapacity();
}
