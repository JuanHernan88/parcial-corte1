package heroes;

import interfaces.Habilidad;
import java.util.List;

public class IronMan extends Heroe {

    public IronMan() {
        super("IronMan", crearHabilidades());
    }

    private static List<Habilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("Volar"),
            new HabilidadBasica("Tecnologia"),
            new HabilidadBasica("DisparoEnergetico")
        );
    }
}
