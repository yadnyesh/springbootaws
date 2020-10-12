package yb.yadnyesh.restwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yb.yadnyesh.restwithspringboot.data.vo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
