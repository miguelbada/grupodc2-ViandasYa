package controller;


import desappgroupd.Exceptions.UsuarioNotFoundException;
import desappgroupd.Usuario;
import desappgroupd.UsuarioLogin;
import desappgroupd.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioRepository repository;

    UsuarioController(UsuarioRepository userRepository) {
        this.repository = userRepository;
    }


    // Aggregate root

    @GetMapping("/usuarios")
    List<Usuario> getAll() {
        /*get all users from repository of Users*/
        return (List<Usuario>) repository.findAll();
    }

    @PostMapping("/usuarios")
    Usuario newUsuario(@RequestBody Usuario newUsuario) {
        /* Create a new user */
        return repository.save(newUsuario);
    }


    // Single item

    @GetMapping("/usuarios/{id}")
    Usuario getOne(@PathVariable Long id) {
        /* get one user by id*/

        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @PutMapping("/usuarios/{id}")
    Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
     /*Update all attributes of a user by id */
        return repository.findById(id)
                .map(usuario -> {
                    usuario.setNombreYApellido(newUsuario.getNombreYApellido());
                    usuario.setCredito(newUsuario.getCredito());
                    usuario.setEmail(newUsuario.getEmail());
                    usuario.setLocalidadYDireccion(newUsuario.getLocalidadYDireccion());
                    usuario.setTelefono(newUsuario.getTelefono());
                    usuario.setCuenta(newUsuario.getCuenta());
                    return repository.save(usuario);
                })
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @DeleteMapping("/usuarios/{id}")
    void deleteUsuario(@PathVariable Long id) {
        /* Delete a user by id */
        repository.deleteById(id);
    }
    @CrossOrigin
    @PostMapping("/usuarios/login")
    Usuario loginUsuario(@RequestBody UsuarioLogin newUsuarioLogin) {

       List<Usuario> usuarios =  (List<Usuario>) repository.findAll();
       Usuario user = UsuarioLogin.getUsuarioByNameAndPass(newUsuarioLogin,usuarios);
        System.out.print("Usuario con Email: " + user);
        return user;
    }
}
