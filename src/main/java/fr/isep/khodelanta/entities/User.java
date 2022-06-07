package fr.isep.khodelanta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String mail;
    private String password;
    private PersonType personType;



    public User(String firstname, String lastname, String mail, String password, PersonType personType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.personType = personType;
    }

    public User() {

    }

    public void updateUser(String firstname, String lastname, String mail){
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setMail(mail);
    }
    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
