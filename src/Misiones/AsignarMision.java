
package misiones;

import heroes.Heroe;
import interfaces.ServicioMensajeria;
import java.util.List;

public class AsignarMision {

    private ServicioMensajeria servicio;

    public AsignarMision(ServicioMensajeria servicio){
        this.servicio = servicio;
    }

   public Heroe asignar(Mision mision, List<Heroe> heroes)
        throws MisionNoCompatibleException {

    for (Heroe h : heroes) {

        if (h.tieneHabilidad(mision.getHabilidad())) {

            servicio.enviarMensaje(
                    "🚨 NUEVA MISION\n"
                    + "Heroe: " + h.getNombre()
                    + "\nMision: " + mision.getNombre()
            );

            return h;
        }

    }

    throw new MisionNoCompatibleException();

}

}