package org.rookie.factory;


import java.util.List;

public interface Factory {

    <T> T build(TemplateFactory<T> template);

    <T> List<T> build(TemplateFactory<T> template, int numberOfItems);
}
