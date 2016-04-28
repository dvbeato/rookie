package org.rookie.factory;

import java.util.function.Function;

public class FactoryField<R> extends LazyField<Factory, R> {

    private final Factory factory;

    FactoryField(Function<Factory, R> template, Factory factory) {
        this.template = template;
        this.factory = factory;
    }

    public static <T> FactoryField<T> of(Function<Factory, T> template) {
        return RookieModule.factoryField(template);
    }

    @Override
    public Factory getParameter() {
        return factory;
    }
}
