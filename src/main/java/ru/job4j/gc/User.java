package ru.job4j.gc;

public class User {
    private int id;
    private String name;

    public User() {

    }

    public User(int id) {
        this.id = id;
        this.name = String.valueOf(id);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Destroy %d \n", id);
    }

    @Override
    public String toString() {
        return "User{"
                + "id='"
                + id + '\''
                + '}';
    }

    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            new User(i);
        }
        GCDemo.info();
    }
}
