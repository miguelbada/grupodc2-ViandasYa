package dummy;

import desappgroupd.*;
import desappgroupd.utils.ClienteBuilder;
import desappgroupd.utils.ProveedorBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DataLoader {
    private List<Menu> menus;
    private List<Proveedor> proveedores;
    private List<Cliente> clientes;

    public DataLoader() {
        this.menus = new ArrayList<Menu>();
        this.proveedores = new ArrayList<Proveedor>();
        this.clientes = new ArrayList<Cliente>();
        this.generarMenus();
        this.generarProveedores();
        this.generarClientes();
    }

    public void generarMenus() {

        List<Date> horarios1 = new ArrayList<Date>();
        List<Date> horarios2 = new ArrayList<Date>();
        List<Date> horarios3 = new ArrayList<Date>();

        horarios1.add(new Date());
        horarios2.add(new Date());
        horarios3.add(new Date());

        FechaVigencia fechaVigencia1 = new FechaVigencia(new Date(), new Date());
        FechaVigencia fechaVigencia2 = new FechaVigencia(new Date(), new Date());
        FechaVigencia fechaVigencia3 = new FechaVigencia(new Date(), new Date());

        HashMap<Date, String> horariosYDias = new HashMap<Date, String>();
        horariosYDias.put(new Date(), "De lunes a Sabados");

        List<String> localidadDeEntrega = new ArrayList<String>();
        localidadDeEntrega.add("Quilmes");

        Servicio servicio = new Servicio("Mc", "logoDeMC", "Quilmes", "12df5454gg2sds", "Es un servicio de comidas rapidas", "mc.com.ar", "migbad_7@hotmail.com", 42544444, horariosYDias, localidadDeEntrega);

        Menu menu1 = new Menu("Menu infantil cajita minion", "Menu infantil", Categoria.HAMBURGUESA, 50, fechaVigencia1, horarios1, 35, 300, 1, 295, 200, servicio);
        Menu menu2 = new Menu("Combo nuggets", "Combo", Categoria.HAMBURGUESA, 50, fechaVigencia2, horarios2, 35, 310, 1, 305, 200, servicio);
        Menu menu3 = new Menu("Combo mega Napolitano XL", "Combo XL", Categoria.HAMBURGUESA, 50, fechaVigencia3, horarios3, 35, 430, 1, 420, 200, servicio);

        menu1.setServicio(servicio);
        menu2.setServicio(servicio);
        menu3.setServicio(servicio);

        this.menus.add(menu1);
        this.menus.add(menu2);
        this.menus.add(menu3);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void generarProveedores() {

        Proveedor proveedorMiguel = ProveedorBuilder
                .aProveedor()
                .withName("Miguel Bada")
                .withEMail("miguelenriquebada07@gmail.com")
                .withTelefono(123456)
                .withLocalidad("Quilmes")
                .withCredito(0)
                .withPassword("Boquita")
                .build();

        this.proveedores.add(proveedorMiguel);

    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void generarClientes() {

        Cliente clienteMiguel = ClienteBuilder
                .aUsuario()
                .withName("Juan Perez")
                .withEMail("migbad_7@hotmail.com")
                .withTelefono(78910)
                .withLocalidad("Bernal")
                .withCredito(500)
                .build();

        this.clientes.add(clienteMiguel);

    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

