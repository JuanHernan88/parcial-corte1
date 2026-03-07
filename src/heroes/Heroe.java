package heroes;

import interfaces.Asignable;
import interfaces.Habilidad;
import interfaces.Identificable;
import interfaces.Notificable;
import misiones.Mision;

import java.util.List;
import java.util.Objects;

public abstract class Heroe implements Identificable, Asignable, Notificable {

    private final String nombre;
    private final List<Habilidad> habilidades;

    public Heroe(String nombre, List<Habilidad> habilidades) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre del heroe no puede ser null");
        this.habilidades = Objects.requireNonNull(habilidades, "La lista de habilidades no puede ser null");
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeRealizar(Mision mision) {

        for (Habilidad habilidad : habilidades) {
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