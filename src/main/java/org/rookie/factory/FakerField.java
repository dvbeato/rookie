package org.rookie.factory;

import org.rookie.faker.Faker;

import java.util.function.Function;

public class FakerField<R> extends LazyField<Faker, R> {

    private final Faker faker;

    FakerField(Function<Faker, R> template, Faker faker) {
        this.template = template;
        this.faker = faker;
    }

    public static <R> FakerField<R> of(Function<Faker, R> template) {
        return RookieModule.fakerField(template);
    }

    @Override
    public Faker getParameter() {
        return faker;
    }
}
