package org.rookie.factory.test.templates;


import org.rookie.factory.Factory;
import org.rookie.factory.Template;
import org.rookie.factory.TemplateField;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Bank;

import java.util.function.Function;

public class AgencyTemplate extends Template<Agency> {

    private final TemplateField<String> number;
    private final TemplateField<String> digit;
    private final TemplateField<Bank>   bank;

    public AgencyTemplate(Factory factory) {
        super(factory);
        number = field( (f) -> f.faker().numerify("#####")  );
        digit  = field( (f) -> f.faker().numerify("#")      );
        bank   = field( (f) -> f.build(new BankTemplate(f)) );
    }

    public AgencyTemplate number(String number) {
        this.number.setValue(number);
        return this;
    }

    public AgencyTemplate number(Function<Factory, String> number) {
        this.number.setTemplate(number);
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
