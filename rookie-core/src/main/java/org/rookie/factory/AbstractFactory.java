package org.rookie.factory;


import org.rookie.faker.Faker;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractFactory implements Factory {

    private final FactoryConfig factoryConfig;

    AbstractFactory(FactoryConfig factoryConfig) {
        Objects.requireNonNull(factoryConfig);
        this.factoryConfig = factoryConfig;
    }

    @Override
    public Faker faker() {
        return this.factoryConfig.getFaker();
    }

    @Override
    public <T> T build(Template<T> template) {
        return factoryConfig.getModelMapper().map(template, template.getModelClass());
    }

    @Override
    public <T> List<T> build(int numberOfObjects, Template<T> template) {
        return IntStream.range(0, numberOfObjects).mapToObj(value -> build(template)).collect(Collectors.toList());
    }
}
