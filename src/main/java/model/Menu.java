package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Menu {
    String nombre;
    String descripcion;
    String categoria;
    int valorDelirevy;
    Map<Date,Date> fechasVigencias;
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
    }


}
