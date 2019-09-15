package model;

import model.Utils.ProveedorBuilder;
import model.Utils.ServicioBuilder;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProveedorTest {

    @Test
    public void testVerificacionTravis() {
        assertEquals(1,1);
    }

    @Test
    public void UnProveedorDaDeAltaUnServicio(){
        Proveedor proveedor = ProveedorBuilder.aProveedor().withName("Mcdonals")
                .withEMail("Mcdonals@tuMc.com.ar")
                .withLocalidad("Florencio Varela")
                .withTelefono(45678798)
                .withCredito(100)
                .build();

       // new HashMap<String, Integer>().put("sebva",0);

        Servicio aServicio = ServicioBuilder.aServicio().withName("ServicioTest")
                .withDirWeb("TestService.com.ar")
                .withDescripcion("testeando")
                .withEmail("ELSERVICE@gmail.com.ar")
                .withLocalidad("Quilmes Oeste")
                .withTelefono(43555676)
                .withUbicacion("Calchaqui 465")
                .build();
        proveedor.darDeAltaUnServicio(aServicio);

        assertEquals(proveedor.getServicios().size(), 1);
        assertEquals(proveedor.getServicios().get(0).getNombre(),"ServicioTest" );

    }
}
