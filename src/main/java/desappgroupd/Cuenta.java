package desappgroupd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    int credito = 0;
    //ArrayList<Pedido> historial = new ArrayList<Pedido>();

    public Cuenta(){

    }

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
