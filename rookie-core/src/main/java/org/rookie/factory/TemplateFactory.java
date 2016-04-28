package org.rookie.factory;


import java.lang.reflect.ParameterizedType;

public abstract class TemplateFactory<T> {

    private final Class<T> modelClass;

    public TemplateFactory() {
        this.modelClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getModelClass() {
        return this.modelClass;
    }
}
