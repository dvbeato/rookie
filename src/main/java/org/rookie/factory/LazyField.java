package org.rookie.factory;


import java.util.Optional;
import java.util.function.Function;

public abstract class LazyField<T, R> {

    private R value;
    Function<T, R> template;

    public void setValue(R value) {
        this.value = value;
    }

    public R getValue() {
        return Optional.ofNullable(value).orElse(template.apply(getParameter()));
    }

    public void setTemplate(Function<T, R> template) {
        this.template = template;
    }

    public abstract T getParameter();
}
