package ru.job4j.ood.parking.storage;

import ru.job4j.ood.parking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CommonParking implements Parking {

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final int capacity;
    private final int maxTruckSpaces;
    private int size = 0;

    public CommonParking(int capacity, int maxTruckSpaces) {
        if (capacity < maxTruckSpaces) {
            throw new IllegalArgumentException("capacity cant be less then maxTruckSpaces");
        }
        this.capacity = capacity;
        this.maxTruckSpaces = maxTruckSpaces;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        boolean rsl = false;
        if (vehicle.getSize() + size <= capacity && !vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
            size += vehicle.getSize();
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Vehicle remove(Vehicle vehicle) {
        Vehicle rsl = null;
        int index = vehicles.indexOf(vehicle);
        if (index >= 0) {
            rsl = vehicles.remove(index);
            size -= rsl.getSize();
        }
        return rsl;
    }

    @Override
    public Vehicle getVehicle(String serialNumber) {
        int index = getIndexBySerial(serialNumber);
        return index >= 0 ? vehicles.get(index) : null;
    }

    @Override
    public List<Vehicle> getVehiclesList() {
        return vehicles;
    }

    private int getIndexBySerial(String serialNumber) {
        int rsl = -1;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getSerialNumber().equals(serialNumber)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public int getMaxTruckSpaces() {
        return maxTruckSpaces;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

}
