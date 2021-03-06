package br.com.personapi.personapi.controller;

import br.com.personapi.personapi.dto.PersonDTO;
import br.com.personapi.personapi.dto.response.MessageResponseDTO;
import br.com.personapi.personapi.entities.Person;
import br.com.personapi.personapi.exception.PersonNotFournfExceptiond;
import br.com.personapi.personapi.repositories.PersonRepository;
import br.com.personapi.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonRepository personRepository;


  private PersonService personService;




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findBYiD(@PathVariable Long id) throws PersonNotFournfExceptiond {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFournfExceptiond {
    return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable  Long id) throws PersonNotFournfExceptiond {
        personService.delete(id);
    }

}
