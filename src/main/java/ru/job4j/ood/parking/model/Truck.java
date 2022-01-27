package ru.job4j.ood.parking.model;

import java.util.Objects;

public class Truck implements Vehicle {

    private String serialNumber;

    private int size;

    public Truck(String serialNumber, int size) {
        this.size = size;
        this.serialNumber = serialNumber;
    }

    @Override
    public int getSize() {
        return 0;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return Objects.equals(serialNumber, truck.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}
