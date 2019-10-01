package model;

import desappgroupd.Menu;
import model.Exceptions.ValidacionException;
import model.Utils.TipoDeEntrega;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

    String nombreYApellido;
    String eMail;
    int telefono;
    String localidadDIreccion;
    Cuenta cUentaUsuario;

    public  Usuario(String name){

        this.nombreYApellido = name;
        this.cUentaUsuario = new Cuenta();
    }

    public  void setNombreYApellido(String  name){
        this.nombreYApellido = name;
    }

    public String  getNombreYApellido(){
        return this.nombreYApellido;
    }


    public void seteMail(String email){
        this.eMail = email;
    }

    public String geteMail(){
        return this.eMail;
    }

    public void setTelefono(int tel){
        this.telefono = tel;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public void setLocalidadDIreccion(String local){
        this.localidadDIreccion = local;
    }

    public String getLocalidadDIreccion() {
        return localidadDIreccion;
    }

    public void setCredito(int credito) {
        this.cUentaUsuario.setCredito(credito);
    }

    public int getCredito() {
        return this.cUentaUsuario.getCredito();
    }

    public Cuenta getcUentaUsuario() {
        return cUentaUsuario;
    }

    public void setcUentaUsuario(Cuenta cUentaUsuario) {
        this.cUentaUsuario = cUentaUsuario;
    }

    public void cargarDinero(int creditoACargar){
        setCredito(getCredito()+ creditoACargar);
    }

    public void retirarCredito(int creditoASacar){
        if(getCredito()> creditoASacar){
            setCredito(getCredito()-creditoASacar);
        }
    }

    public Pedido hacerPedido(Menu menuSeleccionado, int cantidad, TipoDeEntrega t, Date fechaEntrega, int horaEntrega) throws ValidacionException {

        if(fechaDeEntregaValida(fechaEntrega)){
            Pedido pedido = new Pedido();

            return pedido.generarPedido(menuSeleccionado,cantidad,t,fechaEntrega,horaEntrega);
        }else
        {
            throw  new ValidacionException("El pedido tiene que ser 48 horas antes de la fecha de entrega");
        }
    }

    public Boolean fechaDeEntregaValida(Date fecha){
        Date fechaHoy = new Date();
        int cantDias = fecha.getDay() - fechaHoy.getDay();
        return (cantDias <=2 )? true: false;

    }

    public void comprarPedido(Pedido pedido) {
        Compra compra = new Compra(pedido,this);
    }
}
