package model.Utils;

import model.Usuario;

public class UsuarioBuilder {

    public static UsuarioBuilder aUsuario() {

        return new UsuarioBuilder();

    }

    private String name = "no name";
    private String eMail = "no email";
    private int telefono = 0;
    private String localidadDIreccion = "no localidad";
    private int credito = 0;

    public Usuario build() {

        Usuario usuario = new Usuario(name);
        usuario.setCredito(credito);
        usuario.setLocalidadDIreccion(localidadDIreccion);
        usuario.seteMail(eMail);
        usuario.setTelefono(telefono);
        return usuario;
    }

    public UsuarioBuilder withName(final String aName) {

        name = aName;
        return this;
    }

    public UsuarioBuilder withEMail(final String email) {


        eMail = email;
        return this;
    }
    public UsuarioBuilder withTelefono(final int tel) {

        telefono = tel;
        return this;
    }


    public UsuarioBuilder withCredito(final int credito) {

        this.credito = credito;
        return this;
    }

    public UsuarioBuilder withLocalidad(final String local) {

        this.localidadDIreccion = local;
        return this;
    }
}
