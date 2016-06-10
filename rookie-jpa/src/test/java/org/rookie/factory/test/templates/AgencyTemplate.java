package org.rookie.factory.test.templates;


import org.rookie.factory.Factory;
import org.rookie.factory.Template;
import org.rookie.factory.TemplateField;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Bank;

import java.util.function.Function;

public class AgencyTemplate extends Template<Agency> {

    private TemplateField<String> number;
    private TemplateField<String> digit;
    private TemplateField<Bank> bank;


    public AgencyTemplate(Factory factory) {
        super(factory);
        number = factory.field((f) -> f.faker().numerify("#####"));
        digit  = factory.field((f) -> f.faker().numerify("#"));
        bank   = factory.field((f) -> f.create(new BankTemplate(f)));
    }

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

    public AgencyTemplate bank(Function<Factory, Bank> bank) {
        this.bank.setTemplate(bank);
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
