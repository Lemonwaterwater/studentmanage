package com.studentsystem.studentmanage.Domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private String id;
    private String qqemail;
    private String username;
    private String password;
    private String password1;
}
