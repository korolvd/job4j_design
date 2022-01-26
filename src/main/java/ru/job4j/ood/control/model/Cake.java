package ru.job4j.ood.control.model;

import java.time.LocalDate;

public class Cake extends Food {
    public Cake(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
