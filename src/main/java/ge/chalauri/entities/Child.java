package ge.chalauri.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Chalauri-G on 8/22/2017.
 */
@Entity(name = "ge.chalauri.entities.Children")
@Table(name = "CHILDREN")
public class Child {

    @Id
    @TableGenerator(name = "ge.chalauri.entities.Child", table = "ID_GENERATORS",
            pkColumnName = "PRIMARY_KEYS", pkColumnValue = "CHILD_ID",
            valueColumnName = "KEY_VALUES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "ge.chalauri.entities.Child")
    @Column(name = "CHILD_ID", nullable = false)
    private Integer id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name="PARENT_PERSON_ID")
    private Integer parentPersonId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getParentPersonId() {
        return parentPersonId;
    }

    public void setParentPersonId(Integer parentPersonId) {
        this.parentPersonId = parentPersonId;
    }
}
