package model;

import model.Exceptions.ValidacionException;
import model.Utils.FechaVigencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    String nombre;
    String descripcion;
    String categoria;
    int valorDelirevy;
    FechaVigencia fechasVigencias;
    ArrayList<Date> horariosDeENtrega;
    int tiemporEntregaPromedio;
    int precio;
    int cantidadMin;
    int precioCantMin;
    int cantMin2; //Opcional
    int precioCantMin2; // Opcional
    int cantidadMaxVentasXDia;

/*
* Las cantidades mínimas deberán ser  mutuamente excluyentes entre los 2 segmentos.
*  El precio *Min2 debe ser menor que *Min1 y este debe ser menor a Precio.
* No se permiten mas ventas que la cantidad máxima.
*/
    public Menu(String name){
        this.nombre = name;
        this.horariosDeENtrega = new ArrayList<Date>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public ArrayList<Date> getHorariosDeENtrega() {
        return horariosDeENtrega;
    }

    public void setHorariosDeENtrega(ArrayList<Date> horariosDeENtrega) {
        this.horariosDeENtrega = horariosDeENtrega;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMaxVentasXDia() {
        return cantidadMaxVentasXDia;
    }

    public void setCantidadMaxVentasXDia(int cantidadMaxVentasXDia) {
        this.cantidadMaxVentasXDia = cantidadMaxVentasXDia;
    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public int getCantMin2() {
        return cantMin2;
    }

    public void setCantMin2(int cantMin2) {
        this.cantMin2 = cantMin2;
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

    public int getPrecioCantMin() {
        return precioCantMin;
    }

    public void setPrecioCantMin(int precioCantMin) {
        if(precioCantMin < precio){
            this.precioCantMin = precioCantMin;
        }
    }

    public int getPrecioCantMin2() {
        return precioCantMin2;
    }

    public void setPrecioCantMin2(int precioCantMin2)  {
        if(precioCantMin2 < precioCantMin){
            this.precioCantMin2 = precioCantMin2;
        }
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

