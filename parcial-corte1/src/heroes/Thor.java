package heroes;

import java.util.List;

import interfaces.IHabilidad;

public class Thor extends Heroe {

    public Thor() {
        super("Thor", crearHabilidades());
    }

    private static List<IHabilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("ControlDeTrueno"),
            new HabilidadBasica("Volar")
        );
    }
}