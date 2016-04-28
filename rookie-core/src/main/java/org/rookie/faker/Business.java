package org.rookie.faker;


import org.rookie.faker.service.FakeValuesServiceInterface;

public class Business {
    private final FakeValuesServiceInterface fakeValuesService;

    public Business(FakeValuesServiceInterface fakeValuesService) {
        this.fakeValuesService = fakeValuesService;
    }

    public String creditCardNumber() {
        return fakeValuesService.fetchString("business.credit_card_numbers");
    }

    public String creditCardType() {
        return fakeValuesService.fetchString("business.credit_card_types");
    }

    public String creditCardExpiry() {
        return fakeValuesService.fetchString("business.credit_card_expiry_dates");
    }
}
