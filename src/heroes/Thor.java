package heroes;

import interfaces.Habilidad;
import java.util.List;

public class Thor extends Heroe {

    public Thor() {
        super("Thor", crearHabilidades());
    }

    private static List<Habilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("ControlDeTrueno"),
            new HabilidadBasica("Volar")
        );
    }
}