package heroes;

import java.util.List;
import misiones.TipoHabilidad;

public abstract class Heroe {

    protected String nombre;

    public Heroe(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract List<TipoHabilidad> getHabilidades();

}