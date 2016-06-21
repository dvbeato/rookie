package org.rookie.faker;


import org.junit.Before;
import org.junit.Test;
import org.rookie.faker.matchers.IsANumber;
import org.rookie.faker.matchers.MatchesRegularExpression;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class AddressTest {

    private static final char decimalSeparator = new DecimalFormatSymbols().getDecimalSeparator();
    private Faker faker;

    @Before
    public void before() {
        faker = new Faker();
    }

    @Test
    public void testStreetAddressIsANumber() {
        final String streetAddressNumber = faker.address().streetAddressNumber();
        assertThat(streetAddressNumber, MatchesRegularExpression.matchesRegularExpression("[0-9]+ [A-Za-z0-9' ]+"));
    }

    @Test
    public void testLatitude() {
        String latStr;
        Double lat;
        for (int i = 0; i < 100; i++) {
            latStr = faker.address().latitude().replace(decimalSeparator, '.');
            assertThat(latStr, IsANumber.isANumber());
            lat = new Double(latStr);
            assertThat("Latitude is less then -90", lat >= -90);
            assertThat("Latitude is greater than 90", lat <= 90);
        }
    }

    @Test
    public void testLongitude() {
        String longStr;
        Double lon;
        for (int i = 0; i < 100; i++) {
            longStr = faker.address().longitude().replace(decimalSeparator, '.');
            assertThat(longStr, IsANumber.isANumber());
            lon = new Double(longStr);
            assertThat("Longitude is less then -180", lon >= -180);
            assertThat("Longitude is greater than 180", lon <= 180);
        }
    }


    @Test
    public void testTimeZone() {
        assertThat(faker.address().timeZone(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z_]+/[A-Za-z_]+[/A-Za-z_]*"));
    }

    @Test
    public void testState() {
        assertThat(faker.address().state(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void testCity() {
        assertThat(faker.address().city(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z'() ]+"));
    }

    @Test
    public void testCityName() {
        assertThat(faker.address().cityName(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z'() ]+"));
    }

    @Test
    public void testCountry() {
        assertThat(faker.address().country(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z\\- &.,'()\\d]+"));
    }

    @Test
    public void testCountryCode() {
        assertThat(faker.address().countryCode(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void testStreetAddressIncludeSecondary() {
        assertThat(faker.address().streetAddress(true), not(isEmptyString()));
    }

    @Test
    public void testCityWithLocaleFranceAndSeed() {
        long seed = 1L;
        Faker firstFaker = new Faker(Locale.FRANCE, new Random(seed));
        Faker secondFaker = new Faker(Locale.FRANCE, new Random(seed));
        assertThat(firstFaker.address().city(), is(secondFaker.address().city()));
    }
}
