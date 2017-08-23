package ge.chalauri.entities;

import javax.persistence.*;

/**
 * Created by Chalauri-G on 8/23/2017.
 */
@Entity(name = "ge.chalauri.entities.StudentGrade")
@Table(name = "STUDENT_GRADES")
public class StudentGrade {

    @Id
    @TableGenerator(name = "ge.chalauri.entities.StudentGrade", table = "ID_GENERATORS",
            pkColumnName = "PRIMARY_KEYS", pkColumnValue = "STUDENT_GRADE_ID",
            valueColumnName = "KEY_VALUES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "ge.chalauri.entities.StudentGrade")
    @Column(name = "STUDENT_GRADE_ID")
    private Integer studentGradeId;

    @Column(name = "STUDENT_ID")
    private Integer studentId;

    @Column(name = "SUBJECT_ID")
    private Integer subjectId;

    @Column(name = "GRADE")
    private Double grade;

    public Integer getStudentGradeId() {
        return studentGradeId;
    }

    public void setStudentGradeId(Integer studentGradeId) {
        this.studentGradeId = studentGradeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
