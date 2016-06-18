package org.rookie.factory;


import org.rookie.factory.test.model.Account;
import org.rookie.factory.test.model.Agency;
import org.rookie.factory.test.model.Bank;
import org.rookie.factory.test.model.Person;
import org.rookie.factory.test.templates.AccountTemplate;
import org.rookie.factory.test.templates.AgencyTemplate;
import org.rookie.factory.test.templates.BankTemplate;
import org.rookie.factory.test.templates.PersonTemplate;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TemplateTest {
    private Factory factory = new SimpleFactory();

    @Test
    public void testBuildSimpleTemplate() throws Exception {
        Bank bank = new BankTemplate(factory).build();
        assertNotNull(bank.getName());
        assertNotNull(bank.getNumber());
    }

    @Test
    public void testBuildList() throws Exception {

        Set<Person> persons = new HashSet<>(new PersonTemplate(factory).juridic().age(20).build(10));

        assertTrue(persons.size() == 10);
        for(Person person : persons) {
            assertNotNull(person.getName());
            assertNotNull(person.getAge());
            assertTrue(20 == person.getAge());
            assertNotNull(person.getDocument());
            assertTrue(person.getDocument().length() == "##.###.###/####-##".length());
        }
    }

    @Test
    public void testBuildRandomRelationalTemplates() throws Exception {
        Agency agency = new AgencyTemplate(factory).build();
        assertNotNull(agency);
        assertNotNull(agency.getBank());
        assertNotNull(agency.getBank().getName());
        assertNotNull(agency.getBank().getNumber());
    }

    @Test
    public void testBuildSpecifiRelationalTemplates() throws Exception {
        Bank bank = new BankTemplate(factory).build();
        Agency agency = new AgencyTemplate(factory).bank(bank).build();

        assertNotNull(agency);
        assertNotNull(agency.getBank());
        assertEquals(bank, agency.getBank());
    }

    @Test
    public void testComplexObjectTemplate() throws Exception {
        Account account = new AccountTemplate(factory).build();
        assertNotNull(account);
        assertNotNull(account.getNumber());
        assertNotNull(account.getDigit());
        assertNotNull(account.getAgency());
        assertNotNull(account.getAgency().getBank());
        assertNotNull(account.getOwner());
    }
}
