package model;

import model.Exceptions.ClienteSinCreditoSuficiente;

public class Compra {

    public Compra(){

    }

    public Compra(Pedido pedido, Cliente cliente) {
        actualizarSaldos(pedido.getPrecioFinal(), cliente, pedido.getMenu().getServicio().getProveedor());

    }

    public void actualizarSaldos(int totalCompra, Cliente cliente, Proveedor proveedor) {
        if(cliente.getCredito() < totalCompra) {
            throw new ClienteSinCreditoSuficiente();
        }

        proveedor.agregarCredito(totalCompra);
        cliente.descontarCredito(totalCompra);
    }

    public void notificarCompraPorMail(Pedido pedido, Cliente cliente) {

    }
}
