package com.novare.natflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflix.utilities.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity(name="natflix_users")
@Table(name="natflix_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(required = true)
    @Email(message = "email id not valid")
    @Column(unique = true, nullable = false)
    private String email;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonIgnore
    private String hashedPassword;

    @JsonProperty(required = true)
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }


    public User(Long id, String email, String name, String password, String hashedPassword, String role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.role=role;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 8,max = 100,message = "Password must be minimum 8 characters long")
    @Password
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

}
