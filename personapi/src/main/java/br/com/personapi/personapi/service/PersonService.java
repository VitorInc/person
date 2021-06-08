package br.com.personapi.personapi.service;


import br.com.personapi.personapi.dto.response.MessageResponseDTO;
import br.com.personapi.personapi.entities.Person;
import br.com.personapi.personapi.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().
                messange("Created person with ID ").
                build();
    }
}
