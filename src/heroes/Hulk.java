package heroes;

import java.util.Arrays;
import java.util.List;
import misiones.TipoHabilidad;

public class Hulk extends Heroe {

    public Hulk(String nombre) {
        super(nombre);
    }

    @Override
    public List<TipoHabilidad> getHabilidades() {

        return Arrays.asList(
                TipoHabilidad.FUERZA
        );

    }

}