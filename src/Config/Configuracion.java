package config;

import mensajeria.ServicioEmail;
import interfaces.IServicioMensajeria;

public class Configuracion {

    public static IServicioMensajeria crearServicio() {
        return new ServicioEmail();
    }
}
