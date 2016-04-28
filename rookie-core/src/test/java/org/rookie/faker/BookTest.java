package org.rookie.faker;

import org.junit.Before;
import org.junit.Test;
import org.rookie.faker.matchers.MatchesRegularExpression;


import static org.hamcrest.MatcherAssert.assertThat;

public class BookTest {

    private Faker faker;

    @Before
    public void before() {
        faker = new Faker();
    }

    @Test
    public void testTitle() {
        assertThat(faker.book().title(), MatchesRegularExpression.matchesRegularExpression("([\\p{L}'\\-\\?]+[!,]? ?){2,9}"));
    }

    @Test
    public void testAuthor() {
        assertThat(faker.book().author(), MatchesRegularExpression.matchesRegularExpression("([\\w']+\\.? ?){2,3}"));
    }

    @Test
    public void testPublisher() {
        assertThat(faker.book().publisher(), MatchesRegularExpression.matchesRegularExpression("([\\p{L}'&\\-]+[,.]? ?){1,5}"));
    }

    @Test
    public void testGenre() {
        assertThat(faker.book().genre(), MatchesRegularExpression.matchesRegularExpression("([\\w/]+ ?){2,4}"));
    }
}
