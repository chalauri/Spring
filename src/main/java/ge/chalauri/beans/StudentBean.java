package ge.chalauri.beans;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import ge.chalauri.entities.QStudentGrade;
import ge.chalauri.entities.StudentGrade;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.querydsl.jpa.JPAExpressions.*;

/**
 * Created by Chalauri-G on 8/23/2017.
 */
@Repository
public class StudentBean {


    @PersistenceContext
    private EntityManager em;

    public List<StudentGrade> getSubjectWithMaxGrade() {

        JPAQuery<StudentGrade> query = new JPAQuery(em);

        QStudentGrade studentGrade = QStudentGrade.studentGrade;
        QStudentGrade innerStudentGrade = new QStudentGrade("innerStudentGrade");

        JPAQuery<StudentGrade> resultQuery = query.select(studentGrade).from(studentGrade)
                .where(studentGrade.grade.eq(select(innerStudentGrade.grade.max()).from(innerStudentGrade).where(
                        studentGrade.studentId.eq(innerStudentGrade.studentId))));

        return resultQuery.fetch();
    }

}
