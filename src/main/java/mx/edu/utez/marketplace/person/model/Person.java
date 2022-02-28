package mx.edu.utez.marketplace.person.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.marketplace.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String lastname;
    private Date birthday;
    @Column(unique = true)
    private String curp;

    @OneToOne(mappedBy = "person")
    @JsonIgnore
    private User user;

    public Person() {
    }
    public Person(String name, String surname, String lastname, Date birthday, String curp, User user) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.curp = curp;
        this.user = user;
    }

    public Person(long id, String name, String surname, String lastname, Date birthday, String curp, User user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.curp = curp;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
