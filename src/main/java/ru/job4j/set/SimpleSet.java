package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(16);

    @Override
    public boolean add(T value) {
        boolean rsl = true;
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), value)) {
                rsl = false;
                break;
            }

        }
        if (!it.hasNext()) {
            set.add(value);
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
