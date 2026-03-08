package config;

import mensajeria.ServicioEmail;
import mensajeria.ServicioTelegram;
import interfaces.IServicioMensajeria;

public class Configuracion {

    public static IServicioMensajeria crearServicio(String tipo) {

        switch (tipo) {

            case "EMAIL":
                return new ServicioEmail("misiones@shield.com");

            case "TELEGRAM":
                return new ServicioTelegram("TOKEN", "CHATID");

            default:
                throw new IllegalArgumentException("Servicio no soportado");
        }
    }
}
