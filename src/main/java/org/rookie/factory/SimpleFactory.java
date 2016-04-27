package org.rookie.factory;


import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SimpleFactory implements Factory {

    private final ModelMapper modelMapper;

    SimpleFactory(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    SimpleFactory() {
        this(new ModelMapper());
        setupDefaultModelMapper();
    }

    private void setupDefaultModelMapper() {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public <T> T build(TemplateFactory<T> template) {
        return modelMapper.map(template, template.getModelClass());
    }

    @Override
    public <T> List<T> build(TemplateFactory<T> template, int numberOfItems) {
        return IntStream.range(0, numberOfItems).mapToObj(value -> build(template)).collect(Collectors.toList());
    }
}
