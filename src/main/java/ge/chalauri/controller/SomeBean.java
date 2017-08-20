package ge.chalauri.controller;

import ge.chalauri.model.EmployeeBonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Chalauri-G on 8/20/2017.
 */
@Component
public class SomeBean {

    @Autowired
    private EntityManager em;

    public EmployeeBonus get(){
        return em.find(EmployeeBonus.class,6);
    }
}
