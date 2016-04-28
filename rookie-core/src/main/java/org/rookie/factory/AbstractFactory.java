package org.rookie.factory;


import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractFactory implements Factory {

    private final ModelMapper modelMapper;

    AbstractFactory(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <T> T build(TemplateFactory<T> template) {
        return modelMapper.map(template, template.getModelClass());
    }

    @Override
    public <T> List<T> build(TemplateFactory<T> template, int numberOfItems) {
        return IntStream.range(0, numberOfItems).mapToObj(value -> build(template)).collect(Collectors.toList());
    }

    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
