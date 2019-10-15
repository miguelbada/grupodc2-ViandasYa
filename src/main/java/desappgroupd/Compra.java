package desappgroupd;

import desappgroupd.Exceptions.ClienteSinCreditoSuficiente;
import percistence.service.SendMailServiceImp;

public class Compra {

    public Compra(){

    }

    public void comprar(Pedido pedido, Cliente cliente) {
        actualizarSaldos(pedido.getPrecioFinal(), cliente, pedido.getMenu().getServicio().getProveedor());
        // notificarCompraPorMail(cliente.getEmail(), "Comprobante de compra", "Su compra se ha realizado exitosamente");
       // notificarCompraPorMail(pedido.getMenu().getServicio().getProveedor().getEmail(), "Venta", "Se ha realizado una venta exitosamente");

    }

    public void actualizarSaldos(int totalCompra, Cliente cliente, Proveedor proveedor) {
        if(cliente.getCredito() < totalCompra) {
            throw new ClienteSinCreditoSuficiente();
        }

        proveedor.agregarCredito(totalCompra);
        cliente.descontarCredito(totalCompra);
    }

    public void notificarCompraPorMail(String to, String subject, String text) {
        SendMailServiceImp mail = new SendMailServiceImp();

        mail.sendMail(to, subject, text);
    }
}
