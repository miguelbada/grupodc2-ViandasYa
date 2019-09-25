package model;

import model.Exceptions.ValidacionException;
import model.Utils.MenuBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {


    @Test
    public void seCreaUnMenuConCantidadesMinimasExcluyentes(){
        Menu menuTest = MenuBuilder.aMenu().withName("Menu test")
                .withPrecio(15)
                .withCategoria("Pizza")
                .withDescripcion("Test menu")
                .withValorDelirevy(21)
                .withCantidadMaxVentasXDia(59)
                .build();

        menuTest.setPrecioCantMin(10);
        assertEquals(menuTest.getPrecioCantMin(), 10);

        menuTest.setPrecioCantMin2(5);
        assertEquals(menuTest.getPrecioCantMin2(), 5);
    }

    @Test
    public void seCreaUnMenuConPrecioCantMinMayorAlPrecioPrincipal(){
        Menu menuTest = MenuBuilder.aMenu().withName("Menu test")
                .withPrecio(15)
                .withCategoria("Pizza")
                .withDescripcion("Test menu")
                .withValorDelirevy(21)
                .withCantidadMaxVentasXDia(59)
                .build();

        menuTest.setPrecioCantMin(20);
        assertEquals(menuTest.getPrecioCantMin(), 0);

        menuTest.setPrecioCantMin2(5);
        assertEquals(menuTest.getPrecioCantMin2(), 0);
    }

}
