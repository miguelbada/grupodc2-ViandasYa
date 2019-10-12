package model.Utils;

import model.Cliente;

public class ClienteBuilder {

    public static ClienteBuilder aUsuario() {

        return new ClienteBuilder();

    }

    private String name = "no name";
    private String eMail = "no email";
    private int telefono = 0;
    private String localidadDIreccion = "no localidad";
    private int credito = 0;

    public Cliente build() {

        Cliente usuario = new Cliente();
        usuario.setNombreYApellido(name);
        usuario.setCredito(credito);
        usuario.setLocalidadYDireccion(localidadDIreccion);
        usuario.setEmail(eMail);
        usuario.setTelefono(telefono);
        return usuario;
    }

    public ClienteBuilder withName(final String aName) {

        name = aName;
        return this;
    }

    public ClienteBuilder withEMail(final String email) {


        eMail = email;
        return this;
    }
    public ClienteBuilder withTelefono(final int tel) {

        telefono = tel;
        return this;
    }


    public ClienteBuilder withCredito(final int credito) {

        this.credito = credito;
        return this;
    }

    public ClienteBuilder withLocalidad(final String local) {

        this.localidadDIreccion = local;
        return this;
    }
}
