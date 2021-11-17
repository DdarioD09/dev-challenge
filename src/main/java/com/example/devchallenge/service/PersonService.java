package com.example.devchallenge.service;

import com.example.devchallenge.model.Person;
import com.example.devchallenge.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    //Update method to save info about parents
    @Transactional
    public void adopt(Long childId) {
        Person child = personRepository.findById(childId)
                .orElseThrow(() -> new IllegalStateException(
                        "person with id " + childId + " does not exists"));

        if (child.getAge() > 18) {
            System.out.println("Person named " + child.getFullName() +
                    " is too old to be adopted");
            child.setChild(false);
        } else {
            child.setChild(true);
        }
    }
}
