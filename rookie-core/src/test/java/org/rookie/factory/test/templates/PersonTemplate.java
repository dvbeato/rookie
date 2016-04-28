package org.rookie.factory.test.templates;

import org.rookie.factory.FakerField;
import org.rookie.factory.TemplateFactory;
import org.rookie.factory.test.model.Person;


public class PersonTemplate extends TemplateFactory<Person> {

    private FakerField<String> name = FakerField.of((faker) -> faker.name().fullName());
    private FakerField<Integer> age = FakerField.of((faker) -> faker.number().numberBetween(1, 90));
    private FakerField<String> document = FakerField.of((faker) -> faker.numerify("###.###.###-##"));

    public PersonTemplate pessoaFisica() {
        this.document.setTemplate((faker) -> faker.numerify("##.###.###/####-##"));
        return this;
    }

    public PersonTemplate name(String name) {
        this.name.setValue(name);
        return this;
    }

    public PersonTemplate age(Integer age) {
        this.age.setValue(age);
        return this;
    }

    public PersonTemplate document(String document) {
        this.document.setValue(document);
        return this;
    }

    public String getName() {
        return name.getValue();
    }

    public Integer getAge() {
        return age.getValue();
    }

    public String getDocument() {
        return document.getValue();
    }
}
