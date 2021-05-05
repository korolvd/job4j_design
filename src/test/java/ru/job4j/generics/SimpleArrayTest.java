package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class SimpleArrayTest {

    @Test
    public void whenAddValuesThenGet() {
        SimpleArray<String> rsl = new SimpleArray<>(3);
        rsl.add("first");
        rsl.add("second");
        rsl.add("third");
        assertThat(rsl.get(2), is("third"));
    }

    @Test
    public void whenAddValuesThenSet() {
        SimpleArray<String> rsl = new SimpleArray<>(3);
        rsl.add("first");
        rsl.add("second");
        rsl.add("third");
        rsl.set(0, "one");
        assertThat(rsl.get(0), is("one"));
    }

    @Test
    public void whenAddValuesThenRemove() {
        SimpleArray<String> rsl = new SimpleArray<>(3);
        rsl.add("first");
        rsl.add("second");
        rsl.add("third");
        rsl.remove(0);
        assertThat(rsl.get(0), is("second"));
    }

    @Test
    public void whenRemoveThenAdd() {
        SimpleArray<String> rsl = new SimpleArray<>(3);
        rsl.add("first");
        rsl.add("second");
        rsl.add("third");
        rsl.remove(0);
        rsl.add("four");
        assertThat(rsl.get(2), is("four"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveThenGetOutOfIndex() {
        SimpleArray<String> rsl = new SimpleArray<>(3);
        rsl.add("first");
        rsl.add("second");
        rsl.add("third");
        rsl.remove(2);
        assertThat(rsl.get(2), is("third"));
    }

    @Test
    public void whenCallIteratorThenReadSequence() {
        SimpleArray<String> rsl = new SimpleArray<>(3);
        rsl.add("first");
        rsl.add("second");
        rsl.add("third");
        Iterator<String> it = rsl.iterator();
        assertThat(it.next(), is("first"));
        assertThat(it.next(), is("second"));
        assertThat(it.next(), is("third"));
    }

    @Test
    public void whenCallIteratorThenMultiCallNextAndHasNext() {
        SimpleArray<String> rsl = new SimpleArray<>(4);
        rsl.add("first");
        rsl.add("second");
        Iterator<String> it = rsl.iterator();
        assertThat(it.next(), is("first"));
        assertThat(it.next(), is("second"));
        assertThat(it.hasNext(), is(false));
    }

}