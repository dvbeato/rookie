package com.example.spring;

import com.example.spring.models.Person;
import com.example.spring.templates.PersonTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rookie.factory.Factory;
import org.rookie.factory.JpaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleSpringApplication.class)
@ActiveProfiles("test")
public class SampleSpringApplicationTests {

    @Autowired
    private Factory factory;

    @Test
    @Transactional
    public void expectedToPersistAPerson() throws Exception {
        Person person = new PersonTemplate(factory).create();

        assertThat(person).isNotNull();

        assertThat(person.getId())
                .isNotNull()
                .isGreaterThan(0);
    }
}
