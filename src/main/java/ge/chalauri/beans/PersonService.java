package ge.chalauri.beans;

import ge.chalauri.entities.Person;
import ge.chalauri.repositories.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Chalauri-G on 9/2/2017.
 */
@Service
public class PersonService {

    @Resource
    private PersonJpaRepository personRepository;

    @PersistenceContext(unitName = "chalauri")

    private EntityManager em;

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public List<Person> getByName(String name){
        return personRepository.byName(name);
    }

}
