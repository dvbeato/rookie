package org.rookie.factory.test.templates;

import org.rookie.factory.Factory;
import org.rookie.factory.Template;
import org.rookie.factory.TemplateField;
import org.rookie.factory.test.model.Person;


public class PersonTemplate extends Template<Person> {

    private TemplateField<String> name;
    private TemplateField<Integer> age;
    private TemplateField<String> document;

    public PersonTemplate(Factory factory) {
        super(factory);
        name = factory.field((f)     -> f.faker().name().fullName());
        age = factory.field((f)      -> f.faker().number().numberBetween(1, 90));
        document = factory.field((f) -> f.faker().numerify("###.###.###-##"));
    }

    public PersonTemplate pessoaFisica() {
        this.document.setTemplate((f) -> f.faker().numerify("##.###.###/####-##"));
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
