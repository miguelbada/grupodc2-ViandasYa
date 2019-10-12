package desappgroupd;

import com.fasterxml.jackson.annotation.JsonFormat;
import desappgroupd.Menu;
import model.Proveedor;

import javax.persistence.*;
import java.util.*;

@Entity
public class Servicio {

    @Id
    private String nombre;

    private String logo;
    private String localidad;
    private String ubicacion;
    private String descripcion;
    private String dirWeb;
    private String email;
    private int telefono;

    @ElementCollection
    private Map<Date,String> horariosYDias;

    @ElementCollection
    private List<String> localidadDeEntregas;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Menu> menus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     private Proveedor proveedor;

    public Servicio() {

    }

    public  Servicio(String name){
        this.nombre = name;
        this.menus = new ArrayList<Menu>();
        this.localidadDeEntregas = new ArrayList<String>();
        this.horariosYDias = new HashMap<Date,String>();
    }

    public Servicio(String nombre, String logo, String localidad, String ubicacion, String descripcion, String dirWeb, String email, int telefono, Map<Date, String> horariosYDias, List<String> localidadDeEntregas) {
        this.nombre = nombre;
        this.logo = logo;
        this.localidad = localidad;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.dirWeb = dirWeb;
        this.email = email;
        this.telefono = telefono;
        this.horariosYDias = horariosYDias;
        this.localidadDeEntregas = localidadDeEntregas;
        this.menus = new ArrayList<Menu>();
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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
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

    public List<String> getLocalidadDeEntregas() {
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void agregarMenu(Menu menuAAgregar){

        this.menus.add(menuAAgregar);
    }

    public void eliminarMenu(Menu menuAEliminar){
        /* recorro los menues y solo dejo aquellos que no sean el "menuAEliminar"*/
        ArrayList<Menu> newMenues = new ArrayList<Menu>();
        for (Menu n : this.getMenus()){
            if(!n.getNombre().equals(menuAEliminar.getNombre())){
                newMenues.add(n);
            }
        }
        setMenus(newMenues);
    }

    public Integer getCantMenuesVigentes(){
        int contador = 0;
        for (Menu m: getMenus()){
            Date menuFechaH = m.getFechasVigencias().getFechaHasta();
            if(menuFechaH.after( new Date())){
               contador++;
            }
        }
        return contador;
    }

    public void actualizarMenu(Menu menuUpdate) {

        for (Menu m : getMenus()){
            if(m.getNombre().equals(menuUpdate.getNombre())){
                m.actualizarDatos(menuUpdate);
            }
        }
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
