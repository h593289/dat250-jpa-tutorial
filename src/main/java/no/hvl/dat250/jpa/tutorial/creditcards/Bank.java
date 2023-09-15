package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owningBank")
    private Set<CreditCard> ownedCards;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnedCards(Set<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                '}';
    }
}
