package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Super_Admin {

    @Id
    private String AdminID;

    private String UserName;

    private String Email;

    private String password;

    public Super_Admin() {

    }

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Super_Admin{" +
                "AdminID='" + AdminID + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Super_Admin that = (Super_Admin) o;
        return Objects.equals(AdminID, that.AdminID) && Objects.equals(UserName, that.UserName) && Objects.equals(Email, that.Email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AdminID, UserName, Email, password);
    }
}
