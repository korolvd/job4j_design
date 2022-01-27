package ru.job4j.ood.parking.storage;

import ru.job4j.list.List;
import ru.job4j.ood.parking.model.Vehicle;

public class CommonParking implements Parking {

    private final int capacity;
    private final int maxTruckSpaces;

    public CommonParking(int capacity, int maxTruckSpaces) {
        this.capacity = capacity;
        this.maxTruckSpaces = maxTruckSpaces;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle remove(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle getVehicle(String serialNumber) {
        return null;
    }

    @Override
    public List<Vehicle> getVehiclesList() {
        return null;
    }

}
