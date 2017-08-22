package ge.chalauri.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Chalauri-G on 6/20/2017.
 */

@Entity(name = "ge.chalauri.model.EmployeeBonus")
@Table(name = "employee_bonuses")
public class EmployeeBonus {

    @Id
    @TableGenerator(name = "main.java.chalauri.EmployeeBonus", table = "ID_GENERATORS",
            pkColumnName = "PRIMARY_KEYS", pkColumnValue = "EMPLOYEE_BONUS_ID",
            valueColumnName = "KEY_VALUES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "main.java.chalauri.EmployeeBonus")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name="EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name="BONUS_AMOUNT")
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="BONUS_DATE")
    private Date bonusDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(Date bonusDate) {
        this.bonusDate = bonusDate;
    }
}
