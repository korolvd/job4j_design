package ru.job4j.ood.parking;

import ru.job4j.ood.parking.model.Car;
import ru.job4j.ood.parking.model.Vehicle;
import ru.job4j.ood.parking.storage.Parking;

import java.util.List;

public class ParkingManagement {

    private final Parking parking;

    public ParkingManagement(Parking parking) {
        this.parking = parking;
    }

    public boolean park(Vehicle vehicle) {
        return freeSpaces(vehicle) > 0 && parking.add(vehicle);
    }

    public Vehicle unpark(Vehicle vehicle) {
        return parking.remove(vehicle);
    }

    public int freeSpaces(Vehicle vehicle) {
        int rsl = 0;
        List<Vehicle> vehicles = parking.getVehiclesList();
        int truckSize = 0;
        int carSize = 0;
        for (Vehicle v : vehicles) {
            if (v.getSize() == Car.SIZE) {
                carSize++;
            } else {
                truckSize += v.getSize();
            }
        }
        if (vehicle.getSize() == Car.SIZE) {
            boolean isTruckOnCarSpaces = parking.getMaxTruckSpaces() < truckSize;
            int trucksOnCarSpaces = isTruckOnCarSpaces ? truckSize - parking.getMaxTruckSpaces() : 0;
            rsl = parking.getCapacity() - parking.getMaxTruckSpaces() - trucksOnCarSpaces - carSize;
        } else {
            rsl = parking.getMaxTruckSpaces() - truckSize;
        }
        return rsl;
    }
}
