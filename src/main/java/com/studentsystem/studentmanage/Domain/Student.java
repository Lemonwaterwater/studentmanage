package com.studentsystem.studentmanage.Domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Student {

    @Id
    private String stuNo;
    private String name;
    private String sex;
    private String nativePlace;
    private Date birthday;
    private String className;

}
