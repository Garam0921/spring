package dw.firstapp.model;

public class Student {
    private String firstName;
    private String lastName;

    public Student() {
    }

    public Student(String fistName, String lastName) {
        this.firstName = fistName;
        this.lastName = lastName;
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
}

