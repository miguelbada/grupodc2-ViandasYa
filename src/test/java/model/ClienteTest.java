package model;

import desappgroupd.*;
import desappgroupd.Exceptions.ValidacionException;
import org.junit.Before;
import org.junit.Test;
import desappgroupd.utils.ClienteBuilder;
import desappgroupd.utils.MenuBuilder;
import desappgroupd.utils.ProveedorBuilder;
import desappgroupd.utils.ServicioBuilder;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ClienteTest {
    Cliente userTest;
    Proveedor proveedorTest;
    Servicio serviceTest;
    Menu menuTest;

    @Before
    public void SetUp(){
        userTest = ClienteBuilder.aUsuario().withEMail("migbad_7@hotmail.com")
                .withLocalidad("Quilmes")
                .withName("UserTest")
                .withTelefono(456657575)
                .build();

        proveedorTest =  ProveedorBuilder.aProveedor().withName("Mcdonals")
                .withEMail("miguelenriquebada@gmail.com")
                .withLocalidad("Florencio Varela")
                .withTelefono(45678798)
                .withCredito(100)
                .build();

        serviceTest = ServicioBuilder.aServicio().withName("ServicioTest")
                .withDirWeb("TestService.com.ar")
                .withDescripcion("testeando")
                .withEmail("ELSERVICE@gmail.com.ar")
                .withLocalidad("Quilmes Oeste")
                .withTelefono(43555676)
                .withUbicacion("Calchaqui 465")
                .build();
        menuTest = MenuBuilder.aMenu().withName("Menu test")
                .withPrecio(15)
                .withCategoria(Categoria.PIZZA)
                .withDescripcion("Test menu")
                .withValorDelirevy(21)
                .withCantidadMin(10)
                .withCantMin2(24)
                .withCantidadMaxVentasXDia(59)
                .build();
    }



    @Test
    public void unClienteCarga100PesosASuCuenta(){
    Cliente user = ClienteBuilder.aUsuario().withEMail("sara@hotmail.com")
                .withLocalidad("Quilmes")
                .withName("UserTest")
                .withTelefono(456657575)
                .build();

    user.cargarDinero(100);
    assertEquals(user.getCredito(),100);

    }

    @Test
    public void unClienteRealizaUnPedidoDeUnMenuDeUnServicioADomicilio() throws ValidacionException {
        menuTest.setServicio(serviceTest);
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(menuTest);
        serviceTest.setMenus(menus);
        Pedido pedido =  userTest.hacerPedido(menuTest,2, TipoDeEntrega.DOMICILIO, new Date(2019,9,26), 1600);
        assertEquals(pedido.obtenerPrecio(),30 );
    }

}
