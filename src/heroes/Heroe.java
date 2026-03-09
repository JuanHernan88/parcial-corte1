
package heroes;

import misiones.TipoHabilidad;
import java.util.ArrayList;
import java.util.List;

public class Heroe {

    protected String nombre;
    protected List<TipoHabilidad> habilidades;

    public Heroe(String nombre) {

        this.nombre = nombre;
        this.habilidades = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void agregarHabilidad(TipoHabilidad habilidad) {
        habilidades.add(habilidad);
    }

    public boolean tieneHabilidad(TipoHabilidad habilidad) {
        return habilidades.contains(habilidad);
    }

}