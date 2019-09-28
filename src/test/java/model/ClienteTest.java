package model;

import desappgroupd.Menu;
import model.Exceptions.ValidacionException;
import model.Utils.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

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
                .withCategoria("Pizza")
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
    public void unClienteCompraUnMenuDeUnServicioADomicilio() throws ValidacionException {
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(menuTest);

        Pedido pedido =  userTest.hacerPedido(menus,2, Usuario.TiposDeEntrega.DOMICILIO, new Date(2019,9,26), 1600);
        assertEquals(pedido.precioFinal,15 );
    }

}
