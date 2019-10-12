package model;

import desappgroupd.Menu;
import model.Exceptions.ValidacionException;
import desappgroupd.TipoDeEntrega;

import java.util.Date;

public class Cliente extends Usuario {

    public Cliente(){
    }


    public void cargarDinero(int creditoACargar){
        setCredito(getCredito()+ creditoACargar);
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
        Compra compra = new Compra(pedido, this);
        int totalCompra = pedido.getPrecioFinal();
        Proveedor proveedor = pedido.getMenu().getServicio().getProveedor();

        compra.actualizarSaldos(totalCompra, this, proveedor);

    }

}
