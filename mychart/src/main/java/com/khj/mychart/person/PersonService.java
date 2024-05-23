package com.khj.mychart.person;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRRepository personRRepository;

    public PersonDto getPersonById(Long id){
        Person person = personRRepository.findById(id).orElseThrow();
        System.out.println(person);

        return PersonDto.builder()
                .name(person.getName())
                .age(person.getAge())
                .build();
    }
}
