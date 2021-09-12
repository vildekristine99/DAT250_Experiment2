package no.hvl.dat250.jpa.basicexample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person person : personList) {
            System.out.println(personList);
        }
        System.out.println("Size: " + personList.size());

        
        Person person = new Person();
        person.setName("Max Mustermann");
        person.setId(1L); //Long 
        
        
        Adress address = new Adress();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        address.setId(1L);
        
        CreditCard creditCard1 = new CreditCard();
        creditCard1.setNumber(12345);
        creditCard1.setBalance(-5000);
        creditCard1.setLimit(-10000);
        creditCard1.setId(1L);
        
        
        CreditCard creditCard2 = new CreditCard();
        creditCard2.setNumber(123);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);
        creditCard2.setId(1L);
        
        Set<CreditCard> creditCards = new HashSet<>();
        creditCards.add(creditCard1);
        creditCards.add(creditCard2);
        
        person.setCreditCards(creditCards);
        
        Pincode pincode = new Pincode();
        pincode.setPincode(123);
        pincode.setCount(1);
        pincode.setId(1L);
     
        
        Bank bank = new Bank();
        bank.setName("Pengebank");
        bank.setId(1L);

        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(creditCard1);
        em.persist(creditCard2);
        
        em.persist(bank);

        em.getTransaction().commit();
        em.close();

    }
}