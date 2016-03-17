package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by ericweidman on 3/17/16.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String userName;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
