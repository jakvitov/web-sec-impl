package cz.jakvitov.websecimpl.persistence.entity;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Entity representing a user in the database
 */
@Entity
public class WebSecUser{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

    private String password;

    public WebSecUser() {
    }

    public WebSecUser(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
