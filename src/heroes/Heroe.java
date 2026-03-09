
package heroes;

import misiones.TipoHabilidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase base que representa un héroe del sistema.
 * Cada héroe tiene un nombre y una lista de habilidades.
 * 
 * @author juan jacobo cañas henao
 */
public class Heroe {

    protected String nombre;
    protected List<TipoHabilidad> habilidades;

    /**
     * Constructor del héroe.
     */
    public Heroe(String nombre) {

        this.nombre = nombre;
        this.habilidades = new ArrayList<>();

    }

    /**
     * Devuelve el nombre del héroe.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega una habilidad al héroe.
     */
    public void agregarHabilidad(TipoHabilidad habilidad) {
        habilidades.add(habilidad);
    }

    /**
     * Verifica si el héroe tiene una habilidad específica.
     */
    public boolean tieneHabilidad(TipoHabilidad habilidad) {
        return habilidades.contains(habilidad);
    }

}