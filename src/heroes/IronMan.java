package heroes;

import java.util.Arrays;
import java.util.List;
import misiones.TipoHabilidad;

public class IronMan extends Heroe {

    public IronMan(String nombre) {
        super(nombre);
    }

    @Override
    public List<TipoHabilidad> getHabilidades() {

        return Arrays.asList(
                TipoHabilidad.VOLAR,
                TipoHabilidad.FUEGO
        );

    }

}
