package org.rookie.factory;


import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class IntegrationTest {

    private static EntityManagerFactory entityManagerFactory;
    static EntityManager em;
    static EntityTransaction transaction;

    @BeforeClass
    public static void before() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();

    }

    @AfterClass
    public static void after() {
        entityManagerFactory.close();
    }
}
