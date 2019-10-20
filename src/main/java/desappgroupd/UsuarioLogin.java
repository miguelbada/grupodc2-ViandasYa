package desappgroupd;

import java.util.List;

public class UsuarioLogin {
    private String password;
    private String email;

    public UsuarioLogin(){}

    public UsuarioLogin(String email, String pass){
        this.password = pass ;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static Usuario getUsuarioByNameAndPass(UsuarioLogin userLogin , List<Usuario> users){
        /*retorno el usuario que tenga el email y el pass correspodiente al userLogin*/
        Usuario res = null;
        for (Usuario user: users){
            if(user.getEmail().equals(userLogin.getEmail())&& user.getPassword().equals(userLogin.getPassword())){
                res = user ;
            }
        }

        return res;
    }
}
