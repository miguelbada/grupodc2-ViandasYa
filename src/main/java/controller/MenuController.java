package controller;

import desappgroupd.Menu;
import desappgroupd.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping(path = "/menus")
    public @ResponseBody Iterable<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

}
