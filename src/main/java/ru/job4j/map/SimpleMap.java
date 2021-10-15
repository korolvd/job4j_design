package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int i = indexFor(hash(key.hashCode()));
        boolean result = table[i] == null;
        if (result) {
            table[i] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        if (isOverLoad()) {
            expand();
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private boolean isOverLoad() {
        return count > capacity * LOAD_FACTOR;
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> e : table) {
            if (e != null) {
                newTable[indexFor(hash(e.key.hashCode()))] = e;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int i = indexFor(hash(key.hashCode()));
        return table[i] != null && table[i].key.equals(key) ? table[i].value : null;
    }

    @Override
    public boolean remove(K key) {
        int i = indexFor(hash(key.hashCode()));
        boolean rsl = table[i] != null && table[i].key.equals(key);
        if (rsl) {
            table[i] = null;
            count--;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int point = 0;
            private int shiftPoint = 0;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public K next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[shiftPoint + point] == null) {
                    shiftPoint++;
                }
                return table[shiftPoint + point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
