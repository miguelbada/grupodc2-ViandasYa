package controller;

import desappgroupd.Menu;
import desappgroupd.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping(path = "/menues")
    public @ResponseBody Iterable<Menu> getAllMenues() {
        return menuRepository.findAll();
    }



}
