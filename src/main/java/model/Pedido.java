package model;

import desappgroupd.Menu;
import desappgroupd.TipoDeEntrega;

import java.util.Date;

public class Pedido {

    private Menu menu;
    private int cantidad;

   // @Enumerated(value = EnumType.STRING)
    private TipoDeEntrega tipoEntrega;

    private Date fechaEntrega;
    private int horaEntrega;
    private int precioFinal;
    private int tiempoDeEntrega;

    public Pedido(){

    };

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

    public TipoDeEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoDeEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Pedido generarPedido(Menu m, int cant, TipoDeEntrega t, Date fechaEntrega, int horaEntrega){
        Pedido resPedido = new Pedido();
        resPedido.setCantidad(cant);
        resPedido.setFechaEntrega(fechaEntrega);
        resPedido.setHoraEntrega(horaEntrega);
        resPedido.setMenu(m);
        resPedido.setTipoEntrega(t);
        resPedido.setTiempoDeEntrega(obtenerTIempoDEEntrega(m,t));
       // resPedido.setPrecioFinal(obtenerPrecio());

        return resPedido;
    }

    public int obtenerTIempoDEEntrega(Menu menu, TipoDeEntrega t){
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

    public int obtenerPrecio(){
        return this.getMenu().getPrecio() * this.cantidad;
    }

}
