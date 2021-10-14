package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleMapTest {
    Map<String, Integer> map;

    @Before
    public void initData() {
        map = new SimpleMap<>();
        map.put("1s", 1);
        map.put("2s", 2);
        map.put("3s", 3);
        map.put("4s", 4);
    }

    @Test
    public void whenPutTrue() {
        Assert.assertTrue(map.put("5s", 5));
    }

    @Test
    public void whenPutFalse() {
        Assert.assertFalse(map.put("4s", 4));
    }

    @Test
    public void whenGetReturnValue() {
        Assert.assertEquals(Integer.valueOf(4), map.get("4s"));
    }

    @Test
    public void whenGetReturnNull() {
        Assert.assertNull(map.get("5s"));
    }

    @Test
    public void whenPutThenGet() {
        map.put("5s", 5);
        Assert.assertEquals(Integer.valueOf(5), map.get("5s"));
    }

    @Test
    public void whenRemoveThenGet() {
        Assert.assertTrue(map.remove("4s"));
        Assert.assertNull(map.get("4s"));
    }

    @Test
    public void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        map = new SimpleMap<>();
        Assert.assertFalse(map.iterator().hasNext());
    }

    @Test
    public void whenCheckIterator() {
        Iterator<String> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveAfterGetIteratorThenMustBeException() {
        Iterator<String> iterator = map.iterator();
        map.remove("1s");
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenPutAfterGetIteratorThenMustBeException() {
        Iterator<String> iterator = map.iterator();
        map.put("put", 0);
        iterator.next();
    }
}