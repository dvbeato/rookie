package org.rookie.faker;


import org.junit.Before;
import org.junit.Test;
import org.rookie.faker.matchers.MatchesRegularExpression;

import static org.hamcrest.MatcherAssert.assertThat;

public class CompanyTest {

    private Faker faker;

    @Before
    public void before() {
        faker = new Faker();
    }

    @Test
    public void testName() {
        assertThat(faker.company().name(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z\\-&', ]+"));
    }

    @Test
    public void testSuffix() {
        assertThat(faker.company().suffix(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void testIndustry() {
        assertThat(faker.company().industry(), MatchesRegularExpression.matchesRegularExpression("(\\w+([ ,&/-]{1,3})?){1,4}+"));
    }

    @Test
    public void testProfession() {
        assertThat(faker.company().profession(), MatchesRegularExpression.matchesRegularExpression("[a-z ]+"));
    }
}
