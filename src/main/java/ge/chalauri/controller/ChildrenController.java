package ge.chalauri.controller;

import com.querydsl.jpa.impl.JPAQuery;
import ge.chalauri.beans.ChildrenBean;
import ge.chalauri.entities.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Chalauri-G on 8/22/2017.
 */
@RestController
@RequestMapping(value = "/children", method = {RequestMethod.GET, RequestMethod.POST})
public class ChildrenController {

    @Autowired
    private ChildrenBean childrenBean;

    @RequestMapping(value = "/create")
    public ResponseEntity<?> createChildren() {

       return childrenBean.createChildren();
    }

    @RequestMapping(value = "/all")
    public List<Child> getAllChildren(){
        return childrenBean.getAllChildren();
    }


}
