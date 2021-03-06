package ru.job4j.ood.control;

import org.junit.Test;
import ru.job4j.ood.control.model.*;
import ru.job4j.ood.control.store.Shop;
import ru.job4j.ood.control.store.Store;
import ru.job4j.ood.control.store.Trash;
import ru.job4j.ood.control.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenExpired() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        Food cake = new Cake("Cake",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 25),
                124.4, 0);
        List<Food> foods = List.of(cake);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sort(foods);
        assertThat(trash.getAll(), is(foods));
    }

    @Test
    public void whenExpiryDateLessThen25AndSetDiscount() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        Food cheese = new Cheese("Cheese",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 2, 4),
                200, 0);
        List<Food> foods = List.of(cheese);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sort(foods);
        assertThat(cheese.getDiscount(), is(75));
    }

    @Test
    public void whenExpiryDateLessThen75() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        Food milk = new Milk("Milk",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 3, 1),
                200, 0);
        List<Food> foods = List.of(milk);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sort(foods);
        assertThat(milk.getDiscount(), is(0));
    }

    @Test
    public void whenExpiryDateHiThen75() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        Food apple = new Produce("Apple",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2023, 1, 1),
                150.1, 0);
        List<Food> foods = List.of(apple);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sort(foods);
        assertThat(warehouse.getAll(), is(foods));
        assertThat(apple.getDiscount(), is(0));
    }

    @Test
    public void whenMultiSort() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        Food cake = new Cake("Cake",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 25),
                124.4, 0);
        Food cheese = new Cheese("Cheese",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 2, 4),
                200, 0);
        Food milk = new Milk("Milk",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 3, 1),
                200, 0);
        Food apple = new Produce("Apple",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2023, 1, 1),
                150.1, 0);
        List<Food> foods = List.of(cake, cheese, apple, milk);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sort(foods);
        assertThat(trash.getAll(), is(List.of(cake)));
        assertThat(shop.getAll(), is(List.of(cheese, milk)));
        assertThat(warehouse.getAll(), is(List.of(apple)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToWHNullThenIllegalArgumentsThenException() {
        Store warehouse = new Warehouse();
        warehouse.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToShopNullThenIllegalArgumentsThenException() {
        Store shop = new Shop();
        shop.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToTrashNullThenIllegalArgumentsThenException() {
        Store trash = new Trash();
        trash.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGetFreshOfNullThenIllegalArgumentsThenException() {
        Store trash = new Trash();
        trash.getFreshPercent(null);
    }

}