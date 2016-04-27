package org.rookie.faker;

import org.junit.Before;
import org.junit.Test;
import org.rookie.faker.matchers.MatchesRegularExpression;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class FakerTest {

    private Faker faker;

    @Before
    public void before() {
        faker = new Faker();
    }

    @Test
    public void bothifyShouldGenerateLettersAndNumbers() {
        assertThat(faker.bothify("????##@gmail.com"), MatchesRegularExpression.matchesRegularExpression("\\w{4}\\d{2}@gmail.com"));
    }

    @Test
    public void letterifyShouldGenerateLetters() {
        assertThat(faker.bothify("????"), MatchesRegularExpression.matchesRegularExpression("\\w{4}"));
    }

    @Test
    public void letterifyShouldLeaveNonSpecialCharactersAlone() {
        assertThat(faker.bothify("ABC????DEF"), MatchesRegularExpression.matchesRegularExpression("ABC\\w{4}DEF"));
    }

    @Test
    public void numerifyShouldGenerateNumbers() {
        assertThat(faker.numerify("####"), MatchesRegularExpression.matchesRegularExpression("\\d{4}"));
    }

    @Test
    public void numerifyShouldLeaveNonSpecialCharactersAlone() {
        assertThat(faker.numerify("####123"), MatchesRegularExpression.matchesRegularExpression("\\d{4}123"));
    }

    @Test
    public void resolveShouldReturnValueThatExists() {
        assertThat(faker.resolve("address.city_prefix"), not(isEmptyString()));
    }

    @Test(expected = RuntimeException.class)
    public void resolveShouldThrowExceptionWhenPropertyDoesntExist() {
        faker.resolve("address.nothing");
    }
}
