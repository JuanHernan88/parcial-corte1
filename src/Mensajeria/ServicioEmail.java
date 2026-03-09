package mensajeria;

import interfaces.IServicioMensajeria;

public class ServicioEmail implements IServicioMensajeria {

    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando email: " + mensaje);
    }
}
