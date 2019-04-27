package com.studentsystem.studentmanage.Controller;


import com.studentsystem.studentmanage.Dao.IndexDao;
import com.studentsystem.studentmanage.Domain.Student;
import com.studentsystem.studentmanage.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IndexDao indexDao;

    @GetMapping("/")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String logins(String username, String password, HttpSession session, Model m) {
        User user = indexDao.findByUsername(username);
        if(user != null) {
            if(password.equals(user.getPassword())) {
                session.setAttribute("sessuser", user);
                return "redirect:/content";
            }else
                return "error";
        }else
            return "Notname";
    }
    @GetMapping("/find")
    public String find(HttpSession session,Model m) {
        User user = (User) session.getAttribute("sessuser");
        List<Student> student = indexDao.findOne(user);
        m.addAttribute("student", student);
        return "find";
    }

}
