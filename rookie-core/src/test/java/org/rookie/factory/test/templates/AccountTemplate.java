package org.rookie.factory.test.templates;


import org.rookie.factory.FactoryField;
import org.rookie.factory.FakerField;
import org.rookie.factory.TemplateFactory;
import org.rookie.factory.test.model.Account;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Person;

public class AccountTemplate extends TemplateFactory<Account> {

    private FakerField<String> number = FakerField.of((faker) -> faker.numerify("#####"));
    private FakerField<String> digit  = FakerField.of((faker) -> faker.numerify("#"));
    private FactoryField<Person> owner  = FactoryField.of((factory) -> factory.build(new PersonTemplate()));
    private FactoryField<Agency> agency = FactoryField.of((factory) -> factory.build(new AgencyTemplate()));


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
