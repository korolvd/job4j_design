package ru.job4j.collection;

import java.util.Objects;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        T rsl = out.pop();
        size--;
        return rsl;
    }

    public void push(T value) {
        int count = size;
        while (count != 0) {
            in.push(out.pop());
            count--;
        }
        out.push(value);
        while (count != size) {
            out.push(in.pop());
            count++;
        }
        size++;
    }
}
