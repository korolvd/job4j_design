package ru.job4j.ood.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void testMax() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(2, -1, 4, 14, 3);
        assertThat(new MaxMin().max(list, comparator), is(14));
    }

    @Test
    public void testMaxWhenTwoEquals() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(14, -1, 4, 14, 3);
        assertThat(new MaxMin().max(list, comparator), is(14));
    }

    @Test
    public void testMaxWhenAllEquals() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(-1, -1, -1, -1, -1);
        assertThat(new MaxMin().max(list, comparator), is(-1));
    }

    @Test
    public void testMin() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(2, -1, 4, 14, 3);
        assertThat(new MaxMin().min(list, comparator), is(-1));
    }

    @Test
    public void testMinWhenTwoEquals() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(14, -1, 4, -1, 3);
        assertThat(new MaxMin().min(list, comparator), is(-1));
    }

    @Test
    public void testMinWhenAllEquals() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(-1, -1, -1, -1, -1);
        assertThat(new MaxMin().min(list, comparator), is(-1));
    }

}