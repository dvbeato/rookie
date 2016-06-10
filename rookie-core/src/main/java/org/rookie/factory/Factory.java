package org.rookie.factory;


import org.rookie.faker.Faker;

import java.util.List;
import java.util.function.Function;

public interface Factory {

    Faker faker();

    <R> TemplateField<R> field(Function<Factory, R> template);

    <T> T build(Template<T> template);

    <T> List<T> build(int numberOfObjects, Template<T> template);

    <T> T create(Template<T> template);

    <T> List<T> create(int numberOfObjects, Template<T> template);
}
