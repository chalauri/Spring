package ge.chalauri.entities;

import javax.persistence.*;


/**
 * Created by Chalauri-G on 8/27/2017.
 */
@Entity(name = "ge.chalauri.entities.PhoneNumber")
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {

    @Id
    @TableGenerator(name = "ge.chalauri.entities.PhoneNumber", table = "ID_GENERATORS",
            pkColumnName = "PRIMARY_KEYS", pkColumnValue = "PHONE_NUMBER_ID",
            valueColumnName = "KEY_VALUES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "ge.chalauri.entities.PhoneNumber")
    @Column(name = "ID", nullable = false)
    private Integer id;


    @Column(name = "PERSON_ID")
    private Integer personId;

    @Column(name = "NUMBER")
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}