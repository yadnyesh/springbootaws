package yb.yadnyesh.restwithspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yb.yadnyesh.restwithspringboot.exception.ResourceNotFoundException;
import yb.yadnyesh.restwithspringboot.model.Person;
import yb.yadnyesh.restwithspringboot.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    List<Person> personList = new ArrayList<>();

    public Person findByID(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        personRepository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepository.delete(entity);
    }

}
