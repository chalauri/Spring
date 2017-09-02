package ge.chalauri.beans;

import ge.chalauri.repositories.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Chalauri-G on 9/2/2017.
 */
@Service
public class PersonService {

    @Autowired
    private PersonJpaRepository personRepository;

    @PersistenceContext
    private EntityManager em;

}
