package yb.yadnyesh.restwithspringboot.service;

import org.springframework.stereotype.Service;
import yb.yadnyesh.restwithspringboot.data.vo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServiceInMemory {
    private final AtomicLong counter = new AtomicLong();
    List<Person> personList = new ArrayList<>();

    public Person findByID(int id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Yadnyesh");
        person.setLastName("Juvekar");
        person.setAddress("Mollo - Cumbharjua - Goa");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAllPeople() {
        personList.add(new Person(counter.incrementAndGet(),"Yadnyesh","Juvekar","Mollo - Cumbharjua - Goa","Male"));
        personList.add(new Person(counter.incrementAndGet(),"Bharat","Juvekar","Mollo - Cumbharjua - Goa","Male"));
        personList.add(new Person(counter.incrementAndGet(),"Varada","Juvekar","Mollo - Cumbharjua - Goa","Female"));
        personList.add(new Person(counter.incrementAndGet(),"Smita","Juvekar","Mollo - Cumbharjua - Goa","Female"));
        personList.add(new Person(counter.incrementAndGet(),"Bindiya","Juvekar","Mollo - Cumbharjua - Goa","Female"));
        return personList;
    }

    public Person createPerson(Person person) {
        Person newPerson = new Person();
        newPerson.setId(counter.incrementAndGet());
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setAddress(person.getAddress());
        newPerson.setGender(person.getGender());
        personList.add(newPerson);
        return newPerson;
    }

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {

    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some address in Brasil" + i);
        person.setGender("Male");
        return person;
    }
}
