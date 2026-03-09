package heroes;

import java.util.Arrays;
import java.util.List;
import misiones.TipoHabilidad;

public class SpiderMan extends Heroe {

    public SpiderMan(String nombre) {
        super(nombre);
    }

    @Override
    public List<TipoHabilidad> getHabilidades() {

        return Arrays.asList(
                TipoHabilidad.TREPAR,
                TipoHabilidad.SIGILO
        );

    }

}