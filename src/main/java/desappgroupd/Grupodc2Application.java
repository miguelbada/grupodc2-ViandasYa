package desappgroupd;

import controller.MenuController;
import controller.Saludo;
import controller.SendMailController;
import dummy.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import percistence.service.MenuService;
import percistence.service.ProveedorService;
import java.util.List;

@SpringBootApplication(scanBasePackageClasses = {MenuController.class, Saludo.class, MenuService.class,ProveedorService.class, SendMailController.class})
public class Grupodc2Application implements CommandLineRunner {

    @Autowired
    MenuService menuService;

    @Autowired
    ProveedorService proveedorService;

    public static void main(String[] args) {
        SpringApplication.run(Grupodc2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DataLoader data = new DataLoader();

        List<Menu> menues = data.getMenus();
        List<Proveedor> proveedores = data.getProveedores();

        for(Menu menu: menues) {
            menuService.addMenu(menu);
        }

        for(Proveedor proveedor: proveedores) {
            proveedorService.addProveedor(proveedor);
        }

    }
}
