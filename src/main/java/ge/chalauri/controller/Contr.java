package ge.chalauri.controller;

import ge.chalauri.model.EmployeeBonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chalauri-G on 8/20/2017.
 */
@RestController
@RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
public class Contr {

    @Autowired
    private SomeBean test;

    @RequestMapping(value = "/go")
    public String go(){
        return "GO";
    }

    @RequestMapping("/get")
    public EmployeeBonus get(){
        return test.get();
    }

}
