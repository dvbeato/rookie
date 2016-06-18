package org.rookie.factory;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Bank;
import org.rookie.factory.test.model.Person;
import org.rookie.factory.test.templates.AgencyTemplate;
import org.rookie.factory.test.templates.PersonTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;

public class JpaFactoryIntegrationTest extends IntegrationTest {

    private Factory factory = new JpaFactory(em);

    @Before
    public void setUp() throws Exception {
        transaction.begin();
    }

    @Test
    public void testJpaFactoryCreateMethod() throws Exception {
        Person person = new PersonTemplate(factory).create();
        assertThat(person.getId(), not(nullValue()));
    }

    @Test
    public void testJpaEmbeddedTemplate() throws Exception {
        AgencyTemplate agencyTemplate = new AgencyTemplate(factory);


        Agency agency = agencyTemplate.create();

        assertThat(agency.getId(), not(nullValue()));
        assertThat(agency.getBank().getId(), not(nullValue()));
    }

    @Test
    public void testJpaCreateListTemplate() throws Exception {
        List<Agency> agencies = new AgencyTemplate(factory).create(10);

        assertThat(agencies.size(), equalTo(10));

        for(Agency agency : agencies) {
            assertThat(agency.getId(), not(nullValue()));
            assertThat(agency.getBank().getId(), not(nullValue()));
        }
    }

    @After
    public void tearDown() throws Exception {
        em.flush();
        transaction.commit();
    }
}
