package org.rookie.faker;


import org.rookie.faker.service.FakeValuesServiceInterface;

public class Color {
    private final FakeValuesServiceInterface fakeValuesService;

    public Color(FakeValuesServiceInterface fakeValuesService) {
        this.fakeValuesService = fakeValuesService;
    }

    public String name() {
        return fakeValuesService.fetchString("color.name");
    }
}
