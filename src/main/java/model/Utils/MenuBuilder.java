package model.Utils;

import model.Exceptions.ValidacionException;
import model.Menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MenuBuilder {

    public static MenuBuilder aMenu() {

        return new MenuBuilder();

    }

    private String nombre = "no Name";
    private String descripcion = "no Descripcion";
    private String categoria = " no categoria";
    private int valorDelirevy = 0;
    private FechaVigencia fechasVigencias = new FechaVigencia( new Date(), new Date());
    private ArrayList<Date> horariosDeENtrega = new ArrayList<Date>();
    private int tiemporEntregaPromedio = 0;
    private int precio= 0;
    private int cantidadMin = 0;
    private int precioCantMin = 0;
    private int cantMin2 = 0; //Opcional
    private int precioCantMin2 = 0; // Opcional
    private int cantidadMaxVentasXDia = 0;


    public Menu build() {

        Menu menu = new Menu(nombre);
        menu.setCantidadMaxVentasXDia(cantidadMaxVentasXDia);
        menu.setCantidadMin(cantidadMin);
        menu.setCantMin2(cantMin2);
        menu.setCategoria(categoria);
        menu.setDescripcion(descripcion);
        menu.setFechasVigencias(fechasVigencias);
        menu.setHorariosDeENtrega(horariosDeENtrega);
        menu.setPrecio(precio);
        menu.setPrecioCantMin(precioCantMin);
        menu.setPrecioCantMin2(precioCantMin2);
        menu.setTiemporEntregaPromedio(tiemporEntregaPromedio);
        menu.setValorDelirevy(valorDelirevy);
        return menu;
    }


    public MenuBuilder withName(String name) {
        this.nombre = name;
        return this;
    }

    public MenuBuilder withDescripcion(String des) {
        this.descripcion = des;
        return this;
    }

    public MenuBuilder withCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public MenuBuilder withValorDelirevy(int valorDelirevy) {
        this.valorDelirevy = valorDelirevy;
        return this;
    }

    public MenuBuilder withFechasVigencias(FechaVigencia fechasVigencias) {
        this.fechasVigencias = fechasVigencias;
        return this;
    }


    public MenuBuilder withHorariosDeENtrega(ArrayList<Date> horariosDeENtrega) {
        this.horariosDeENtrega = horariosDeENtrega;
        return this;
    }

    public MenuBuilder withTiemporEntregaPromedio(int tiemporEntregaPromedio) {
        this.tiemporEntregaPromedio = tiemporEntregaPromedio;
        return this;
    }

    public MenuBuilder withCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
        return this;
    }

    public MenuBuilder withPrecio(int precio) {
        this.precio = precio;
        return this;
    }

    public MenuBuilder withCantMin2(int cantMin2) {
        this.cantMin2 = cantMin2;
        return this;
    }

    public MenuBuilder withPrecioCantMin2(int precioCantMin2) {
        this.precioCantMin2 = precioCantMin2;
        return this;
    }

    public MenuBuilder withCantidadMaxVentasXDia(int cantidadMaxVentasXDia) {
        this.cantidadMaxVentasXDia = cantidadMaxVentasXDia;
        return this;
    }

}
