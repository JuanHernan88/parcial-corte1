package heroes;

import java.util.ArrayList;

public class SpiderMan extends Heroe {

    public SpiderMan() {
        super("SpiderMan", new ArrayList<>());

        habilidades.add(new HabilidadBasica("TreparMuros"));
        habilidades.add(new HabilidadBasica("Agilidad"));
        habilidades.add(new HabilidadBasica("SentidoAracnido"));
    }
}