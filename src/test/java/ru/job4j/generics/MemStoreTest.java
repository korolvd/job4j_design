package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;


public class MemStoreTest {

    @Test
    public void whenAdd() {
        User user = new User("name");
        Store<User> users = new MemStore<>();
        users.add(user);
        assertThat(users.findById("name"), is(user));
    }

    @Test
    public void whenReplace() {
        User user = new User("name");
        User repUser = new User("name2");
        Store<User> users = new MemStore<>();
        users.add(user);
        users.replace("name", repUser);
        assertThat(users.findById("name"), is(repUser));
    }

    @Test
    public void whenNotReplace() {
        User user = new User("name");
        User repUser = new User("name2");
        Store<User> users = new MemStore<>();
        users.add(user);
        assertThat(users.replace("name3", repUser), is(false));
    }

    @Test
    public void whenDelete() {
        User user = new User("name");
        Store<User> users = new MemStore<>();
        users.add(user);
        assertThat(users.delete("name"), is(true));
        assertThat(users.findById("name"), is(nullValue()));
    }

    @Test
    public void whenNotDelete() {
        User user = new User("name");
        Store<User> users = new MemStore<>();
        users.add(user);
        assertThat(users.delete("name2"), is(false));
        assertThat(users.findById("name"), is(user));
    }

    @Test
    public void whenFindById() {
        User user = new User("name");
        Store<User> users = new MemStore<>();
        users.add(user);
        assertThat(users.findById("name"), is(user));
    }

    @Test
    public void whenNotFindById() {
        User user = new User("name");
        Store<User> users = new MemStore<>();
        users.add(user);
        users.delete("name");
        assertThat(users.findById("name"), is(nullValue()));
    }
}