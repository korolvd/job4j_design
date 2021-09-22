package ru.job4j.collection;

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
        if (size > 0) {
            for (int count = 0; count <= size * 2; count++) {
                if (count < size) {
                    in.push(out.pop());
                } else if (count == size) {
                    out.push(value);
                } else {
                    out.push(in.pop());
                }
            }
        } else {
            out.push(value);
        }
        size++;
    }
}
