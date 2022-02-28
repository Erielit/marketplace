package mx.edu.utez.marketplace.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.marketplace.person.model.Person;
import mx.edu.utez.marketplace.role.model.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String password, Person person, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public User(long id, String username, String password, Person person, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
