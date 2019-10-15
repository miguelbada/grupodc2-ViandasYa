package desappgroupd.Exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("No Se pudo encotrar al usuario con ID: " + id);
    }
}
