package org.rookie.factory.test.templates;


import org.rookie.factory.Factory;
import org.rookie.factory.Template;
import org.rookie.factory.TemplateField;
import org.rookie.factory.test.model.Bank;


public class BankTemplate extends Template<Bank> {
    private TemplateField<Long> number;
    private TemplateField<String> name;

    public BankTemplate(Factory factory) {
        super(factory);
        number = factory.field((f) -> f.faker().number().randomNumber(3,true));
        name = factory.field((f) -> f.faker().company().name());
    }

    public Long getNumber() {
        return number.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
