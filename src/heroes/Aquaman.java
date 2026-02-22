package heroes;

import java.util.ArrayList;

public class Aquaman extends Heroe {

    public Aquaman() {
        super("Aquaman", new ArrayList<>());

        habilidades.add(new HabilidadBasica("Acuatica"));
        habilidades.add(new HabilidadBasica("Fuerza"));
    }
}