package br.com.personapi.personapi.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
