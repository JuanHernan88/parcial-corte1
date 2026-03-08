package mensajeria;

import interfaces.IServicioMensajeria;


public class ServicioEmail implements IServicioMensajeria {

    private String destinatario;

    /**
     * Constructor del servicio de email.
     *
     * @param destinatario dirección de correo del receptor
     */
    public ServicioEmail(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Envía un mensaje al destinatario configurado.
     *
     * @param mensaje contenido del mensaje
     */
    @Override
    public void enviar(String mensaje) {

        if (mensaje == null || mensaje.isEmpty()) {
            System.out.println("No se puede enviar un mensaje vacío.");
            return;
        }

        System.out.println("Enviando email a " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Email enviado correctamente\n");
    }
}