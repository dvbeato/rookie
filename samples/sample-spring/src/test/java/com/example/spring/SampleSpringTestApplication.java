package com.example.spring;

import org.rookie.factory.Factory;
import org.rookie.factory.JpaFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;

@Configuration
@Profile("test")
public class SampleSpringTestApplication {

    @Bean
    public Factory factory(EntityManager entityManager) {
        return new JpaFactory(entityManager);
    }

}
