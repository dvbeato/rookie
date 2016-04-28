package org.rookie.factory;


import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleFactory extends AbstractFactory implements Factory {

    SimpleFactory(ModelMapper modelMapper) {
        super(modelMapper);
    }

    SimpleFactory() {
        this(new ModelMapper());
        setupDefaultModelMapper();
    }

    private void setupDefaultModelMapper() {
        getModelMapper().getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public <T> T create(TemplateFactory<T> template) {
        return build(template);
    }

    @Override
    public <T> List<T> create(TemplateFactory<T> template, int numberOfItems) {
        return build(template, numberOfItems);
    }
}
