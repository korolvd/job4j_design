package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 33;
        boolean run = false;
        char literal = 'D';
        float inaccuracy = 0.001f;
        byte temperature = 23;
        short size = 342;
        long distance = 1_232_654_876_876L;
        double frequency = 54.78d;

        LOG.debug("Info age : {}, run : {}, literal : {}, inaccuracy : {}, temperature : {}, size : {},"
                        + " distance : {}, frequency : {},",
                age, run, literal, inaccuracy, temperature, size, distance, frequency);
    }
}
