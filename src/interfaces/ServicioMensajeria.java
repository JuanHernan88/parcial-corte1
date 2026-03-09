package interfaces;

/**
 * Interfaz que define el servicio de mensajería
 * para enviar notificaciones del sistema.
 * 
 * @author Maribel Ceballos 
 */
public interface ServicioMensajeria {

    /**
     * Envía un mensaje.
     */
    void enviarMensaje(String mensaje);

}