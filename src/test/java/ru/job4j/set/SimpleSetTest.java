package ru.job4j.set;

import org.junit.Test;
import ru.job4j.collection.ForwardLinked;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddThenIter() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        Iterator<Integer> it = set.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }
}