//package com.codeup.springblog.controllers;
//
//import com.codeup.springblog.controllers.models.Post;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//
//public class User {
//    //    Create a User class, with (at least) fields for id, username, email, and password.
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(length = 1000, nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Post> postList;
//    public User() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
