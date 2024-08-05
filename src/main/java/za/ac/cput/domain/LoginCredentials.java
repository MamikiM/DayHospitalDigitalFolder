package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity

public class LoginCredentials{
    @Id
    private String employeeId;

    private String employeeRole;

    private String password;


    public LoginCredentials() {}

    public LoginCredentials(Builder builder) {
        this.employeeId = builder.employeeId;
        this.employeeRole = builder.employeeRole;
        this.password = builder.password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginCredentials that = (LoginCredentials) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(employeeRole, that.employeeRole) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeRole, password);
    }

    public static class Builder {

        private String employeeId;

        private String employeeRole;

        private String password;

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setEmployeeRole(String employeeRole) {
            this.employeeRole = employeeRole;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Staff staff){
            this.employeeId = staff.getEmployeeId();
            this.employeeRole = staff.getEmployeeRole();
            this.password = staff.getPassword();
            return this;
        }

        public LoginCredentials build() {
            return new LoginCredentials(this);
        }
    }
}




