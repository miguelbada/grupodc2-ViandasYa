package controller;

import desappgroupd.Menu;
import desappgroupd.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.websocket.server.PathParam;

@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @CrossOrigin
    @GetMapping(path = "api/menus")
    public @ResponseBody
    Iterable<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

}
