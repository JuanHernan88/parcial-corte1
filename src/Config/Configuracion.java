package config;

import interfaces.ServicioMensajeria;
import mensajeria.ServicioEmail;

public class Configuracion {

    public static ServicioMensajeria crearServicio() {
        return new ServicioEmail();
    }
}
