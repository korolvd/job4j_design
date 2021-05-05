package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size = 0;

    public SimpleArray(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T model) {
        array[size++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorSimpleArray<T>(array, size);
    }

    static class IteratorSimpleArray<T> implements Iterator<T> {
        private final T[] data;
        private final int length;
        private int point = 0;

        public IteratorSimpleArray(T[] data, int length) {
            this.data = data;
            this.length = length;
        }

        @Override
        public boolean hasNext() {
            return point < length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[point++];
        }
    }
}
