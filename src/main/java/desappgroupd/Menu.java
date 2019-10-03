package desappgroupd;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Menu {

    @Id
    private String nombre;

    private String descripcion;

    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;

    private int valorDelirevy;

    @OneToOne(cascade= CascadeType.ALL)
    private FechaVigencia fechasVigencias; // desde - hasta

    @ElementCollection
    private List<Date> horariosDeENtrega;

    private int tiemporEntregaPromedio;
    private int precio;
    private int cantidadMin;
    private int precioCantMin;
    private int cantMin2; //Opcional
    private int precioCantMin2; // Opcional
    private int cantidadMaxVentasXDia;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Servicio servicio;

/*
* Las cantidades mínimas deberán ser  mutuamente excluyentes entre los 2 segmentos.
*  El precio *Min2 debe ser menor que *Min1 y este debe ser menor a Precio.
* No se permiten mas ventas que la cantidad máxima.
*/
    public Menu() {

    }

    public Menu(String name){
        this.nombre = name;
        this.horariosDeENtrega = new ArrayList<Date>();
    }

    public Menu(String name, String descripcion, Categoria categoria, int valorDelirevy, FechaVigencia fechaVigencias, List<Date> horariosDeENtrega, int tiemporEntregaPromedio, int precio,int cantidadMin, int precioCantMin, int cantidadMaxVentasXDia, Servicio servicio) {
        this.nombre = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.valorDelirevy = valorDelirevy;
        this.fechasVigencias = fechaVigencias;
        this.horariosDeENtrega = horariosDeENtrega;
        this.tiemporEntregaPromedio = tiemporEntregaPromedio;
        this.precio = precio;
        this.cantidadMin = cantidadMin;
        this.precioCantMin = precioCantMin;
        this.cantidadMaxVentasXDia = cantidadMaxVentasXDia;
        this.servicio = servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getValorDelirevy() {
        return valorDelirevy;
    }

    public void setValorDelirevy(int valorDelirevy) {
        this.valorDelirevy = valorDelirevy;
    }

    public FechaVigencia getFechasVigencias() {
        return fechasVigencias;
    }

    public void setFechasVigencias(FechaVigencia fechasVigencias) {
        this.fechasVigencias = fechasVigencias;
    }

    public List<Date> getHorariosDeENtrega() {
        return horariosDeENtrega;
    }

    public void setHorariosDeENtrega(List<Date> horariosDeENtrega) {
        this.horariosDeENtrega = horariosDeENtrega;
    }

    public int getTiemporEntregaPromedio() {
        return tiemporEntregaPromedio;
    }

    public void setTiemporEntregaPromedio(int tiemporEntregaPromedio) {
        this.tiemporEntregaPromedio = tiemporEntregaPromedio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public int getPrecioCantMin() {
        return precioCantMin;
    }

    public void setPrecioCantMin(int precioCantMin) {
        if(precioCantMin < precio) {
            this.precioCantMin = precioCantMin;
        }
    }

    public int getCantMin2() {
        return cantMin2;
    }

    public void setCantMin2(int cantMin2) {
        this.cantMin2 = cantMin2;
    }

    public int getPrecioCantMin2() {
        return precioCantMin2;
    }

    public void setPrecioCantMin2(int precioCantMin2) {
        if(precioCantMin2 < precioCantMin){
            this.precioCantMin2 = precioCantMin2;
        }
    }

    public int getCantidadMaxVentasXDia() {
        return cantidadMaxVentasXDia;
    }

    public void setCantidadMaxVentasXDia(int cantidadMaxVentasXDia) {
        this.cantidadMaxVentasXDia = cantidadMaxVentasXDia;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
        this.servicio.agregarMenu(this);
    }

    public  void actualizarDatos(Menu menuUpdate){
        setDescripcion(menuUpdate.getDescripcion());
        setFechasVigencias(menuUpdate.getFechasVigencias());
        setValorDelirevy(menuUpdate.getValorDelirevy());
        setTiemporEntregaPromedio(menuUpdate.getTiemporEntregaPromedio());
        setPrecioCantMin2(menuUpdate.getPrecioCantMin2());
        setPrecioCantMin(menuUpdate.getPrecioCantMin());
        setPrecio(menuUpdate.getPrecio());
        setHorariosDeENtrega(menuUpdate.getHorariosDeENtrega());
        setCategoria(menuUpdate.getCategoria());
        setCantMin2(menuUpdate.getCantMin2());
        setCantidadMin(menuUpdate.getCantidadMin());
        setCantidadMaxVentasXDia(menuUpdate.getCantidadMaxVentasXDia());
        setNombre(menuUpdate.getNombre());
    }
}

