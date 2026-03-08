package heroes;

import misiones.Mision;

import java.util.List;
import java.util.Objects;
import interfaces.IAsignable;
import interfaces.IHabilidad;
import interfaces.IIdentificable;
import interfaces.INotificable;

public abstract class Heroe implements IIdentificable, IAsignable, INotificable {

    private final String nombre;
    private final List<IHabilidad> habilidades;

    public Heroe(String nombre, List<IHabilidad> habilidades) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre del heroe no puede ser null");
        this.habilidades = Objects.requireNonNull(habilidades, "La lista de habilidades no puede ser null");
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeRealizar(Mision mision) {

        for (IHabilidad habilidad : habilidades) {
            if (habilidad.getNombre()
                    .equalsIgnoreCase(mision.getHabilidadRequerida().getNombre())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificando a " + nombre + ": " + mensaje);
    }
}