package percistence.service;

import desappgroupd.Cliente;
import java.util.List;

public interface ClienteService {

    void addCliente(Cliente cliente);
    List<Cliente> clientes();
}
