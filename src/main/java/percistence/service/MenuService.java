package percistence.service;

import desappgroupd.Menu;

import java.util.List;

public interface MenuService {

    void addMenu(Menu menu);
    List<Menu> menus();
}
