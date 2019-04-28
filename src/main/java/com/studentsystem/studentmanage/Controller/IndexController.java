package com.studentsystem.studentmanage.Controller;


import com.studentsystem.studentmanage.Dao.IndexDao;
import com.studentsystem.studentmanage.Domain.Login;
import com.studentsystem.studentmanage.Domain.Student;
import com.studentsystem.studentmanage.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/find")
    public String find(@RequestParam(name="pagesize",defaultValue = "5",required = false)
                                   Integer pagesize, @RequestParam(name="page",defaultValue = "1",required = false)
            int page, Model m){
        MyPage<Student> student = indexDao.findall(pagesize,page);
        m.addAttribute("student", student);
        return "find";
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
