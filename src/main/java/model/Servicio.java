package model;



import java.util.ArrayList;
import java.util.Collections;


import java.util.Date;
import java.util.Map;

public class Servicio {

    //Long id;
    String nombre;
    String logo;
    String lOcalidad;
    String ubicacion;
    String descripcion;
    String dirWeb;
    String email;
    int telefono;
    Map<Map<Date,Date>,String> horariosYDias;
    ArrayList<String> localidadDeEntregas;
    ArrayList<Menu> menues;


    public  Servicio(String name){
        this.nombre = name;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String name){
        this.nombre = name;
    }

    public String getLogo(){
        return logo;
    }

    public void setLogo(String logo){
        this.logo = logo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Menu> getMenues() {
        return menues;
    }

    public void setMenues(ArrayList<Menu> menues) {
        this.menues = menues;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getLocalidadDeEntregas() {
        return localidadDeEntregas;
    }

    public void setLocalidadDeEntregas(ArrayList<String> localidadDeEntregas) {
        this.localidadDeEntregas = localidadDeEntregas;
    }

    public Map<Map<Date, Date>, String> getHorariosYDias() {
        return horariosYDias;
    }

    public void setHorariosYDias(Map<Map<Date, Date>, String> horariosYDias) {
        this.horariosYDias = horariosYDias;
    }

    public String getlOcalidad() {
        return lOcalidad;
    }

    public void setlOcalidad(String lOcalidad) {
        this.lOcalidad = lOcalidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
