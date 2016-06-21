package org.rookie.faker;


import org.rookie.faker.service.RandomService;

public class Options {
    private final RandomService randomService;

    public Options(RandomService randomService) {
        this.randomService = randomService;
    }

    public <T> T option(T... options) {
        return options[randomService.nextInt(options.length)];
    }
}