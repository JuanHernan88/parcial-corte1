package heroes;

import java.util.ArrayList;

public class Hulk extends Heroe {

    public Hulk() {
        super("Hulk", new ArrayList<>());

        habilidades.add(new HabilidadBasica("Fuerza"));
        habilidades.add(new HabilidadBasica("Resistencia"));
    }
}
