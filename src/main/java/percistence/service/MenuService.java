package percistence.service;

import desappgroupd.Menu;

import java.util.List;

public interface MenuService {
    void crearMenu(Menu menu);
    List<Menu> menues();
}
