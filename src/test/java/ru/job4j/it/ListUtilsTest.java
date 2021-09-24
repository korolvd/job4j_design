package ru.job4j.it;


import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 3));
        ListUtils.addAfter(input, 0, 1);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIfFilter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        Predicate<Integer> predicate = f -> f % 2 == 0;
        ListUtils.removeIf(input, predicate);
        assertThat(input, is(Arrays.asList(1, 3)));
    }

    @Test
    public void whenRemoveIfFilterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        Predicate<Integer> predicate = f -> f > 3;
        ListUtils.removeIf(input, predicate);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenReplaceIfFilter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 4));
        Predicate<Integer> predicate = f -> f % 2 == 0;
        ListUtils.replaceIf(input, predicate, 0);
        assertThat(input, is(Arrays.asList(0, 1, 1, 0, 3, 0)));
    }

    @Test
    public void whenReplaceIfFilterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        Predicate<Integer> predicate = f -> f > 3;
        ListUtils.replaceIf(input, predicate, 0);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 0)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 3, 2, 4, 0));
        ListUtils.removeAll(input, Arrays.asList(0, 2));
        assertThat(input, is(Arrays.asList(1, 3, 4)));
    }

}