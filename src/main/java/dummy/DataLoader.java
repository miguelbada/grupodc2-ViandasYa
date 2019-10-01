package dummy;

import desappgroupd.Menu;
import desappgroupd.Servicio;

import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private List<Menu> menus;

    public DataLoader() {
        this.menus = new ArrayList<Menu>();
        this.generarMenues();
    }

    public void generarMenues() {
        Menu menu1 = new Menu("Menu infantil cajita minion",2 ,500, 1, 250, 250, 250,30, 50);
        Menu menu2 = new Menu("Combo nuggets",2 ,500, 1, 300, 300, 300,30, 50);
        Menu menu3 = new Menu("Combo mega Napolitano XL",2 ,500, 1, 340, 340, 340,30, 50);

        Servicio servicio = new Servicio("MC");

        menu1.setServicio(servicio);
        menu2.setServicio(servicio);
        menu3.setServicio(servicio);

        this.menus.add(menu1);
        this.menus.add(menu2);
        this.menus.add(menu3);
    }

    public List<Menu> getMenus() {
        return this.menus;
    }

}

