package model;

import desappgroupd.Menu;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    ArrayList<Menu> menuSeleccionados;
    int cantidad;
    Usuario.TiposDeEntrega tipoEntrega;
    Date fechaEntrega;
    int horaEntrega;
    int precioFinal;
    int tiempoDeEntrega;

    public Pedido(){};

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(int horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public void setTiempoDeEntrega(int tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }

    public ArrayList<Menu> getMenuSeleccionados() {
        return menuSeleccionados;
    }

    public void setMenuSeleccionados(ArrayList<Menu> menuSeleccionado) {
        this.menuSeleccionados = menuSeleccionado;
    }

    public Usuario.TiposDeEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(Usuario.TiposDeEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }


    public static Pedido generarPedido(ArrayList<Menu> ms, int cant, Usuario.TiposDeEntrega t, Date fechaEntrega, int horaEntrega){
        Pedido resPedido = new Pedido();
        resPedido.setCantidad(cant);
        resPedido.setFechaEntrega(fechaEntrega);
        resPedido.setHoraEntrega(horaEntrega);
        resPedido.setMenuSeleccionados(ms);
        resPedido.setTipoEntrega(t);
        resPedido.setTiempoDeEntrega(obtenerTIempoDEEntrega(ms,t));
        resPedido.setPrecioFinal(obtenerPrecio(ms));

        return resPedido;
    }

    public static int obtenerTIempoDEEntrega(ArrayList<Menu> menus, Usuario.TiposDeEntrega t){
        int res = 0;
        switch(t){
            case RETIRAR: /*(tiempo máximo de los menú seleccionados)*/ /* FALTA COMPLETAR ESTO, HAY QUE PREGUNTAR BIEN*/
                res = 0;
                break;
            case DOMICILIO: /*(tiempo máximo de los menú seleccionados + tiempo estimado en llegar)*/
                res = 1;
                break;
        }

        return res;
    }

    public static int obtenerPrecio(ArrayList<Menu> ms){
        int preciofinal = 0;
        for( Menu m: ms){
            preciofinal +=m.getPrecio();
        }

        return preciofinal;
    }

}
