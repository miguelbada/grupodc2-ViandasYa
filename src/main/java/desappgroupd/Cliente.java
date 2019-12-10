package desappgroupd;

import desappgroupd.Exceptions.ClienteSinCreditoSuficiente;
import desappgroupd.Exceptions.ValidacionException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
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
        Proveedor proveedor = pedido.getMenu().getServicio().getProveedor();

       actualizarSaldos(pedido.getPrecioFinal(), this, proveedor);

       this.agregarPedido(pedido);
       proveedor.agregarPedido(pedido);
    }


    public void actualizarSaldos(int totalCompra, Cliente cliente, Proveedor proveedor) {
        if(cliente.getCredito() < totalCompra) {
            throw new ClienteSinCreditoSuficiente();
        }

        proveedor.agregarCredito(totalCompra);
        cliente.descontarCredito(totalCompra);
    }

}
