package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import percistence.service.SendMailServiceImp;

@RestController
public class SendMailController {

    @Autowired
    private SendMailServiceImp sendMailService;

    @GetMapping("/testController")
    String home() {
        return "Hello Mail!";
    }

    @RequestMapping(value = "/sendEmailTest")
    public String enviarEmail(){

        String to = "miguelenriquebada07@gmail.com";
        String subject = "Testing from Spring Boot";
        String text = "Hello World \n Spring Boot Email";

        sendMailService.sendMail(to, subject, text);

        return "Mail sent";

    }



}
