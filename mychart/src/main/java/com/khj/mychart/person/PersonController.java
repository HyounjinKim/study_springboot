package com.khj.mychart.person;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("one/{id}")
    public PersonDto getPersonById(@PathVariable Long id){
        PersonDto personDto = personService.getPersonById(id);
        return personDto;
    }

}
