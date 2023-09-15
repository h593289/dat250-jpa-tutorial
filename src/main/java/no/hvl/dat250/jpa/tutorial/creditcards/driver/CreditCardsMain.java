package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import no.hvl.dat250.jpa.tutorial.basicexample.Todo;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
      Query q = em.createQuery("select c from Customer c");
      List<Customer> todoList = q.getResultList();
      System.out.println(todoList.toString().replace(", ", ",\n"));
    }

  }

  private static void createObjects(EntityManager em) {
    Customer c0 = new Customer();
    c0.setName("Max Mustermann");
    c0.setCreditCards(new ArrayList<>());
    c0.setAddresses(new ArrayList<>());
    Address a0 = new Address();
    a0.setStreet("Inndalsveien");
    a0.setNumber(28);
    a0.setOwners(new HashSet<>());
    CreditCard cc0 = new CreditCard();
    cc0.setNumber(12345);
    cc0.setBalance(-5000);
    cc0.setCreditLimit(-10000);
    CreditCard cc1 = new CreditCard();
    cc1.setNumber(123);
    cc1.setBalance(1);
    cc1.setCreditLimit(2000);
    Pincode p0 = new Pincode();
    p0.setPincode("123");
    p0.setCount(1);
    Bank b0 = new Bank();
    b0.setName("Pengebank");
    b0.setOwnedCards(new HashSet<>());
    c0.getAddresses().add(a0);
    c0.getCreditCards().add(cc0);
    c0.getCreditCards().add(cc1);
    a0.getOwners().add(c0);
    cc0.setPincode(p0);
    cc0.setOwningBank(b0);
    cc1.setPincode(p0);
    cc1.setOwningBank(b0);
    b0.getOwnedCards().add(cc0);
    b0.getOwnedCards().add(cc1);
    em.persist(c0);
    em.persist(a0);
    em.persist(cc0);
    em.persist(cc1);
    em.persist(p0);
    em.persist(b0);
  }
}
