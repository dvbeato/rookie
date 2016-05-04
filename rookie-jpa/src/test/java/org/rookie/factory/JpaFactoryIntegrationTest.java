package org.rookie.factory;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.rookie.factory.test.model.Person;
import org.rookie.factory.test.templates.PersonTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;

public class JpaFactoryIntegrationTest {

    private JpaFactory jpaFactory;
    private EntityManager em;
    private EntityTransaction transaction;
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        em = entityManagerFactory.createEntityManager();
        jpaFactory = new JpaFactory(new ModelMapper(), em);
        transaction = em.getTransaction();
        transaction.begin();
    }

    @Test
    public void testJpaFactoryCreateMethod() throws Exception {
        Person person = jpaFactory.create(new PersonTemplate());
        assertThat(person.getId(), not(nullValue()));
    }

    @After
    public void tearDown() throws Exception {
        em.flush();
        transaction.commit();
        entityManagerFactory.close();
    }
}
