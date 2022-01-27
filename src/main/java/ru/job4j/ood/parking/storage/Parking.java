package ru.job4j.ood.parking.storage;

import ru.job4j.list.List;
import ru.job4j.ood.parking.model.Vehicle;

public interface Parking {

    boolean add(Vehicle vehicle);

    Vehicle remove(Vehicle vehicle);

    Vehicle getVehicle(String serialNumber);

    List<Vehicle> getVehiclesList();
}
