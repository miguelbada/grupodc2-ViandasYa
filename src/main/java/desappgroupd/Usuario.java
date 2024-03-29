package desappgroupd;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue Long id;
    private String nombreYApellido;

    private String password;
    private String email;
    private int telefono;
    private String localidadYDireccion;

    @OneToOne(cascade= CascadeType.ALL)
    private Cuenta cuenta;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public Usuario() {
        this.cuenta = new Cuenta();
        this.pedidos = new ArrayList<Pedido>();
    }

    public Usuario(String nombreYApellido, String email, int telefono, String localidadYDireccion) {
        this.nombreYApellido = nombreYApellido;
        this.email = email;
        this.telefono = telefono;
        this.localidadYDireccion = localidadYDireccion;
        this.cuenta = new Cuenta();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        this.cuenta.descontarCredito(credito);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void setPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
