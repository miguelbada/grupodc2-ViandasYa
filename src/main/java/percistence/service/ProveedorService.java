package percistence.service;

import desappgroupd.Proveedor;

import java.util.List;

public interface ProveedorService {

    void addProveedor(Proveedor proveedor);
    List<Proveedor> proveedores();
}
