package ge.chalauri.beans;

import com.querydsl.core.FilteredClause;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.support.QueryBase;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.hibernate.HibernateQuery;
import com.querydsl.jpa.impl.JPAQuery;
import ge.chalauri.entities.Child;
import ge.chalauri.entities.QChild;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;

import static com.querydsl.jpa.JPAExpressions.*;

/**
 * Created by Chalauri-G on 8/22/2017.
 */

@Component
public class ChildrenBean {

    @PersistenceContext
    private EntityManager em;

    private Month[] months = {Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY,
            Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER};

    @Transactional
    public ResponseEntity<?> createChildren() {

        for (int i = 0; i < 3; i++) {
            for (int j = i; j < i + 2; j++) {
                Child child = new Child();
                child.setFirstName("First Name " + i);
                child.setLastName("Last Name " + i);
                child.setParentPersonId(i);
                child.setBirthDate(randomDateGenerator());

                em.persist(child);
            }
        }

        return ResponseEntity.ok("DONE");
    }

    private LocalDate randomDateGenerator() {
        Random random = new Random();

        int dayOfMonth = random.nextInt(28) + 1;
        Month month = months[random.nextInt(11)];
        int year = random.nextInt(46) + 1970;

        return LocalDate.of(year, month, dayOfMonth);
    }


    //Querydsl example
    public List<Child> getAllChildren() {
        JPAQuery query = new JPAQuery(em);
        QChild child = QChild.child;

        return query.select(child).from(child).fetch();
    }





}
