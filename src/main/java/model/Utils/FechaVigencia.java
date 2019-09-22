package model.Utils;

import java.util.Date;

public class FechaVigencia {

    Date fechaDesde;
    Date fechaHasta;

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


