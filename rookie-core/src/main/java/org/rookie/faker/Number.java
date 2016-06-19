package org.rookie.faker;



import org.rookie.faker.service.RandomService;

import java.math.BigDecimal;

public class Number {

    private final RandomService randomService;

    public Number(RandomService randomService) {
        this.randomService = randomService;
    }

    /**
     * Returns a random number between 0 and 9
     * @return digit
     */
    public int randomDigit() {
        return randomService.nextInt(9);
    }

    /**
     * Returns a random number between 1 and 9
     * @return digit
     */
    public int randomDigitNotZero() {
        return randomService.nextInt(8) + 1;
    }

    public long numberBetween(int min, long max) {
        return numberBetween((long) min, max);
    }

    public int numberBetween(int min, int max) {
        return randomService.nextInt(max - min) + min;
    }

    public long numberBetween(long min, long max) {
        return randomService.nextLong(max - min) + min;
    }

    /**
     *
     * @param numberOfDigits the number of digits the generated value should have
     * @param strict whether or not the generated value should have exactly <code>numberOfDigits</code>
     * @return randomNumber
     */
    public long randomNumber(int numberOfDigits, boolean strict) {
        long max = (long) Math.pow(10, numberOfDigits);
        if (strict) {
            long min = (long) Math.pow(10, numberOfDigits-1);
            return randomService.nextLong(max - min) + min;
        }

        return randomService.nextLong(max);
    }

    /**
     * Returns a ranbom number
     * @return randomNumber
     */
    public long randomNumber() {
        int numberOfDigits = randomService.nextInt(8) + 1;

        return randomNumber(numberOfDigits, false);
    }

    /**
     * Returns a random double
     *
     * @param maxNumberOfDecimals maximum number of places
     * @param min minimum value
     * @param max maximum value
     * @return random double
     */

    public double randomDouble(int maxNumberOfDecimals, int min, int max) {
        double value = min + (max - min) * randomService.nextDouble();

        return new BigDecimal(value).setScale(maxNumberOfDecimals, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
}
