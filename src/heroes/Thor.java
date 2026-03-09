package heroes;

import java.util.Arrays;
import java.util.List;
import misiones.TipoHabilidad;

public class Thor extends Heroe {

    public Thor(String nombre) {
        super(nombre);
    }

    @Override
    public List<TipoHabilidad> getHabilidades() {

        return Arrays.asList(
                TipoHabilidad.FUERZA,
                TipoHabilidad.VOLAR,
                TipoHabilidad.FUEGO
        );

    }

}