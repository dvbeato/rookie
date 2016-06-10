package org.rookie.factory;


import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class SimpleFactory extends AbstractFactory implements Factory {

    public SimpleFactory(FactoryConfig factoryConfig) {
        super(factoryConfig);
    }

    public SimpleFactory(Locale locale) {
        this(new FactoryConfig(locale));
    }

    public SimpleFactory() {
        this(new FactoryConfig());
    }

    @Override
    public <R> TemplateField<R> field(Function<Factory, R> template) {
        return new TemplateField<>(this, template);
    }

    @Override
    public <T> T create(Template<T> template) {
        return build(template);
    }

    @Override
    public <T> List<T> create(int numberOfObjects, Template<T> template) {
        return build(numberOfObjects, template);
    }
}
