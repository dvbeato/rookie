package org.rookie.factory;


import org.rookie.faker.Faker;

import java.util.function.Function;

public class RookieModule {

    private static final Faker faker = new Faker();
    private static final Factory factory = new SimpleFactory();

    static <R> FakerField<R> fakerField(Function<Faker, R> template) {
        return new FakerField<>(template, faker);
    }

    static <R> FactoryField<R> factoryField(Function<Factory, R> template) {
        return new FactoryField<>(template, factory);
    }

    public static Faker faker() {
        return faker;
    }

    public static Factory factory() {
        return factory;
    }
}
