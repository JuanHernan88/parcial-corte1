package Mensajeria;

import Interfaces.ServicioMensajeria;

public class ServicioEmail implements ServicioMensajeria {

    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando email: " + mensaje);
    }
}
