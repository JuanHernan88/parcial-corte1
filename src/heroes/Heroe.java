package heroes;

import misiones.Mision;

import java.util.List;
import interfaces.IAsignable;
import interfaces.IHabilidad;
import interfaces.IIdentificable;
import interfaces.INotificable;

/**
 * Clase abstracta que representa un héroe dentro del sistema.
 *
 * <p>Un héroe posee un nombre y un conjunto de habilidades que
 * determinan si puede realizar una misión específica.</p>
 *
 * <p>Esta clase implementa múltiples interfaces:
 * <ul>
 *     <li>{@link IIdentificable} → Permite obtener su nombre.</li>
 *     <li>{@link IAsignable} → Define si puede realizar una misión.</li>
 *     <li>{@link INotificable} → Permite enviar notificaciones al héroe.</li>
 * </ul>
 *
 * <p>Al ser abstracta, debe ser extendida por tipos concretos
 * de héroes (por ejemplo: HeroeTerrestre, HeroeVolador, etc.).</p>
 *
 * @author Jacobo
 * @version 1.0
 */
public abstract class Heroe implements IIdentificable, IAsignable, INotificable {

    /**
     * Nombre del héroe.
     */
    protected String nombre;

    /**
     * Lista de habilidades que posee el héroe.
     */
    protected List<IHabilidad> habilidades;

    /**
     * Constructor del héroe.
     *
     * @param nombre      Nombre del héroe.
     * @param habilidades Lista de habilidades asociadas al héroe.
     */
    public Heroe(String nombre, List<IHabilidad> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    /**
     * Retorna el nombre del héroe.
     *
     * @return Nombre del héroe.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Verifica si el héroe puede realizar una misión específica.
     *
     * <p>La validación se realiza comparando las habilidades del héroe
     * con la habilidad requerida por la misión.</p>
     *
     * @param mision Misión a evaluar.
     * @return true si el héroe posee la habilidad requerida,
     *         false en caso contrario.
     */
    @Override
    public boolean puedeRealizar(Mision mision) {

        for (int i = 0; i < habilidades.size(); i++) {
            if (habilidades.get(i).getNombre()
                    .equalsIgnoreCase(
                            mision.getHabilidadRequerida().getNombre())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Notifica al héroe con un mensaje determinado.
     *
     * <p>Actualmente la notificación se muestra por consola,
     * pero puede ser sobreescrita por clases hijas para
     * implementar otros mecanismos (correo, app, etc.).</p>
     *
     * @param mensaje Texto de la notificación.
     */
    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificando a " + nombre + ": " + mensaje);
    }
}