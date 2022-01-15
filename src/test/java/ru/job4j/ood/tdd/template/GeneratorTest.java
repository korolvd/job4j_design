package ru.job4j.ood.tdd.template;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

public class GeneratorTest {

    @Ignore
    @Test
    public void testProduce() {
        Generator generator = new Generator1();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Vitaliy",
                "subject", "you"
        );
        String expected = "I am a Vitaliy, Who are you?";
        assertThat(generator.produce(template, args), is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalArgs() {
        Generator generator = new Generator1();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Vitaliy",
                "subject", "you",
                "surname", "Korol"
        );
        generator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalKeys() {
        Generator generator = new Generator1();
        String template = "I am a ${name} ${surname}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Vitaliy",
                "subject", "you"
        );
        generator.produce(template, args);
    }


}