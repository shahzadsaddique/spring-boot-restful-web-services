package com.example.restfulwebservices.person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    List<Person> findALl() {
        return personRepository.findAll();
    }

    Person findOne(Long id) {
        return personRepository.findOneById(id).orElse(null);
    }

    public Person createPerson(Person person) {
        return  personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
