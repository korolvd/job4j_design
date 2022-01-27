package ru.job4j.ood.parking.model;

import java.util.Objects;

public class Car implements Vehicle {
    private final String serialNumber;

    public Car(String number) {
        this.serialNumber = number;
    }

    @Override
    public int getSize() {
        return 1;
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
        Car car = (Car) o;
        return Objects.equals(serialNumber, car.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}
