package org.rookie.factory.test.templates;


import org.rookie.factory.FactoryField;
import org.rookie.factory.FakerField;
import org.rookie.factory.TemplateFactory;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Bank;

public class AgencyTemplate extends TemplateFactory<Agency> {

    private FakerField<String> number = FakerField.of((faker) -> faker.numerify("#####"));
    private FakerField<String> digit = FakerField.of((faker) -> faker.numerify("#"));
    private FactoryField<Bank> bank = FactoryField.of((factory) -> factory.build(new BankTemplate()));

    public AgencyTemplate number(String number) {
        this.number.setValue(number);
        return this;
    }

    public AgencyTemplate digit(String digit) {
        this.digit.setValue(digit);
        return this;
    }

    public AgencyTemplate bank(Bank bank) {
        this.bank.setValue(bank);
        return this;
    }

    public String getNumber() {
        return number.getValue();
    }

    public String getDigit() {
        return digit.getValue();
    }

    public Bank getBank() {
        return bank.getValue();
    }
}
