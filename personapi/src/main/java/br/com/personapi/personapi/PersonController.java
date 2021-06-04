package br.com.personapi.personapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PersonController {

    @GetMapping
    public String getBook(){
        return "API test!";
    }
}
