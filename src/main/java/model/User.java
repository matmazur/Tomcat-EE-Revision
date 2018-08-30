package model;

public class User {

    private String pesel;
    private String firstname;
    private String lastname;


    public User(String pesel, String firstname, String lastname) {
        this.pesel = pesel;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User() {
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



}

