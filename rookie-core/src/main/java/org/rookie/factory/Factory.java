package org.rookie.factory;


import java.util.List;

public interface Factory {

    <T> T build(TemplateFactory<T> template);

    <T> List<T> build(TemplateFactory<T> template, int numberOfItems);

    <T> T create(TemplateFactory<T> template);

    <T> List<T> create(TemplateFactory<T> template, int numberOfItems);
}
