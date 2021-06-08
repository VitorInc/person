package br.com.personapi.personapi.controller;

import br.com.personapi.personapi.dto.response.MessageResponseDTO;
import br.com.personapi.personapi.entities.Person;
import br.com.personapi.personapi.repositories.PersonRepository;
import br.com.personapi.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PersonController {

    private PersonRepository personRepository;


  private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
