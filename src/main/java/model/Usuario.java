package model;

public class Usuario {

    String nombreYApellido;
    String eMail;
    int telefono;
    String localidadDIreccion;
    int credito;

    public  Usuario(String name){
        this.nombreYApellido = name;
    }

    public  void setNombreYApellido(String  name){
        this.nombreYApellido = name;
    }

    public String  getNombreYApellido(){
        return this.nombreYApellido;
    }


    public void seteMail(String email){
        this.eMail = email;
    }

    public String geteMail(){
        return this.eMail;
    }

    public void setTelefono(int tel){
        this.telefono = tel;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public void setLocalidadDIreccion(String local){
        this.localidadDIreccion = local;
    }

    public String getLocalidadDIreccion() {
        return localidadDIreccion;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getCredito() {
        return credito;
    }
}
