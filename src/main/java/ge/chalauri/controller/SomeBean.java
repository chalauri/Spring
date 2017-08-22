package ge.chalauri.controller;

import ge.chalauri.model.EmployeeBonus;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Chalauri-G on 8/20/2017.
 */
@Component
public class SomeBean {

    @PersistenceContext
    private EntityManager em;

    public EmployeeBonus get(){
        return em.find(EmployeeBonus.class,6);
    }
}
