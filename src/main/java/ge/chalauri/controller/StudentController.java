package ge.chalauri.controller;

import ge.chalauri.beans.StudentBean;
import ge.chalauri.entities.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Chalauri-G on 8/23/2017.
 */
@RestController
@RequestMapping(value = "/student", method = {RequestMethod.GET, RequestMethod.POST})
public class StudentController {

    @Autowired
    private StudentBean studentBean;

    @RequestMapping(value = "/withMaxGrade")
    public List<StudentGrade> getWithMaxGrade() {
        return studentBean.getSubjectWithMaxGrade();
    }

}
