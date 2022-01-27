package ru.job4j.ood.parking;

import org.junit.Test;
import ru.job4j.ood.parking.model.Car;
import ru.job4j.ood.parking.model.Truck;
import ru.job4j.ood.parking.model.Vehicle;
import ru.job4j.ood.parking.storage.CommonParking;
import ru.job4j.ood.parking.storage.Parking;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class ParkingManagementTest {

    @Test
    public void whenParkCarThenTrue() {
        Parking parking = new CommonParking(10, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle car = new Car("123");
        assertTrue(management.park(car));
        assertThat(parking.getVehicle("123"), is(car));
    }

    @Test
    public void whenParkTruckThenTrue() {
        Parking parking = new CommonParking(10, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck = new Truck("123", 2);
        assertTrue(management.park(truck));
        assertThat(parking.getVehicle("123"), is(truck));
    }

    @Test
    public void whenParkCarOnTruckSpaceThenFalse() {
        Parking parking = new CommonParking(10, 10);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle car = new Car("123");
        assertFalse(management.park(car));
        assertThat(parking.getVehicle("123"), is(nullValue()));
    }

    @Test
    public void whenParkTruckOnCarSpaceThenFalse() {
        Parking parking = new CommonParking(10, 0);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck = new Truck("123", 2);
        assertFalse(management.park(truck));
        assertThat(parking.getVehicle("123"), is(nullValue()));
    }

    @Test
    public void whenParkTruckOnPartCarSpaceThenTrue() {
        Parking parking = new CommonParking(4, 2);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck = new Truck("345", 3);
        assertTrue(management.park(truck));
        assertThat(parking.getVehicle("345"), is(truck));
    }

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

    @Test
    public void whenNoFreeSpacesForTruck() {
        Parking parking = new CommonParking(6, 4);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck1 = new Truck("123", 2);
        Vehicle truck2 = new Truck("345", 2);
        Vehicle truck3 = new Truck("567", 2);
        management.park(truck1);
        management.park(truck2);
        assertThat(management.freeSpaces(truck3), lessThan(1));
    }

    @Test
    public void whenNoFreeSpacesForCar() {
        Parking parking = new CommonParking(1, 0);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle car1 = new Car("123");
        Vehicle car2 = new Car("345");
        management.park(car1);
        assertThat(management.freeSpaces(car2), lessThan(1));
    }

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

    @Test
    public void whenFreeSpacesForTruck() {
        Parking parking = new CommonParking(7, 3);
        ParkingManagement management = new ParkingManagement(parking);
        Vehicle truck1 = new Truck("123", 2);
        Vehicle truck2 = new Truck("345", 2);
        management.park(truck1);
        assertThat(management.freeSpaces(truck2), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTruckSpaceGreaterThenCapacity() {
        Parking parking = new CommonParking(4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTruckTruckSizeLessThen2() {
        Vehicle truck = new Truck("123", 1);
    }

}