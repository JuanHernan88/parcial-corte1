package misiones;

import heroes.Heroe;
import interfaces.ServicioMensajeria;
import java.util.List;

/**
 * Clase encargada de asignar misiones a los héroes.
 * 
 * @author Maribel ceballos 
 */
public class AsignarMision {

    private ServicioMensajeria servicio;

    /**
     * Constructor que recibe el servicio de mensajería.
     */
    public AsignarMision(ServicioMensajeria servicio){
        this.servicio = servicio;
    }

    /**
     * Asigna una misión a un héroe con la habilidad requerida.
     */
    public Heroe asignar(Mision mision, List<Heroe> heroes)
            throws MisionNoCompatibleException {

        for (Heroe h : heroes) {

            if (h.tieneHabilidad(mision.getHabilidad())) {

                servicio.enviarMensaje(
                        "NUEVA MISION\n"
                        + "Heroe: " + h.getNombre()
                        + "\nMision: " + mision.getNombre()
                );

                return h;
            }

        }

        throw new MisionNoCompatibleException();

    }

}