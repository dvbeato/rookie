package org.rookie.factory;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JpaFactory extends AbstractFactory implements Factory {

    private final EntityManager em;

    public JpaFactory(EntityManager em, FactoryConfig factoryConfig) {
        super(factoryConfig);
        this.em = em;
    }

    public JpaFactory(EntityManager em, Locale locale) {
        this(em, new FactoryConfig(locale));
    }

    public JpaFactory(EntityManager em) {
        this(em, Locale.getDefault());
    }

    @Override
    public <R> TemplateField<R> field(Function<Factory, R> template) {
        return new TemplateField<>(this, template);
    }

    @Override
    public <T> T create(Template<T> template) {
        T object = build(template);
        em.persist(object);
        return object;
    }

    @Override
    public <T> List<T> create(int numberOfItems, Template<T> template) {
        return IntStream.range(0, numberOfItems).mapToObj(value -> create(template)).collect(Collectors.toList());
    }
}
