package heroes;

import interfaces.Asignable;
import interfaces.Habilidad;
import interfaces.Identificable;
import interfaces.Notificable;
import misiones.Mision;

import java.util.List;

/**
 * Clase abstracta que representa un héroe dentro del sistema.
 *
 * <p>Un héroe posee un nombre y un conjunto de habilidades que
 * determinan si puede realizar una misión específica.</p>
 *
 * <p>Esta clase implementa múltiples interfaces:
 * <ul>
 *     <li>{@link Identificable} → Permite obtener su nombre.</li>
 *     <li>{@link Asignable} → Define si puede realizar una misión.</li>
 *     <li>{@link Notificable} → Permite enviar notificaciones al héroe.</li>
 * </ul>
 *
 * <p>Al ser abstracta, debe ser extendida por tipos concretos
 * de héroes (por ejemplo: HeroeTerrestre, HeroeVolador, etc.).</p>
 *
 * @author Jacobo
 * @version 1.0
 */
public abstract class Heroe implements Identificable, Asignable, Notificable {

    /**
     * Nombre del héroe.
     */
    protected String nombre;

    /**
     * Lista de habilidades que posee el héroe.
     */
    protected List<Habilidad> habilidades;

    /**
     * Constructor del héroe.
     *
     * @param nombre      Nombre del héroe.
     * @param habilidades Lista de habilidades asociadas al héroe.
     */
    public Heroe(String nombre, List<Habilidad> habilidades) {
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