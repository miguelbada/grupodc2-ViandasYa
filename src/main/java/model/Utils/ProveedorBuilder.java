package model.Utils;

import model.Proveedor;
import desappgroupd.Servicio;

import java.util.ArrayList;

public class ProveedorBuilder {


    public static ProveedorBuilder aProveedor() {

        return new ProveedorBuilder();

    }

    private String name = "no name";
    private String eMail = "no email";
    private int telefono = 0;
    private String localidadDIreccion = "no localidad";
    private int credito = 0;
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();


    public Proveedor build() {

        Proveedor proveedor = new Proveedor(name);
        proveedor.setServicios(servicios);
        proveedor.setCredito(credito);
        proveedor.setLocalidadDIreccion(localidadDIreccion);
        proveedor.seteMail(eMail);
        proveedor.setTelefono(telefono);
        return proveedor;
    }

    public ProveedorBuilder withName(final String aName) {

        name = aName;
        return this;
    }

    public ProveedorBuilder withEMail(final String email) {


        eMail = email;
        return this;
    }
    public ProveedorBuilder withTelefono(final int tel) {

        telefono = tel;
        return this;
    }


    public ProveedorBuilder withCredito(final int credito) {

        this.credito = credito;
        return this;
    }

    public ProveedorBuilder withLocalidad(final String local) {

        this.localidadDIreccion = local;
        return this;
    }

    public ProveedorBuilder withServicios(final ArrayList<Servicio> services) {

        this.servicios = services;
        return this;
    }
}
