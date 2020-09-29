package yb.yadnyesh.restwithspringboot.controller;

import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonById(@PathVariable("id") int id) {
         return personService.findByID(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAllPeople() {
        return personService.findAllPeople();
    }

    @RequestMapping(method=RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

}
