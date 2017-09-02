package ge.chalauri.repositories;

import ge.chalauri.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chalauri-G on 9/2/2017.
 */
@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Integer> {

    @Query("select p from ge.chalauri.entities.Persons p where p.firstName  =:name")
    List<Person> byName(@Param("name") String firstName);
}
