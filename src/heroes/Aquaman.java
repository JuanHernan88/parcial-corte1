package heroes;

import java.util.List;
import interfaces.Habilidad;

public class Aquaman extends Heroe {

    public Aquaman() {
        super("Aquaman", crearHabilidades());
    }

    private static List<Habilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("Acuatica"),
            new HabilidadBasica("Fuerza")
        );
    }
}