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



}
