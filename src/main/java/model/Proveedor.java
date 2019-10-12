package model;

import desappgroupd.Menu;
import desappgroupd.Servicio;
import model.Exceptions.ValidacionException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proveedor extends Usuario {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proveedor")
    private List<Servicio> servicios;

    public Proveedor() {
        this.servicios = new ArrayList<Servicio>();
    }

    public List<Servicio> getServicios(){
        return  this.servicios;
    }

    public void setServicios(List<Servicio> services){
        this.servicios = services;
    }

    public  void darDeAltaUnServicio(Servicio servicio){
        this.servicios.add(servicio);
    }

    public void generarMenu(String serviceName, Menu menuAAgregar) throws ValidacionException {
        /* Agrego un menu a un determinado servicio */

        if(chequearMenuesVigentes()){
            Servicio service = obtenerServicioEnParticular(serviceName);
            service.agregarMenu(menuAAgregar);
        }else {
            throw  new ValidacionException("No se pudo generar el Menu:" + menuAAgregar.getNombre() + " , la cantidad de menues vigentes supera o es igual a 20 ");
        }

    }

    public Boolean chequearMenuesVigentes(){
        int cantMenuesVigentes = 0;
        for (Servicio service : getServicios()){

            cantMenuesVigentes = cantMenuesVigentes + service.getCantMenuesVigentes();
        }

        if(cantMenuesVigentes >= 20){
            return false;
        }
        return  true;

    }

    public Servicio obtenerServicioEnParticular(String serviceABuscar){
        /*Retorno el servicio a buscar*/
        Servicio serviceARetornar = null;
        for(Servicio s : servicios){
            if(s.getNombre().equals(serviceABuscar)){
                serviceARetornar = s;
            }
        }
        return serviceARetornar;
    }

    public void eliminarMenu(String serviceName, Menu menuAEliminar){
        /* elimino un menu de un determinado servicio */
        Servicio service = obtenerServicioEnParticular(serviceName);
        service.eliminarMenu(menuAEliminar);

    }

    public void actualizarMenu(String serviceName, Menu menuUpdate) throws ValidacionException {
        /* elimino un menu de un determinado servicio */
        Servicio service = obtenerServicioEnParticular(serviceName);
        service.actualizarMenu(menuUpdate);

    }

    public void retirarCredito(int creditoASacar){
        if(getCredito()> creditoASacar){
            setCredito(getCredito()-creditoASacar);
        }
    }
}
