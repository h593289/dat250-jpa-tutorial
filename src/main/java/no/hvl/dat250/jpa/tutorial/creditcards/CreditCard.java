package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private Integer creditLimit;

    private Integer balance;

    @ManyToOne
    private Bank owningBank;

    @ManyToOne
    private Pincode pincode;

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number=" + number +
                ", creditLimit=" + creditLimit +
                ", balance=" + balance +
                ", owningBank=" + owningBank +
                ", pincode=" + pincode +
                '}';
    }
}
