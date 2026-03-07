package heroes;

import interfaces.Habilidad;
import java.util.List;

public class SpiderMan extends Heroe {

    public SpiderMan() {
        super("SpiderMan", crearHabilidades());
    }

    private static List<Habilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("TreparMuros"),
            new HabilidadBasica("Agilidad"),
            new HabilidadBasica("SentidoAracnido")
        );
    }
}