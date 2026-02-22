package Config;

import Interfaces.ServicioMensajeria;
import Mensajeria.ServicioEmail;

public class Configuracion {

    public static ServicioMensajeria crearServicio() {
        return new ServicioEmail();
    }
}
