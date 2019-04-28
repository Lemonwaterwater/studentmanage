package com.studentsystem.studentmanage.Controller;


import com.studentsystem.studentmanage.Dao.IndexDao;
import com.studentsystem.studentmanage.Domain.Login;
import com.studentsystem.studentmanage.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@ControllerAdvice
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

    @PostMapping("/save")
    public String Registered(@Valid Login login, String username, String email, String code){
//        if(!email.equals(code)){  //输入邮箱
//            return "error";
//        }

        User user = new User();
        user.setUsername(username);
        if(indexDao.findByUsename(user.getUsername())!=null){
                return "same";
        }
        user.setPassword(login.getPassword());
        user.setPassword1(login.getPassword1());
        if(login.getPassword().equals(login.getPassword1())){
            indexDao.save(user);
            return "redirect:/";
        }
        return "registered";
    }

}
