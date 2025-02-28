package co.edu.uniquindio.banco.bancouq.model;

import co.edu.uniquindio.banco.bancouq.controller.ModelFactoryController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UserLog {
    private String usName;
    private String passwd;

    private String rol;

    private static final Logger LOGGER = Logger.getLogger(UserLog.class.getName());


    public UserLog(String usName, String passwd, String rol) {
        this.usName = usName;
        this.passwd = passwd;
        this.rol = rol;
    }

    public String getUsName()
    {
        return usName;
    }

    public String getRol() {
        return rol;
    }

    public boolean checkPasswd(String passwd) throws IOException {
        FileHandler archivoLogger = new FileHandler("src/main/resources/persistencia/log/logproyecto_LOG.txt", true);
        archivoLogger.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(archivoLogger);
        LOGGER.info("Ingreso el usuraio: "+getUsName()+", a las "+ LocalDateTime.now());
        return this.passwd.equals(passwd);
    }
}