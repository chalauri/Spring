package ge.chalauri.entities;


import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;


@Entity(name = "ge.chalauri.entities.Persons")
@Table(name = "PERSONS")
public class Person {
    @Id
    @TableGenerator(name = "ge.chalauri.entities.Person", table = "ID_GENERATORS",
            pkColumnName = "PRIMARY_KEYS", pkColumnValue = "PERSON_ID",
            valueColumnName = "KEY_VALUES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "ge.chalauri.entities.Person")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PERSON_ID")
    private PhoneNumber phoneNumber;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Formula("(select max(b.BONUS_AMOUNT) from EMPLOYEE_BONUSES b where b.EMPLOYEE_ID = id)")
    private Double maxSalary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }
}