package com.studentsystem.studentmanage.Domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    private String id;
    private String qqemail;
    private String username;
    private String password;
    private String password1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQqemail() {
        return qqemail;
    }

    public void setQqemail(String qqemail) {
        this.qqemail = qqemail;
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

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
