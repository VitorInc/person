package br.com.personapi.personapi.service;


import br.com.personapi.personapi.dto.PersonDTO;
import br.com.personapi.personapi.dto.response.MessageResponseDTO;
import br.com.personapi.personapi.entities.Person;
import br.com.personapi.personapi.exception.PersonNotFournfExceptiond;
import br.com.personapi.personapi.mapper.PersonMapper;
import br.com.personapi.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Servicegit
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
        return createMessageResponse(savedPerson.getId(), "Created person with ID");
    }


    public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();
    return allPeople.
            stream().
            map(personMapper::toDTO)
            .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFournfExceptiond {
       Person person = verifyIfExists(id);

       return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFournfExceptiond {
        verifyIfExists(id);

        personRepository.findById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFournfExceptiond {
        verifyIfExists(id);
        
        Person personToUpdate = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(savedPerson.getId(), "Updated person with ID");
    }

    private Person verifyIfExists(Long id) throws PersonNotFournfExceptiond{
        return personRepository.findById(id).orElseThrow(() ->new PersonNotFournfExceptiond(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s){
        return MessageResponseDTO.builder().messange(s+ id).build();
    }
}
