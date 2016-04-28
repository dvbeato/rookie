package org.rookie.factory;


import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JpaFactory extends AbstractFactory implements Factory {
    private final EntityManager em;

    public JpaFactory(ModelMapper modelMapper, EntityManager em) {
        super(modelMapper);
        this.em = em;
    }

    @Override
    public <T> T create(TemplateFactory<T> template) {
        T object = build(template);
        em.persist(object);
        return object;
    }

    @Override
    public <T> List<T> create(TemplateFactory<T> template, int numberOfItems) {
        return IntStream.range(0, numberOfItems).mapToObj(value -> create(template)).collect(Collectors.toList());
    }
}
