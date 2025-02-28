package co.edu.uniquindio.banco.bancouq.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private List<UserLog> usuarios;

    //Creamos un constructor que inicializa la lista de usuarios
    //Simulamos la base de datos creando multiples usuario con diferentes roles para comprobar el acceso a los tabs
    public LoginService() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new UserLog("jacobo", "jacobo123","admin"));
        usuarios.add(new UserLog("hernan", "hernan123","usuario"));
        usuarios.add(new UserLog("luis", "luis123","empleado"));
    }

    public UserLog login(String usName, String passwd) {
        for (UserLog usuario : usuarios) {
            try {
                if (usuario.getUsName().equals(usName) && usuario.checkPasswd(passwd)) {
                    return usuario;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
