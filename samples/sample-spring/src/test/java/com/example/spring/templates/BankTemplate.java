package com.example.spring.templates;


import com.example.spring.models.Bank;
import org.rookie.factory.Factory;
import org.rookie.factory.Template;
import org.rookie.factory.TemplateField;



public class BankTemplate extends Template<Bank> {
    private TemplateField<Long> number;
    private TemplateField<String> name;

    public BankTemplate(Factory factory) {
        super(factory);
        number = field((f) -> f.faker().number().randomNumber(3,true));
        name   = field((f) -> f.faker().company().name());
    }

    public Long getNumber() {
        return number.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
