package cn.steven.springboot189demo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RestController
public class MailController {

    @Autowired
    private JavaMailSender sender; //spring会自动注入进来

    @RequestMapping("/send1")
    public String  send1(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("286335550@qq.com");
        message.setSubject("3月29号，上课测试");
        message.setFrom("shengming_boai@163.com");
        message.setText("hello world");
        message.setSentDate(new Date());
        sender.send(message);
        return  "success";
    }

    @RequestMapping("/send2")
    public String  send2() throws MessagingException {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper
                = new MimeMessageHelper(mimeMessage ,true,"utf-8");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>你我的字体大不大</h1>");
        stringBuilder.append("<div style='height:300px ; width:300px'>");
        stringBuilder.append("<img  src='cid:pic'/> ");
        stringBuilder.append("</div>");
        helper.setText(stringBuilder.toString(),true);
        helper.setFrom("shengming_boai@163.com");
        helper.setTo("286335550@qq.com");
        helper.setSubject("3月29日,复杂邮件测试");
        helper.setSentDate(new Date());
        helper.addInline("pic",new File("C:\\Users\\steven\\Desktop\\188\\1.png"));
        helper.addAttachment("aaa.zip",new File("C:\\Users\\steven\\Desktop\\189\\homework.zip"));
        sender.send(mimeMessage);
        return  "success";
    }
}
