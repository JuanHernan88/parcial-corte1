package heroes;

import java.util.List;

import interfaces.IHabilidad;

public class Aquaman extends Heroe {

    public Aquaman() {
        super("Aquaman", crearHabilidades());
    }

    private static List<IHabilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("Acuatica"),
            new HabilidadBasica("Fuerza")
        );
    }
}