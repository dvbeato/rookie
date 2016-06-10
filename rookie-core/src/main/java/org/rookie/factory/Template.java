package org.rookie.factory;


import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Template<T> {

    private final Class<T> modelClass;
    private final Factory factory;

    protected Template(Factory factory) {
        this.factory = factory;
        this.modelClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getModelClass() {
        return this.modelClass;
    }

    public T build() {
        return factory.build(this);
    }

    public List<T> buid(int numberOfObjects) {
        return factory.build(numberOfObjects, this);
    }

    public T create() {
        return factory.create(this);
    }

    public List<T> create(int numberOfObjects) {
        return factory.create(numberOfObjects, this);
    }
}
