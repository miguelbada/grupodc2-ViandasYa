package desappgroupd;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class FechaVigencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yy hh:mm:ss")
    private Date fechaDesde;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yy hh:mm:ss")
    private Date fechaHasta;

    public  FechaVigencia(Date fechaD, Date fechaH){
        this.fechaDesde = fechaD;
        this.fechaHasta = fechaH;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}


