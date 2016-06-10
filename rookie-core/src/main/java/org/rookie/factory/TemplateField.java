package org.rookie.factory;


import java.util.function.Function;

public class TemplateField<R> extends LazyField<Factory, R> {

    public TemplateField(Factory factory, Function<Factory, R> func) {
        super(factory, func);
    }
}
