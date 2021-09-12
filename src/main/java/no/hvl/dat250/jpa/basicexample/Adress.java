package no.hvl.dat250.jpa.basicexample;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data                                
public class Adress {                                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;

    @ManyToMany(mappedBy = "adresses")
    private Set<Person> persons = new HashSet<>();

    public Adress() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public void setNumber(int number) {
		this.number = number;
	}




}
