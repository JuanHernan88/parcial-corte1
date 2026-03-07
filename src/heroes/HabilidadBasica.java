package heroes;

import interfaces.Habilidad;
import java.util.Objects;

/**
 * Representa una habilidad básica que puede tener un héroe.
 */
public class HabilidadBasica implements Habilidad {

    private final String nombre;

    public HabilidadBasica(String nombre) {
        Objects.requireNonNull(nombre, "El nombre de la habilidad no puede ser null");

        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la habilidad no puede estar vacío");
        }

        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}