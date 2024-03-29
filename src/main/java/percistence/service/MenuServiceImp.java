package percistence.service;

import desappgroupd.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import desappgroupd.MenuRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> menus() {
        List<Menu> menuesList = new ArrayList<Menu>();
        Iterable<Menu> menues = menuRepository.findAll();
        for (Menu menu : menues) {
            menuesList.add(menu);
        }

        return menuesList;
    }
}
