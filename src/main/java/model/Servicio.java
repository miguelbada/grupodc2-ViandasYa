package model;



import model.Exceptions.ValidacionException;

import java.util.*;

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
    Map<Date,String> horariosYDias;
    ArrayList<String> localidadDeEntregas;
    ArrayList<Menu> menues;


    public  Servicio(String name){
        this.nombre = name;
        this.menues = new ArrayList<Menu>();
        this.localidadDeEntregas = new ArrayList<String>();
        this.horariosYDias = new HashMap<Date,String>();
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

    public Map<Date, String> getHorariosYDias() {
        return horariosYDias;
    }

    public void setHorariosYDias(Map<Date, String> horariosYDias) {
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

    public void agregarMenu(Menu menuAAgregar){

        this.menues.add(menuAAgregar);
    }

    public void eliminarMenu(Menu menuAEliminar){
        /* recorro los menues y solo dejo aquellos que no sean el "menuAEliminar"*/
        ArrayList<Menu> newMenues = new ArrayList<Menu>();
        for (Menu n : this.getMenues()){
            if(!n.getNombre().equals(menuAEliminar.getNombre())){
                newMenues.add(n);
            }
        }
        setMenues(newMenues);
    }

    public Integer getCantMenuesVigentes(){
        int contador = 0;
        for (Menu m: getMenues()){
            Date menuFechaH = m.getFechasVigencias().getFechaHasta();
            if(menuFechaH.after( new Date())){
               contador++;
            }
        }
        return contador;
    }

    public void actualizarMenu(Menu menuUpdate) {

        for (Menu m : getMenues()){
            if(m.getNombre().equals(menuUpdate.getNombre())){
                m.actualizarDatos(menuUpdate);
            }
        }
    }

}
