# ROOKIE

Rookie is a Data Factory Framework to help you create your rookie objects for application test. 

##GETTING STARTED

#### Setup Factory
```java
  //for simple factory
  Factory factory = new SimpleFactory();
  
  //for jpa factory (able to persist objects)
  Factory factory = new JpaFactory(entityManager);
```

#### Usage
Given a model **Person.class**
```java
@Entity
@Getter @Setter
public class Person {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String document;
}
```

You just create a Template like this: 
**PersonTemplate.class**
```java
public class PersonTemplate extends Template<Person> {

    private TemplateField<String> name;
    private TemplateField<Integer> age;
    private TemplateField<String> document;

    public PersonTemplate(Factory factory) {
        super(factory);
        name     = field( (f) -> f.faker().name().fullName());
        age      = field( (f) -> f.faker().number().numberBetween(1, 90));
        document = field( (f) -> f.faker().numerify("###.###.###-##"));
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
```

and use it in you test:
**PersonTest.class**
```java
@Test
public void expectedToPersistEntity() throws Exception {
    Person person = new PersonTemplate(factory).create();

    assertThat(person).isNotNull();

    assertThat(person.getId())
            .isNotNull()
            .isGreaterThan(0);
}

@Test
public void expectedToPersistMultiplesEntities() throws Exception {
    List<Person> persons = new PersonTemplate(factory).create(10);

    assertThat(persons)
            .hasSize(10)
            .extracting(Person::getId)
            .doesNotContainNull();
}
```

