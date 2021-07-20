package com.example.util;

import java.util.Random;

/**
 * Utility class to simulate delays.
 */
public class DelaySimulator {
    private static Integer DELAY_LOWER_BOUND = 3;
    private static Integer DELAY_UPPER_BOUND = 15;
    private static Integer MILLISECONDS = 1000;

    /**
     * Method to get a random number of millisecond delay between 3 and 15 seconds.
     *
     * @return {@code Integer} representation of a delay in milliseconds.
     */
    public static Integer randomDelay() {
        Random random = new Random();
        Integer delay = 0;

        while (delay < DELAY_LOWER_BOUND || delay > DELAY_UPPER_BOUND) {
            delay = random.nextInt(DELAY_UPPER_BOUND + 1);
        }

        return delay * MILLISECONDS;
    }

    /**
     * Method to get a delay value in milliseconds.
     * @param delaySeconds {@code Integer} representation of a delay in seconds.
     * @return {@code Integer} representation of a delay in milliseconds.
     */
    public static Integer getDelayInMilliSeconds(Integer delaySeconds) {
        return delaySeconds * MILLISECONDS;
    }

    /**
     * Method to get a one-second delay.
     * @return {@code Integer} representation of a delay in milliseconds.
     */
    public static Integer oneSecond() {
        return MILLISECONDS;
    }

    /**
     * Method to get the maximum delay possible in the system.
     * @return {@code Integer} representation of a delay in milliseconds
     */
    public static Integer getMaximumDelay() {
        return (DELAY_UPPER_BOUND + 1) * MILLISECONDS;
    }
}
