/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import heroes.Heroe;
import interfaces.ServicioMensajeria;

/**
 * Clase encargada de gestionar la asignación de misiones a los héroes.
 *
 * <p>Esta clase aplica el principio de Inversión de Dependencias (DIP),
 * ya que depende de la abstracción {@link ServicioMensajeria} y no de una
 * implementación concreta.</p>
 *
 * <p>Su responsabilidad principal es:</p>
 * <ul>
 *     <li>Validar si un héroe puede realizar una misión.</li>
 *     <li>Notificar el resultado mediante un servicio de mensajería.</li>
 *     <li>Lanzar una excepción si la misión no es compatible.</li>
 * </ul>
 *
 * @author Juanes
 * @version 1.0
 */
public class AsignarMision {

    /**
     * Servicio utilizado para enviar notificaciones
     * sobre el estado de la misión.
     */
    private ServicioMensajeria servicio;

    /**
     * Constructor que recibe el servicio de mensajería
     * mediante inyección de dependencias.
     *
     * @param servicio Implementación del servicio de mensajería
     *                 (por ejemplo, Telegram, Email, etc.).
     */
    public AsignarMision(ServicioMensajeria servicio) {
        this.servicio = servicio;
    }

    /**
     * Asigna una misión a un héroe y notifica el resultado.
     *
     * <p>Si el héroe cumple con la habilidad requerida, la misión es
     * marcada como <b>APROBADA</b>. En caso contrario, se marca como
     * <b>RECHAZADA</b> y se lanza una excepción.</p>
     *
     * @param heroe  Héroe al que se le intentará asignar la misión.
     * @param mision Misión que se desea asignar.
     * @throws MisionNoCompatibleException Si el héroe no puede realizar la misión.
     */
    public void asignar(Heroe heroe, Mision mision)
            throws MisionNoCompatibleException {

        String estado;
        String icono;

        // Validar compatibilidad entre héroe y misión
        if (heroe.puedeRealizar(mision)) {
            estado = "APROBADA";
            icono = "✅";
        } else {
            estado = "RECHAZADA";
            icono = "❌";
        }

        // Construcción del mensaje formateado
        String mensaje = """
                🦸 HÉROE: %s
                🎯 MISIÓN: %s
                🔎 Habilidad requerida: %s
                %s ESTADO: %s
                ---------------------------------
              """
                .formatted(
                        heroe.getNombre(),
                        mision.getNombre(),
                        mision.getHabilidadRequerida().getNombre(),
                        icono,
                        estado
                );

        // Envío de notificación
        servicio.enviar(mensaje);

        // Lanzar excepción si la misión no es compatible
        if (!heroe.puedeRealizar(mision)) {
            throw new MisionNoCompatibleException(
                    "El héroe no puede realizar esta misión"
            );
        }
    }
}