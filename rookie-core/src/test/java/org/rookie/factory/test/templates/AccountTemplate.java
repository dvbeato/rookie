package org.rookie.factory.test.templates;


import org.rookie.factory.Factory;
import org.rookie.factory.Template;
import org.rookie.factory.TemplateField;
import org.rookie.factory.test.model.Account;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Person;

public class AccountTemplate extends Template<Account> {

    private TemplateField<String> number;
    private TemplateField<String> digit;
    private TemplateField<Person> owner;
    private TemplateField<Agency> agency;

    public AccountTemplate(Factory factory) {
        super(factory);
        number = field( (f) -> f.faker().numerify("#####")    );
        digit  = field( (f) -> f.faker().numerify("#")        );
        owner  = field( (f) -> f.build(new PersonTemplate(f)) );
        agency = field( (f) -> f.build(new AgencyTemplate(f)) );
    }

    public AccountTemplate number(String number) {
        this.number.setValue(number);
        return this;
    }

    public AccountTemplate digit(String digit) {
        this.digit.setValue(digit);
        return this;
    }

    public AccountTemplate owner(Person owner) {
        this.owner.setValue(owner);
        return this;
    }

    public AccountTemplate agency(Agency agency) {
        this.agency.setValue(agency);
        return this;
    }

    public String getNumber() {
        return number.getValue();
    }

    public String getDigit() {
        return digit.getValue();
    }

    public Person getOwner() {
        return owner.getValue();
    }

    public Agency getAgency() {
        return agency.getValue();
    }
}
