package org.rookie.factory;


import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public abstract class LazyField<T, R> {

    private final T funcParameter;
    private Function<T, R> template;
    private R value;

    LazyField(T funcParameter, Function<T, R> template) {
        this.funcParameter = funcParameter;
        this.template = template;
    }

    public void setValue(R value) {
        this.value = value;
    }

    public void setTemplate(Function<T, R> template) {
        Objects.requireNonNull(template);
        this.template = template;
        this.value = null;
    }

    public R getValue() {
        return Optional.ofNullable(value).orElse(template.apply(funcParameter));
    }
}
