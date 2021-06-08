package br.com.personapi.personapi.service;


import br.com.personapi.personapi.dto.PersonDTO;
import br.com.personapi.personapi.dto.response.MessageResponseDTO;
import br.com.personapi.personapi.entities.Person;
import br.com.personapi.personapi.exception.PersonNotFournfExceptiond;
import br.com.personapi.personapi.mapper.PersonMapper;
import br.com.personapi.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().
                messange("Created person with ID ").
                build();
    }


    public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();
    return allPeople.
            stream().
            map(personMapper::toDTO)
            .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFournfExceptiond {
       Person person =personRepository.findById(id).
               orElseThrow(() ->new PersonNotFournfExceptiond(id));
        personRepository.findById(id);
       return personMapper.toDTO(person);
    }
}
