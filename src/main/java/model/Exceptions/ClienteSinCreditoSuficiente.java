package model.Exceptions;

public class ClienteSinCreditoSuficiente extends RuntimeException {
    public ClienteSinCreditoSuficiente() {
        super("La compra que intenta realizar supera el credito disponible");
    }

}
