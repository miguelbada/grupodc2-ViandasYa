package controller;

import desappgroupd.Cliente;
import desappgroupd.ClienteRepository;
import desappgroupd.Pedido;
import desappgroupd.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private SendMailController sendMailController;


    @GetMapping("/clientes")
    List<Cliente> getAll() {
        /*get all clientes from clienteRepository*/
        return (List<Cliente>) clienteRepository.findAll();
    }

    @RequestMapping(value = "/comprar/{id}")
    public String comprar(@RequestBody Pedido pedido, @PathVariable Long id) {

        Cliente cliente = (Cliente) usuarioController.getOne(id);
        cliente.comprarPedido(pedido);
        Proveedor proveedor = pedido.getMenu().getServicio().getProveedor();
        Long idProveedor = proveedor.getId();

        usuarioController.replaceUsuario(cliente, id);
        usuarioController.replaceUsuario(proveedor, idProveedor);

        sendMailController.enviarEmail(cliente.getEmail(), "Compra", "Detalle de su compra \n" + pedido.detalleDePedido());
        sendMailController.enviarEmail(proveedor.getEmail(),"Venta","Detalle de su venta \n " + pedido.detalleDePedido());

        return "The purchase was successful";
    }

}
