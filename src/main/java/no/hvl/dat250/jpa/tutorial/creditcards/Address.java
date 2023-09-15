package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Customer> getOwners() {
        return owners;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOwners(Set<Customer> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
