package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import percistence.service.SendMailService;

@RestController
public class SendMailController {

    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/mail")
    String home() {
        return "Hello Mail!";
    }

    @RequestMapping(value = "/emailTest", method = RequestMethod.PUT)
    public String enviarEmail(){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("miguelenriquebada07@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

        return "Mail sent";

    }



}
