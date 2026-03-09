package heroes;

import java.util.Arrays;
import java.util.List;
import misiones.TipoHabilidad;

public class Aquaman extends Heroe {

    public Aquaman(String nombre) {
        super(nombre);
    }

    @Override
    public List<TipoHabilidad> getHabilidades() {

        return Arrays.asList(
                TipoHabilidad.ACUATICO,
                TipoHabilidad.FUERZA
        );

    }

}