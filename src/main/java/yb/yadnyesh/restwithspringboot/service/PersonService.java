package yb.yadnyesh.restwithspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yb.yadnyesh.restwithspringboot.convertor.DozerConverter;
import yb.yadnyesh.restwithspringboot.data.vo.PersonVO;
import yb.yadnyesh.restwithspringboot.exception.ResourceNotFoundException;
import yb.yadnyesh.restwithspringboot.data.vo.model.Person;
import yb.yadnyesh.restwithspringboot.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonVO findByID(Long id) {
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAllPeople() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        Person entity = DozerConverter.parseObject(person, Person.class);
        PersonVO personVO = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return personVO;
    }

    public PersonVO update(Person person) {
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        PersonVO personVO = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return personVO;
    }

    public void delete(Long id) {
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepository.delete(entity);
    }

}
