package desappgroupd.Exceptions;

public class ProveedorSinCreditoSuficiente extends RuntimeException {
    public ProveedorSinCreditoSuficiente(){
        super("El importe que intenta retirar supera el credito actual");
    }
}
