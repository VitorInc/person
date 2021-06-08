package br.com.personapi.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFournfExceptiond extends Throwable {
    public PersonNotFournfExceptiond(Long id) {
        super("Person nor found with id " + id);
    }
}
