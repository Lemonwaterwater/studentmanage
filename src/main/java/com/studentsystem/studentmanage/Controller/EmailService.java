package com.studentsystem.studentmanage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class EmailService {
    
    @Autowired
    private JavaMailSender send;

    @Value("${spring.mail.username}")
    private String fromName;
    @GetMapping("/email")
    @ResponseBody
    public String sendSimpleMail(HttpSession session, String qqemail){
        String code=VerifyUtils.verifyCode();
        session.setAttribute("code",code);
        System.out.println("============================开始邮件发送============================");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromName); //设置发送人邮箱
        simpleMailMessage.setTo(qqemail);  //设置接收人邮箱
        simpleMailMessage.setSubject("价值连城项目验证邮件"); //邮箱主题
        simpleMailMessage.setText("==============="+code); //邮箱内容
        try {
            send.send(simpleMailMessage);
            System.out.println("============================邮件发送成功============================");
            return code;
        }catch (Exception e){

            System.out.println("【邮件发送异常】=={}"+e);
            System.out.println("============================邮件发送失败============================");
            e.printStackTrace();
            return "error";
        }
    }
}
