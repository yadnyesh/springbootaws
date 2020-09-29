package yb.yadnyesh.restwithspringboot.service;

import org.springframework.stereotype.Service;
import yb.yadnyesh.restwithspringboot.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

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
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(counter.incrementAndGet(),"Yadnyesh","Juvekar","Mollo - Cumbharjua - Goa","Male"));
        personList.add(new Person(counter.incrementAndGet(),"Bharat","Juvekar","Mollo - Cumbharjua - Goa","Male"));
        personList.add(new Person(counter.incrementAndGet(),"Varada","Juvekar","Mollo - Cumbharjua - Goa","Female"));
        personList.add(new Person(counter.incrementAndGet(),"Smita","Juvekar","Mollo - Cumbharjua - Goa","Female"));
        personList.add(new Person(counter.incrementAndGet(),"Bindiya","Juvekar","Mollo - Cumbharjua - Goa","Female"));
        return personList;
    }
}
