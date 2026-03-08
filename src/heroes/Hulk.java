package heroes;

import java.util.List;
import interfaces.IHabilidad;

public class Hulk extends Heroe {

    public Hulk() {
        super("Hulk", crearHabilidades());
    }

    private static List<IHabilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("Fuerza"),
            new HabilidadBasica("Resistencia")
        );
    }
}
