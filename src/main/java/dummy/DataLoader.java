package dummy;

import desappgroupd.Menu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataLoader {
    private List<Menu> menues;

    public DataLoader() {
        this.menues = new ArrayList<Menu>();
        this.generarMenues();
    }

    public void generarMenues() {
        Menu menu1 = new Menu("Menu infantil cajita minion",2 ,500, 1, 250, 250, 250,30, 50);
        Menu menu2 = new Menu("Combo nuggets",2 ,500, 1, 300, 300, 300,30, 50);
        Menu menu3 = new Menu("Combo mega Napolitano XL",2 ,500, 1, 340, 340, 340,30, 50);

        this.menues.add(menu1);
        this.menues.add(menu2);
        this.menues.add(menu3);
    }

    public List<Menu> getMenues() {
        return this.menues;
    }

}

