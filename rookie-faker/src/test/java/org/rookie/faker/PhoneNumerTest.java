package org.rookie.faker;


import org.junit.Before;
import org.junit.Test;
import org.rookie.faker.matchers.MatchesRegularExpression;


import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneNumerTest {

    private Faker faker;

    @Before
    public void before() {
        faker = new Faker();
    }

    @Test
    public void testCellPhone() {
        assertThat(faker.phoneNumber().cellPhone(), MatchesRegularExpression.matchesRegularExpression("\\(?\\d+\\)?([- .]\\d+){1,3}"));
    }

    @Test
    public void testPhoneNumber() {
        assertThat(faker.phoneNumber().phoneNumber(), MatchesRegularExpression.matchesRegularExpression("\\(?\\d+\\)?([- .]x?\\d+){1,5}"));
    }
}
