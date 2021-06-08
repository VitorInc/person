package br.com.personapi.personapi.mapper;

import br.com.personapi.personapi.dto.PersonDTO;
import br.com.personapi.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate",source = "birthDate",dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO) ;



    PersonDTO toDTO(Person person);
}
