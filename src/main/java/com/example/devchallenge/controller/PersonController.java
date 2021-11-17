package com.example.devchallenge.controller;

import com.example.devchallenge.model.Person;
import com.example.devchallenge.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping(path = "/{id}")
    public Optional<Person> getPerson(@PathVariable("id") Long id) {
        return this.personService.getPerson(id);
    }

    @PostMapping("/register")
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @PostMapping(path = "{personId}")
    public void adoptChild(@PathVariable("personId") Long personId) {
        personService.adopt(personId);
    }
}
