package config;

import interfaces.ServicioMensajeria;
import mensajeria.ServicioEmail;
import mensajeria.ServicioTelegram;

public class Configuracion {

    public static ServicioMensajeria crearServicio(String tipo) {

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
