package percistence.service;

import desappgroupd.Cliente;
import desappgroupd.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);

    }

    @Override
    public List<Cliente> clientes() {
        List<Cliente> clienteList = new ArrayList<>();
        Iterable<Cliente> clientes = clienteRepository.findAll();
        for(Cliente cliente: clientes) {
            clienteList.add(cliente);
        }
        return clienteList;
    }

}
