package com.studentsystem.studentmanage.Domain;


import lombok.Data;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class User {

    @Id
    private String id;
    private String qqemail;
    private String username;
    private String password;
    private String password1;
    @Column(name="photo",columnDefinition="varchar(255) default 'http://localhost:8088/images/user.jpg'")
    private String photo;
    public void init(){
        this.id = UUID.randomUUID().toString().replaceAll("-","");
    }
}
