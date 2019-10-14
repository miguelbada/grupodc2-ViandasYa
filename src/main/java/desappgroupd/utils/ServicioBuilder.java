package desappgroupd.utils;

import desappgroupd.Menu;
import desappgroupd.Servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServicioBuilder {

    public static ServicioBuilder aServicio() {

        return new ServicioBuilder();

    }

    private String nombre = "no name";
    private String logo = "no logo";
    private String  lOcalidad = "no localidad";
    private String ubicacion = "no ubicacion";
    private String  descripcion = "no descipcion";
    private String  dirWeb = "no dirweb";
    private String  email = "no email";
    private int  telefono = 0;
    private   Map<Date,String> horariosYDias = new HashMap<Date, String>();
    private ArrayList<String> localidadDeEntregas = new ArrayList<String>();
    private ArrayList<Menu> menues = new ArrayList<Menu>();


    public Servicio build() {

        Servicio servicio = new Servicio(nombre);
        servicio.setLogo(logo);
        servicio.setDescripcion(descripcion);
        servicio.setDirWeb(dirWeb);
        servicio.setEmail(email);
        servicio.setHorariosYDias(horariosYDias);
        servicio.setLocalidad(lOcalidad);
        servicio.setLocalidadDeEntregas(localidadDeEntregas);
        servicio.setMenus(menues);
        servicio.setTelefono(telefono);
        servicio.setUbicacion(ubicacion);
        return servicio;
    }

    public ServicioBuilder withName(final String aName) {

        this.nombre = aName;
        return this;
    }

    public ServicioBuilder withLogo(final String alogo) {

        this.logo = alogo;
        return this;
    }

    public ServicioBuilder withLocalidad(final String aLocalidad) {

        this.lOcalidad = aLocalidad;
        return this;
    }


    public ServicioBuilder withUbicacion(final String aUbicacion) {

        this.ubicacion = aUbicacion;
        return this;
    }

    public ServicioBuilder withDescripcion(final String aDescripcion) {

        this.descripcion = aDescripcion;
        return this;
    }


    public ServicioBuilder withDirWeb(final String aDirWeb) {

        this.dirWeb = aDirWeb;
        return this;
    }

    public ServicioBuilder withEmail(final String aEmail) {

        this.email = aEmail;
        return this;
    }

    public ServicioBuilder withTelefono(final int aTelefono) {

        this.telefono = aTelefono;
        return this;
    }
}




