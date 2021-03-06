package ge.chalauri.controller;

import ge.chalauri.beans.PersonBean;
import ge.chalauri.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Chalauri-G on 8/27/2017.
 */
@RestController
@RequestMapping(value = "/person", method = {RequestMethod.GET, RequestMethod.POST})
public class PersonController {

    @Autowired
    private PersonBean personBean;

    @RequestMapping(value = "/allPersons")
    public List<Person> getWithMaxGrade() {
        return personBean.getAllPersons();
    }

    @RequestMapping(value = "/getAllPersonsQuerydsl")
    public List<Person> getAllPersonsQuerydsl() {
        return personBean.getAllPersonsQuerydsl();
    }


}
