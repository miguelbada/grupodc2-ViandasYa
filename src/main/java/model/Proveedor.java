package model;

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
}
