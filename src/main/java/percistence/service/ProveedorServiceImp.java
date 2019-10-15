package percistence.service;

import desappgroupd.Proveedor;
import desappgroupd.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorServiceImp implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public void addProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public List<Proveedor> proveedores() {
        List<Proveedor> proveedorList = new ArrayList<Proveedor>();
        Iterable<Proveedor> proveedores = proveedorRepository.findAll();
        for (Proveedor proveedor : proveedores) {
            proveedorList.add(proveedor);
        }

        return proveedorList;
    }
}
