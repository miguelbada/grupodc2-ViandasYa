package model;

import java.util.ArrayList;

public class Cuenta {

    int credito = 0;
    //ArrayList<Pedido> historial = new ArrayList<Pedido>();

    public Cuenta(){

    };

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }


    public void agregarCredito(int credito) {
        this.credito += credito;
    }

    public void descontarCredito() {
        this.credito -= credito;
    }

}
