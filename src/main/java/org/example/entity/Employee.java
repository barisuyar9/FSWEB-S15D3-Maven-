package org.example.entity;

public class Employee {
    private int id;
    private String firstname;
    private String lastname;

    public Employee(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    // Equals ve hashCode metotları: kıyaslama yapabilmek için
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return id == employee.id &&
                firstname.equals(employee.firstname) &&
                lastname.equals(employee.lastname);
    }

    @Override
    public int hashCode() {
        return id + firstname.hashCode() + lastname.hashCode();
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", firstname='" + firstname + "', lastname='" + lastname + "'}";
    }
}
