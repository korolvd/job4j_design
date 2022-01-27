package ru.job4j.ood.parking;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ood.parking.model.Car;
import ru.job4j.ood.parking.model.Truck;
import ru.job4j.ood.parking.model.Vehicle;
import ru.job4j.ood.parking.storage.CommonParking;
import ru.job4j.ood.parking.storage.Parking;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class ParkingManagementTest {

    @Ignore
    @Test
    public void whenParkCarThenTrue() {
        Parking parking = new CommonParking(10, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle car = new Car("123");
        assertTrue(management.park(car));
        assertThat(parking.getVehicle("123"), is(car));
    }

    @Ignore
    @Test
    public void whenParkTruckThenTrue() {
        Parking parking = new CommonParking(10, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck = new Truck("123", 2);
        assertTrue(management.park(truck));
        assertThat(parking.getVehicle("123"), is(truck));
    }

    @Ignore
    @Test
    public void whenParkCarOnTruckSpaceThenFalse() {
        Parking parking = new CommonParking(10, 10);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle car = new Car("123");
        assertFalse(management.park(car));
        assertThat(parking.getVehicle("123"), is(nullValue()));
    }

    @Ignore
    @Test
    public void whenParkTruckOnCarSpaceThenFalse() {
        Parking parking = new CommonParking(10, 0);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck = new Truck("123", 2);
        assertFalse(management.park(truck));
        assertThat(parking.getVehicle("123"), is(nullValue()));
    }

    @Ignore
    @Test
    public void whenParkTruckOnPartCarSpaceThenTrue() {
        Parking parking = new CommonParking(4, 2);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck = new Truck("345", 3);
        assertFalse(management.park(truck));
        assertThat(parking.getVehicle("345"), is(truck));
    }

    @Ignore
    @Test
    public void whenParkCarWhenFullThenFalse() {
        Parking parking = new CommonParking(5, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck1 = new Truck("123", 2);
        Vehicle truck2 = new Truck("345", 3);
        Vehicle car = new Car("562");
        management.park(truck1);
        management.park(truck2);
        assertFalse(management.park(car));
        assertThat(parking.getVehicle("562"), is(nullValue()));
    }

    @Ignore
    @Test
    public void whenNoFreeSpacesForTruck() {
        Parking parking = new CommonParking(6, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck1 = new Truck("123", 2);
        Vehicle truck2 = new Truck("345", 2);
        Vehicle truck3 = new Truck("567", 2);
        management.park(truck1);
        management.park(truck2);
        assertThat(management.freeSpaces(truck3), is(0));
    }

    @Ignore
    @Test
    public void whenNoFreeSpacesForCar() {
        Parking parking = new CommonParking(1, 0);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle car1 = new Car("123");
        Vehicle car2 = new Car("345");
        management.park(car1);
        assertThat(management.freeSpaces(car2), is(0));
    }

    @Ignore
    @Test
    public void whenTwoFreeSpacesForCar() {
        Parking parking = new CommonParking(5, 3);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck1 = new Truck("123", 2);
        Vehicle truck2 = new Truck("345", 2);
        Vehicle car = new Car("567");
        management.park(truck1);
        assertThat(management.freeSpaces(car), is(2));
    }

    @Ignore
    @Test
    public void whenTwoFreeSpacesForTruck() {
        Parking parking = new CommonParking(7, 5);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck1 = new Truck("123", 2);
        Vehicle truck2 = new Truck("345", 2);
        management.park(truck1);
        assertThat(management.freeSpaces(truck2), is(2));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTruckSpaceGreaterThenCapacity() {
        Parking parking = new CommonParking(4, 5);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTruckTruckSizeLessThen2() {
        Vehicle truck = new Truck("123", 1);
    }

}