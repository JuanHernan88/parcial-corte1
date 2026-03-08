package heroes;

import java.util.List;
import interfaces.IHabilidad;

public class SpiderMan extends Heroe {

    public SpiderMan() {
        super("SpiderMan", crearHabilidades());
    }

    private static List<IHabilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("TreparMuros"),
            new HabilidadBasica("Agilidad"),
            new HabilidadBasica("SentidoAracnido")
        );
    }
}