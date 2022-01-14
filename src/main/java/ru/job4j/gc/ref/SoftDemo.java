package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SoftDemo {

    private static void example1() {
        Object strong = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("deleted");
            }
        };
        WeakReference<Object> soft = new WeakReference<>(strong);
        strong = null;
        Object obj = soft.get();
        obj = null;
        System.gc();
        System.out.println(soft.get());
    }

    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> reference : objects) {
            Object object = reference.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    public static void main(String[] args) {
        example1();
    }
}
