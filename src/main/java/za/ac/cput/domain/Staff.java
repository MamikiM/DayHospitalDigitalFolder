package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity

public class Staff {
    @Id
    private String employeeId;

    private String employeeRole;

    private String name;

    private String surname;

    private String password;


    public Staff() {}

    public Staff(String employeeId, String employeeRole, String name, String surname, String password) {
        this.employeeId = employeeId;
        this.employeeRole = employeeRole;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}



