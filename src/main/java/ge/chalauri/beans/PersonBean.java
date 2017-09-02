package ge.chalauri.beans;

import com.querydsl.jpa.impl.JPAQuery;
import ge.chalauri.entities.Person;
import ge.chalauri.entities.QPerson;
import ge.chalauri.entities.QPhoneNumber;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Chalauri-G on 8/27/2017.
 */
@Repository
public class PersonBean {

    @PersistenceContext(unitName = "chalauri")
    private EntityManager em;

    public List<Person> getAllPersons() {

        return em.createQuery("FROM ge.chalauri.entities.Persons ", Person.class).getResultList();
    }

    public List<Person> getAllPersonsQuerydsl() {

        JPAQuery<Person> query = new JPAQuery(em);

        QPerson person = QPerson.person;

        return query.select(person).from(person)
                .leftJoin(person.phoneNumber, new QPhoneNumber("phoneNumber"))
                .fetch();
    }

}
