package fi.academy.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name ="email")
    @NotEmpty(message = "*Syötä sähköposti")
    private String email;

    @Column(name = "name")
    @NotEmpty(message = "*Syötä etunimesi")
    private String name;


    @Column(name = "last_name")
    @NotEmpty(message = "*Syötä sukunimesi")
    private String lastName;


    @Column(name = "password")
    @NotEmpty(message = "*Syötä salasana käyttäjätilillesi")
    private String password;

    @Column(name = "active")
    private boolean active;


    public User(@NotEmpty(message = "*Syötä sähköpostisi") String email, @NotEmpty(message = "*Syötä sukunimesi") String lastName, @NotEmpty(message = "*Syötä etunimesi") String name, @NotEmpty(message = "*Syötä salasana käyttäjätilillesi") String password) {
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
    }


    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }
}
