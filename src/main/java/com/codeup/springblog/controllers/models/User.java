package com.codeup.springblog.controllers.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private long id;
    @Column(length = 25, nullable = false)
    private String username;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    // One to many, a user can have many posts
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;
    public User(){};
    public User(long id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}