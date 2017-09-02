package ge.chalauri.repositories;

import ge.chalauri.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chalauri-G on 9/2/2017.
 */
@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Integer> {
}
