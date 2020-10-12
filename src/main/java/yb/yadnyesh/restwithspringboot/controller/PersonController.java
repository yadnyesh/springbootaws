package yb.yadnyesh.restwithspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yb.yadnyesh.restwithspringboot.model.Person;
import yb.yadnyesh.restwithspringboot.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable("id") Long id) {
         return personService.findByID(id);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.findAllPeople();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
