package com.studentsystem.studentmanage.Controller;


import com.studentsystem.studentmanage.Dao.IndexDao;
import com.studentsystem.studentmanage.Domain.Login;
import com.studentsystem.studentmanage.Domain.Student;
import com.studentsystem.studentmanage.Domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private IndexDao indexDao;


    @GetMapping("/")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String logins(String username, String password, HttpSession session, Model m) {
        User user = indexDao.findByUsename(username);
        if(user != null) {
            if(password.equals(user.getPassword())) {
                session.setAttribute("sessuser", user);
                User usename = (User) session.getAttribute("sessuser");
                m.addAttribute("user",usename);
                return "redirect:/management";
            }
            else
                return "error";
        }
        else
            return "Notname";
    }


    @GetMapping("/registered")
    public String add(){
        return "register";
    }

    @GetMapping("/find")
    public String find(@RequestParam(name="pagesize",defaultValue = "5",required = false)
                                   Integer pagesize, @RequestParam(name="page",defaultValue = "1",required = false)
            int page, Model m, HttpSession session){
        System.out.println(session.getAttribute("sessuser"));
        MyPage<Student> student = indexDao.findall(pagesize,page);
        m.addAttribute("student", student);
        return "find";
    }


    @PostMapping("/save")
    public Object Registered(@Valid Login login,HttpSession session, String username, String Verification_Code, String code){
        if(!Verification_Code.equals(code)){  //输入邮箱
            return "error";
        }

        User user = new User();
        user.setUsername(username);
        if(indexDao.findByUsename(user.getUsername())!=null){
                return "same";
        }
        user.setPassword(login.getPassword());
        user.setPassword1(login.getPassword1());
        user.setQqemail(login.getQqemail());

        if(login.getPassword().equals(login.getPassword1())){
            indexDao.save(user);
            return "redirect:/";
        }
        return "upmi";
    }


    @GetMapping("/up")
    public String Update(HttpSession session,Model m,String stuNo){
        Student student = indexDao.findByNo(stuNo);
        m.addAttribute("update",student);
        //User user = (User) session.getAttribute("sessuser");
        //m.addAttribute("user",user);
        return "contupdate";
    }
    @PostMapping("/ups")
    public String Merge(String stuNo, String name, String sex, String nativePlace,
                        Date birthday,String className){
        Student student = indexDao.findByNo(stuNo);
        student.setStuNo(stuNo);
        student.setName(name);
        student.setSex(sex);
        //student.setBirthday(birthday);
        student.setClassName(className);
        indexDao.update(student);
        return "redirect:/find";
    }

    @GetMapping("/Cancellation")    //下号
    public String tuihcu(HttpSession session) {
        User user = new User();
        session.setAttribute("sessuser", user);
        session.removeAttribute("sessuser");
        return "login";
    }

    @GetMapping("/management")
    public String management(){
        return "management";
    }

    @GetMapping("forget")
    public  String forgetpwd(){
        return "forgword";
    }
}
