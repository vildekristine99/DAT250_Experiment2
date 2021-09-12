package no.hvl.dat250.jpa.basicexample;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany 
    private Set<Adress> adress = new HashSet<>();

    @OneToMany()
    private Set<CreditCard> creditCards = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "adress_like",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "adress_id"))
    private Set<Adress> adresses = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public Set<Adress> getAdress() {
		return adress;
	}

	public void setAdress(Set<Adress> adress) {
		this.adress = adress;
	}



}