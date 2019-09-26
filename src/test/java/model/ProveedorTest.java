package model;

import desappgroupd.Menu;
import model.Exceptions.ValidacionException;
import desappgroupd.FechaVigencia;
import model.Utils.MenuBuilder;
import model.Utils.ProveedorBuilder;
import model.Utils.ServicioBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ProveedorTest {


    Proveedor proveedorTest;
    Servicio serviceTest;
    Menu menuTest;

    @Before
    public void SetUp()  {
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
    public void UnProveedorDaDeAltaUnServicio(){
        Proveedor proveedor = proveedorTest;

        Servicio aServicio = serviceTest;
        proveedor.darDeAltaUnServicio(aServicio);

        assertEquals(proveedor.getServicios().size(), 1);
        assertEquals(proveedor.getServicios().get(0).getNombre(),"ServicioTest" );

    }

    @Test
    public void unProveedorCreaUnMenuParaUnServicio() throws ValidacionException {
        proveedorTest.darDeAltaUnServicio(serviceTest);

        proveedorTest.generarMenu(serviceTest.getNombre(), menuTest);

        assertEquals(proveedorTest.getServicios().size(), 1);
        assertEquals(proveedorTest.getServicios().get(0).getNombre(),"ServicioTest" );

        assertEquals(serviceTest.getMenues().size(),1);
        assertEquals(serviceTest.getMenues().get(0).getNombre(),"Menu test");


    }

    @Test
    public void unProveedorEliminaUnMenuVigente() throws ValidacionException {
        proveedorTest.darDeAltaUnServicio(serviceTest);

        proveedorTest.generarMenu(serviceTest.getNombre(), menuTest);
        assertEquals(serviceTest.getMenues().size(),1);
        assertEquals(serviceTest.getMenues().get(0).getNombre(),"Menu test");


        proveedorTest.eliminarMenu(serviceTest.getNombre(), menuTest);

        assertEquals(serviceTest.getMenues().size(),0);

    }

    @Test
    public void unProveedorActualizaUnMenuVigente()throws ValidacionException{
        proveedorTest.darDeAltaUnServicio(serviceTest);

        proveedorTest.generarMenu(serviceTest.getNombre(), menuTest);
        assertEquals(serviceTest.getMenues().size(),1);
        assertEquals(serviceTest.getMenues().get(0).getNombre(),"Menu test");
        assertEquals(serviceTest.getMenues().get(0).getDescripcion(),"Test menu");

        Menu menuUpdate = MenuBuilder.aMenu().withName("Menu test")
                .withPrecio(15)
                .withCategoria("Pizza")
                .withDescripcion("Test menu actualizado")
                .withValorDelirevy(21)
                .withCantidadMin(10)
                .withCantMin2(24)
                .withCantidadMaxVentasXDia(59)
                .build();
        proveedorTest.actualizarMenu(serviceTest.getNombre(), menuUpdate );
        assertEquals(serviceTest.getMenues().get(0).getDescripcion(),"Test menu actualizado");

    }

    @Test(expected = ValidacionException.class)
    public void unProveedorCon20MenuesVigentesIntentaAgregarOtroMenu() throws ValidacionException {

        Menu menu1 = MenuBuilder.aMenu().withName("menu1")
                .withFechasVigencias(new FechaVigencia(new Date(2019,05,12),new Date(2019,10,05)))
                .build();
        ArrayList<Menu> menues = new ArrayList<Menu>();
        menues.add(menu1);  menues.add(menu1); menues.add(menu1);
        menues.add(menu1); menues.add(menu1); menues.add(menu1);
        menues.add(menu1); menues.add(menu1); menues.add(menu1);
        menues.add(menu1); menues.add(menu1); menues.add(menu1);
        menues.add(menu1); menues.add(menu1); menues.add(menu1);
        menues.add(menu1); menues.add(menu1); menues.add(menu1);
        menues.add(menu1); menues.add(menu1);
        serviceTest.setMenues(menues);
        proveedorTest.darDeAltaUnServicio(serviceTest);

        assertEquals(serviceTest.getMenues().size(),20);

        Menu menu21 = MenuBuilder.aMenu().withName("menu21")
                .withFechasVigencias(new FechaVigencia(new Date(2019,05,12),new Date(2019,12,25)))
                .build();

        proveedorTest.generarMenu(serviceTest.getNombre(), menu21);
        assertEquals(serviceTest.getMenues().size(),20);
        /* SE TESTEA LA ESXCEPCION*/

    }

    @Test
    public void unProveedorRetiraDineroDeSuCuenta(){
        assertEquals(proveedorTest.getCredito(), 100);

        proveedorTest.retirarCredito(20);
        assertEquals(proveedorTest.getCredito(), 80);
    }

    @Test
    public void unProveedorIntentaRetirarMasCreditoDelQueTieneEnSuCuenta(){

        assertEquals(proveedorTest.getCredito(), 100);

        proveedorTest.retirarCredito(120);
        /*como no hay credito suficiente no se permitio retirar dinero*/
        assertEquals(proveedorTest.getCredito(), 100);
    }



}
