package heroes;

import interfaces.Habilidad;
import java.util.List;

public class Hulk extends Heroe {

    public Hulk() {
        super("Hulk", crearHabilidades());
    }

    private static List<Habilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("Fuerza"),
            new HabilidadBasica("Resistencia")
        );
    }
}
