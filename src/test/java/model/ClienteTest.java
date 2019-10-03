package model;

import desappgroupd.Categoria;
import desappgroupd.Menu;
import desappgroupd.Servicio;
import desappgroupd.TipoDeEntrega;
import model.Exceptions.ValidacionException;
import model.Utils.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClienteTest {
    Usuario userTest;
    Proveedor proveedorTest;
    Servicio serviceTest;
    Menu menuTest;

    @Before
    public void SetUp(){
        userTest = UsuarioBuilder.aUsuario().withEMail("sara@hotmail.com")
                .withLocalidad("Quilmes")
                .withName("UserTest")
                .withTelefono(456657575)
                .build();

        proveedorTest =  ProveedorBuilder.aProveedor().withName("Mcdonals")
                .withEMail("Mcdonals@tuMc.com.ar")
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
    Usuario user = UsuarioBuilder.aUsuario().withEMail("sara@hotmail.com")
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
        List<Menu> menus = new ArrayList<Menu>();
        menus.add(menuTest);
        serviceTest.setMenus((ArrayList<Menu>) menus);
        Pedido pedido =  userTest.hacerPedido(menuTest,2, TipoDeEntrega.DOMICILIO, new Date(2019,9,26), 1600);
        assertEquals(pedido.obtenerPrecio(),30 );
    }

}
