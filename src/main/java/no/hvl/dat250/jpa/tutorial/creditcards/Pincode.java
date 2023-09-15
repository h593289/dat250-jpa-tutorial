package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pincode;

    private Integer count;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return pincode;
    }

    public Integer getCount() {
        return count;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pincode{" +
                "pincode='" + pincode + '\'' +
                ", count=" + count +
                '}';
    }
}
