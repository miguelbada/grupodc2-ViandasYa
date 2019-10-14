package desappgroupd;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public abstract class Usuario {

    @Id
    private String nombreYApellido;
    private String email;
    private int telefono;
    private String localidadYDireccion;

    @OneToOne(cascade= CascadeType.ALL)
    private Cuenta cuenta;

    public Usuario() {
        this.cuenta = new Cuenta();
    }

    public Usuario(String nombreYApellido, String email, int telefono, String localidadYDireccion) {
        this.nombreYApellido = nombreYApellido;
        this.email = email;
        this.telefono = telefono;
        this.localidadYDireccion = localidadYDireccion;
        this.cuenta = new Cuenta();
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLocalidadYDireccion() {
        return localidadYDireccion;
    }

    public void setLocalidadYDireccion(String localidadYDireccion) {
        this.localidadYDireccion = localidadYDireccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getCredito() {
        return cuenta.getCredito();
    }

    public void setCredito(int credito) {
        cuenta.setCredito(credito);
    }

    public void agregarCredito(int credito) {
        this.cuenta.agregarCredito(credito);
    }

    public void descontarCredito(int credito) {
        this.cuenta.descontarCredito();
    }

}
