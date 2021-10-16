package ru.job4j.io;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("login"), is("root"));
        assertThat(config.value("priority"), is(nullValue()));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("login"), is("root"));
        assertThat(config.value("priority"), is(nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectPair() {
        String path = "./data/pair_incorrect.properties";
        Config config = new Config(path);
        config.load();
    }
}