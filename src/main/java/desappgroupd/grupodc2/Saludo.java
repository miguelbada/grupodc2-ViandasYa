package desappgroupd.grupodc2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Saludo {

    @GetMapping("/")
    String home() {
        return "Hello World!";
    }

}
