package model;

import model.Exceptions.ValidacionException;

import java.util.ArrayList;

public class Proveedor extends Usuario{
    ArrayList<Servicio> servicios;

    public Proveedor(String nombre) {
        super(nombre);
    }
    public  ArrayList<Servicio> getServicios(){
        return  this.servicios;
    }

    public void setServicios(ArrayList<Servicio> services){
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

    public Servicio obtenerServicioEnParticular(String serviceABUscar){
        /*Retorno el servicio a buscar*/
        Servicio serviceARetornar = null;
        for(Servicio s : servicios){
            if(s.getNombre().equals(serviceABUscar)){
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




}
