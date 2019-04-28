package com.studentsystem.studentmanage.Controller;


import com.studentsystem.studentmanage.Dao.IndexDao;
import com.studentsystem.studentmanage.Domain.Student;
import com.studentsystem.studentmanage.Domain.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IndexDao indexDao;

    @GetMapping("/")
    public String login() {
        return "login";
    }



    @GetMapping("/registered")
    public String add(){

        return "registered";
    }
    @PostMapping
    public String Registered(@Valid User user, String name, String email, String code){
        user.setQqemail("");

        return "registered";
    }

}
