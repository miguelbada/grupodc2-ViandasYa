package desappgroupd;

import controller.MenuController;
import controller.Saludo;
import dummy.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import percistence.service.MenuService;

@SpringBootApplication(scanBasePackageClasses = {MenuController.class, Saludo.class, MenuService.class})
public class Grupodc2Application implements CommandLineRunner {

    @Autowired
    MenuService menuService;

    public static void main(String[] args) {
        SpringApplication.run(Grupodc2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Menu menu1 = new DataLoader().getMenu1();

        menuService.crearMenu(menu1);
    }
}
