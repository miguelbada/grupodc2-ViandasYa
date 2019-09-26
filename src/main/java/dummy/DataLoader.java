package dummy;

import desappgroupd.Menu;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private List<Menu> menues;

    public DataLoader() {
        this.menues = new ArrayList<Menu>();
        this.generarMenues();
    }

    public void generarMenues() {
        Menu menu1 = new Menu("Clasico",2 ,100, 1, 150, 150, 145,40, 10);

        this.menues.add(menu1);
    }

    public List<Menu> getMenues() {
        return this.menues;
    }

    public Menu getMenu1() {
        return this.menues.get(0);
    }
}

