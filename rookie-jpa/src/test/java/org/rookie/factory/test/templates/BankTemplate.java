package org.rookie.factory.test.templates;


import org.rookie.factory.FakerField;
import org.rookie.factory.TemplateFactory;
import org.rookie.factory.test.model.Bank;


public class BankTemplate extends TemplateFactory<Bank> {
    private FakerField<Long> number = FakerField.of((faker) -> faker.number().randomNumber(3,true));
    private FakerField<String> name = FakerField.of((faker) -> faker.company().name());

    public Long getNumber() {
        return number.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
